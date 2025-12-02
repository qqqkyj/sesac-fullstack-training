package com.example.instagram.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @Builder
    public Post(String content, User user) {
        this.content = content;
        this.user = user;
    }
}
