package com.example.todoapp.repository;

import com.example.todoapp.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByTitleContaining(String keyword);
    List<TodoEntity> findByCompleted(boolean completed);
    long count();
    long countByCompleted(boolean completed);
    void deleteByCompleted(boolean completed);
//    @Modifying
//    @Query("DELETE FROM TodoEntity t WHERE t.completed = true")
//    void deleteCompleted();
}
