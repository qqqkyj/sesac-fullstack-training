package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Post{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // BIGINT AUTO_INCREMENT PRIMARY KEY
    private Long id;

    @Column(nullable = false, length = 100) // VARCHAR(100) NOT NULL
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") // TEXT NOT NULL
    private String content;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

//    @BatchSize(size = 10)
    @OneToMany(mappedBy = "post", //누가 관계의 주인인지 설정
            cascade = CascadeType.REMOVE, //게시물(부모)가 삭제되면 댓글(자식)도 삭제
            orphanRemoval = true // 고아 객체 생성시 삭제
    )
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 생성 시점에 자동으로 현재 시간을 설정
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    //연관관계 편의메서드
    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
        comment.setPost(null);
    }
}
