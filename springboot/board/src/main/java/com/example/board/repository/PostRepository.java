package com.example.board.repository;

import com.example.board.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //CrudRepository인퍼페이스, PagingAndSortingRepository(페이징 처리)

    // 저장 (INSERT OR UPDATE)
    //Post save(Post entity); : save() -> id is not null : update, id is null : create

    //조회
    //Optional<Post> findById(Long id);
    //List<Post> findAll();
    //List<Post> findAll(Sort sort); : 정렬

    //삭제
    //void deleteById(Long id);
    //void delete(Post entity);

    //개수 조회
    //long count();

    //존재 여부 확인
    //boolean existById(Long id);

    // findBy + 필드 이름 + 조건

    // LIKE %keyword%
    List<Post> findByTitleContaining(String keyword);

    // LIKE keyword%
    List<Post> findByTitleStartingWith(String keyword);

    // >
    List<Post> findByIdGreaterThan(Long id);

    // ORDER BY id DESC
    List<Post> findAllByOrderByIdDesc();

    // 제목 or 내용으로 검색 : 장점(편함), 단점(복잡한쿼리는 메서드명이 길어짐)
    List<Post> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);

    //JPQL(Java Persistence Query Language)
    //@Query 방식
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword%")
    List<Post> searchByTitle(@Param("keyword") String keyword);

    // search title or content
    @Query("""
        SELECT p 
        FROM Post p 
        WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword% 
        ORDER BY p.createdAt DESC
    """)
    List<Post> searchByKeyword(@Param("keyword") String keyword);

    //native Query 사용하는 법
    @Query(value = """
        SELECT * 
        FROM post 
        WHERE title LIKE %:keyword% 
        ORDER BY id DESC
     """
            , nativeQuery = true)
    List<Post> searchByTitleNative(@Param("keyword") String keyword);

    // 최근 게시물 3개만 출력
    // /post/recent
    // 1. query method
    List<Post> findTop3ByOrderByCreatedAtDesc();

    // 2.jpql
    @Query("""
    SELECT p
    FROM Post p
    ORDER BY p.createdAt DESC
    """)
    List<Post> searchRecentPostsJPQL(Pageable pageable);

    // 3. native sql
    @Query(value = """
    SELECT *
    FROM post
    ORDER BY created_at DESC
    LIMIT 3
    """, nativeQuery = true)
    List<Post> findRecentPostsNative();


    //페이징처리
    //List<Post> findAll() => JpaRepository가 구현 해둔 메서드
    // 오버로딩(동일한 이름이지만 매개변수가 다름)
    Page<Post> findAll(Pageable pageable);

    Page<Post> findByTitleContaining(Pageable pageable, String keyword);

    Slice<Post> findAllBy(Pageable pageable);

    //findAll() => Jpa 자동생성
    //Comment를 조인한 Post
    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.comments")
    List<Post> findAllWithComments();

    @EntityGraph(attributePaths = {"comments"})
    @Query("SELECT p FROM Post p")
    List<Post> findAllWithCommentsEntityGraph();
}
