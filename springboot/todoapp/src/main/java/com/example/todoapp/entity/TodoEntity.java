package com.example.todoapp.entity;

import jakarta.persistence.*;

// 디비 스키마 구성과 유사
// 실제 디비와 연결되는 클래스
@Entity
@Table(name="todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoIncrement 유사
    private Long id;
    private String title;
    private String content;
    private boolean completed;

    public TodoEntity() {
    }

    // id는 자동생성이라 빼도 됨
    public TodoEntity(String title, String content, boolean completed) {
        this.completed = completed;
        this.content = content;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
