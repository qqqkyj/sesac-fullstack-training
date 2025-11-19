package com.example.todoapp.repository;

import com.example.todoapp.dto.TodoDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository
public class TodoRepository {
    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>(); //HashMap보다 멀티스레드 환경에서 안정적으로 작동
    private Long nextId = 1L;

    public TodoDto save(TodoDto todo) {
        if(todo.getId() == null){
            todo.setId(nextId++);
        }
        storage.put(todo.getId(), todo);
        return todo;
    }

    public List<TodoDto> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<TodoDto> findById(Long id) {
//        return storage.get(id);
        return Optional.ofNullable(storage.get(id));
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public List<TodoDto> findByTitleContaining(String keyword){
        return storage.values().stream()
                .filter((todo) -> todo.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
