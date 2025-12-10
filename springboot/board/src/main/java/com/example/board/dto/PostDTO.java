package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //getter, setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 매개변수가 들어간 생성자
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
