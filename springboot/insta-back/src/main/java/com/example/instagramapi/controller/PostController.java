package com.example.instagramapi.controller;

import com.example.instagramapi.dto.request.CommentCreateRequest;
import com.example.instagramapi.dto.request.PostCreateRequest;
import com.example.instagramapi.dto.response.ApiResponse;
import com.example.instagramapi.dto.response.CommentResponse;
import com.example.instagramapi.dto.response.LikeResponse;
import com.example.instagramapi.dto.response.PostResponse;
import com.example.instagramapi.security.CustomUserDetails;
import com.example.instagramapi.service.CommentService;
import com.example.instagramapi.service.PostLikeService;
import com.example.instagramapi.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final PostLikeService postLikeService;

    //게시물 생성
    @PostMapping
    public ResponseEntity<ApiResponse<PostResponse>> create(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @Valid @RequestBody PostCreateRequest request
            ){
        PostResponse response = postService.create(userDetails.getId(),  request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    //게시물 전체 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponse>>> findAll(){
        List<PostResponse> list = postService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(list));
    }

    //단일 게시물 조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> findById(@PathVariable Long id){
        PostResponse response = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(response));
    }

    //게시물 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        postService.delete(id, userDetails.getId());
        return ResponseEntity.noContent().build();
    }

    //댓글 생성
    @PostMapping("/{id}/comments")
    public ResponseEntity<ApiResponse<CommentResponse>> createComment(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @Valid @RequestBody CommentCreateRequest request
    ){
        CommentResponse response = commentService.create(id,userDetails.getId(), request);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    //특정 게시물의 댓글 목록
    @GetMapping("/{id}/comments")
    public ResponseEntity<ApiResponse<List<CommentResponse>>> getComments(
            @PathVariable Long id
    ){
        List<CommentResponse> comments = commentService.findbyPostId(id);
        return ResponseEntity.ok(ApiResponse.success(comments));
    }

    // 댓글 삭제
    @DeleteMapping("/{id}/comments/{commentId}")
    public ResponseEntity<Void> deleteComments(
            @PathVariable Long commentId,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        commentService.delete(commentId, userDetails.getId());
        return ResponseEntity.noContent().build();
    }

    //좋아요 생성
    @PostMapping("{id}/like")
    public ResponseEntity<ApiResponse<LikeResponse>> like(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        LikeResponse response = postLikeService.like(id, userDetails.getId());
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    //좋아요 삭제
    @DeleteMapping("{id}/like")
    public ResponseEntity<ApiResponse<LikeResponse>> unlike(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        LikeResponse response = postLikeService.unlike(id, userDetails.getId());
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
