package com.example.board.service;

import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)//클래스에 사용하면 모든 메서드에 붙이는 것과 같음, 읽기 전용
public class PostService {

    private final PostRepository postRepository;

    @Transactional // default는 readOnly = false
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        return postRepository.update(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }

    @Transactional
    public void testFirstLevelCache() {
        Post post1 = postRepository.findById(1L);
        System.out.println(post1.getTitle());
        Post post2 = postRepository.findById(1L);
        System.out.println(post2.getTitle());
        System.out.println(post1 == post2);
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContaining(keyword);
    }

    // 쓰기 지연
    @Transactional
    public void testWriteBehind() {
        Post post1 = postRepository.findById(1L);

        post1.setTitle("hello!!!");
        System.out.println("update1");

        post1.setTitle("hi!!!!");
        System.out.println("update2");

        post1.setTitle("bye!!!!");
        System.out.println("update3");

        System.out.println("transaction finish!!");
        // 메서드가 끝나면 save 실행
    }

    // 데이터 변경 여부 확인
    @Transactional
    public void testDirtyChecking(){
        Post post1 = postRepository.findById(1L);
        System.out.println("SELECT!!!");

        post1.setTitle("hello!!!");
        System.out.println("change title");
    }
}