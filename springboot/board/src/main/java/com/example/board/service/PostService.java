package com.example.board.service;

import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("post not found!"));
    }

    public List<Post> getAllPosts() {
        // ListPagingAndSortingRepository
        //return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return postRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }

    @Transactional
    public void testFirstLevelCache() {
        Post post1 = postRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("post not found!"));
        System.out.println(post1.getTitle());
        Post post2 = postRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("post not found!"));
        System.out.println(post2.getTitle());
        System.out.println(post1 == post2);
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContaining(keyword);
    }

    public List<Post> searchPostByTitleOrContent(String keyword){
        return postRepository.searchByTitleNative(keyword);
    }

    public List<Post> findTop3RecentPosts(){
        return postRepository.searchRecentPostsJPQL(PageRequest.of(0, 3));
    }

    public Page<Post> getPostPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Page<Post> searchPostsPage(Pageable pageable, String keyword) {
        return postRepository.findByTitleContaining(pageable, keyword);
    }

    public Slice<Post> getPostSlice(Pageable pageable) {
        return postRepository.findAllBy(pageable);
    }

    //자동 게시물 샘플 생성
    @Transactional
    public void createDummyPost(int count){
        for(int i = 1; i <= count; i++){
            Post post = new Post(i+"번째 제목", i+"번째 게시물 내용");
            postRepository.save(post);
        }
    }

    // 쓰기 지연
    @Transactional
    public void testWriteBehind() {
        Post post1 = postRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("post not found!"));

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
        Post post1 = postRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("post not found!"));
        System.out.println("SELECT!!!");

        post1.setTitle("hello!!!");
        System.out.println("change title");
    }

    public List<Post> getAllPostsWithFetchJoin() {
        return postRepository.findAllWithComments();
    }


    public List<Post> getAllPostsWithEntityGraph(){
        return postRepository.findAllWithCommentsEntityGraph();
    }
}