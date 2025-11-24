//package com.example.board.repository;
//
//import com.example.board.dto.PostDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor //final과 같은 필수 인자를 갖는 생성자
//public class PostRepository{
//    private final JdbcTemplate jdbcTemplate;
//
////    @RequiredArgsConstructor를 통해 자동생성
////    public PostRepository(JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
//
//    //데이터베이스의 각 행을 한 줄씩 가져와서 return
//    private final RowMapper<PostDTO> rowMapper = (rs, rowNum) -> {
//        return new PostDTO(
//                rs.getLong("id"),
//                rs.getString("title"),
//                rs.getString("content"),
//                rs.getTimestamp("created_at").toLocalDateTime()
//        );
//    };
//
//    //전체 조회
//    public List<PostDTO> findAll(){
//        String sql = "SELECT * FROM post";
//        // query => Statement
//        return jdbcTemplate.query(sql, rowMapper);
//    }
//
//    //상세 조회(id)
//    public PostDTO findById(Long id){
//        String sql = "SELECT * FROM post WHERE id = ?";
//        //queryForObject => PrepareStatement
//        return jdbcTemplate.queryForObject(sql, rowMapper, id);
//    }
//
//    //게시물 생성
//    public void save(PostDTO post) {
//        String sql = "INSERT INTO post (title, content) VALUES (?, ?)";
//        //update =>
//        jdbcTemplate.update(sql, post.getTitle(), post.getContent());
//    }
//
//    //게시물 수정
//    public void update(Long id, PostDTO post) {
//        String sql = "UPDATE post SET title=?, content=? WHERE id=?";
//        jdbcTemplate.update(sql, post.getTitle(), post.getContent(), id);
//    }
//
//    //게시물 삭제
//    public void deleteById(Long id){
//        String sql = "DELETE FROM post WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//}

// JDBC To JPA
package com.example.board.repository;

import com.example.board.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository{

    @PersistenceContext
    private EntityManager em;

    public Post save(Post post){
        em.persist(post);
        return post;
    }

    public Post findById(Long id){
        return em.find(Post.class, id);
    }

    public List<Post> findAll(){
        // EM => 단일 엔티티 조작만 기본 제공
        // SQL과 유사하지만 테이블이 아닌 엔티티 객체를 대상으로 쿼리를 작성
        String jpql = "SELECT p FROM Post p"; //Java Persistence Query Language
        return em.createQuery(jpql, Post.class).getResultList();
    }

    public Post update(Post post){
        return em.merge(post);
    }

    public void delete(Post post){
        em.remove(post);
    }

    // em(Entity Manager)
    // 1. 비영속
    // new Post("title", "content")
    // 데이터베이스 저장되기 전

    // 2. 영속
    // em.persist(post);
    // id가 부여됨

    // 3. 준영속 (detached 수정하는중)
    // em.detach(post)
    // 수정중

    // 4. 삭제
    // em.remove(post)
}