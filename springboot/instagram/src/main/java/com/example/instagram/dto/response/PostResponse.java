package com.example.instagram.dto.response;

import com.example.instagram.entity.Post;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponse {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String imageUrl;

    private Long userId;
    private String username;
    private String profileImageUrl;

    private long commentCount;
    private long likeCount;

    //Entity to DTO
    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .imageUrl(post.getImageUrl())
                .userId(post.getUser().getId())
                .username(post.getUser().getUsername())
                .profileImageUrl(post.getUser().getProfileImageUrl())
                .likeCount(0)
                .commentCount(0)
                .build();
    }

    //Entity to DTO
    public static PostResponse from(Post post, long commentCount, long likeCount) {
        return PostResponse.builder()
                .id(post.getId())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .imageUrl(post.getImageUrl())
                .userId(post.getUser().getId())
                .username(post.getUser().getUsername())
                .profileImageUrl(post.getUser().getProfileImageUrl())
                .likeCount(likeCount)
                .commentCount(commentCount)
                .build();
    }
}
