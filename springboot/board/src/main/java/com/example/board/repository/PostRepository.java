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
}
