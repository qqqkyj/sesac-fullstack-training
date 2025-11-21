package com.example.todoapp;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.entity.TodoEntity;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }

    // sample data
    // springboot 실행 시 작동
    @Bean
    public CommandLineRunner init(TodoRepository todoRepository) {
        return args -> {
            todoRepository.save(new TodoEntity("Study", "Java", false));
            todoRepository.save(new TodoEntity( "Cook", "kimbob", true));
            todoRepository.save(new TodoEntity("workout", "run", false));
        };
    }
}
