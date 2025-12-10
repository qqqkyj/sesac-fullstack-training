package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String content;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne // Many:자기자신(Comment), One:게시글(Post)
    @JoinColumn(name = "post_id")
    private Post post;
    
    @PrePersist //데이트 저장 전
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Comment(String content, Post post) {
        this.content = content;
        if(post != null) {
            post.addComment(this);
        }
    }
}
