package com.example.instagramapi.service;

import com.example.instagramapi.dto.request.PostCreateRequest;
import com.example.instagramapi.dto.response.PostResponse;
import com.example.instagramapi.entity.Post;
import com.example.instagramapi.entity.User;
import com.example.instagramapi.exception.CustomException;
import com.example.instagramapi.exception.ErrorCode;
import com.example.instagramapi.repository.PostLikeRepository;
import com.example.instagramapi.repository.PostRepository;
import com.example.instagramapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostLikeRepository postLikeRepository;

    //게시물 생성
    @Transactional
    public PostResponse create(Long userId, PostCreateRequest postCreateRequest){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        Post post = Post.builder()
                .content(postCreateRequest.getContent())
                .imageUrl(postCreateRequest.getImageUrl())
                .user(user)
                .build();
        Post saved = postRepository.save(post);
        return PostResponse.from(post);
    }

    //전체 게시물
    public List<PostResponse> findAll(Long currentUserId){
        List<Post> posts = postRepository.findAllWithUser();
        return posts.stream().map(post -> toPostResponseWithStatus(post, currentUserId)).toList();
    }

    //단일 게시물
    public PostResponse findById(Long postId){
        Post post = postRepository.findBypostIdWithUser(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        return PostResponse.from(post);
    }

    //특정 사용자 게시물
    public List<PostResponse> findAllByUserId(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        List<Post> posts = postRepository.findByUserIdWithUser(user.getId());
        return posts.stream().map(PostResponse::from).toList();
    }

    //게시물 삭제
    @Transactional
    public void delete(Long postId, Long userId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        if(!post.getUser().getId().equals(userId)){
            throw new CustomException(ErrorCode.NOT_POST_OWNER);
        }

        postRepository.delete(post);
    }

    //Post엔티티와 사용자 정보로 게시물의 상태 반환
    private PostResponse toPostResponseWithStatus(Post post, Long currentUserId){
        boolean liked = currentUserId != null
                && postLikeRepository.existsByUserIdAndPostId(currentUserId, post.getId());
        long likeCount = postLikeRepository.countByPostId(post.getId());
        long commentCount = post.getComments().size();
        return PostResponse.from(post, liked, likeCount, commentCount);
    }
}
