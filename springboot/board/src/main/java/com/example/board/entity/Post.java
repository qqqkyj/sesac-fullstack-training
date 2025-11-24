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
public class Post{
    @GeneratedValue(strategy= GenerationType.IDENTITY) // BIGINT AUTO_INCREMENT PRIMARY KEY
    private Long id;

    @Column(nullable = false, length = 100) // VARCHAR(100) NOT NULL
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") // TEXT NOT NULL
    private String content;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 생성 시점에 자동으로 현재 시간을 설정
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
