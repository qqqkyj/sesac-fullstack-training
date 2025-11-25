package com.example.board.repository;

import com.example.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
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

    List<Post> findByTitleContaining(String keyword);
}
