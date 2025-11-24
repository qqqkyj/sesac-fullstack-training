package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.entity.TodoEntity;
import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TodoService{
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public TodoEntity findEntityById(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found : id = " + id));
    }

    public TodoDto getTodoById(Long id) {
        return toDto(findEntityById(id));
    }

    public TodoDto createTodo(TodoDto dto) {
        validateTitle(dto.getTitle());
        TodoEntity entity = new TodoEntity(
                dto.getTitle(), dto.getContent(),dto.isCompleted()
        );
        TodoEntity saved = todoRepository.save(entity);
        return toDto(saved);
    }

    private void validateTitle(String title){
        if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
        if(title.trim().length() > 50){
            throw new IllegalArgumentException("제목은 50자를 초과할 수 없습니다.");
        }
    }

    public void deleteTodoById(Long id) {
        findEntityById(id);
        todoRepository.deleteById(id);
    }

    public void updateTodoById(Long id, TodoDto newDto) {
        validateTitle(newDto.getTitle());
        TodoEntity entity = findEntityById(id);
        entity.setTitle(newDto.getTitle());
        entity.setContent(newDto.getContent());
        entity.setCompleted(newDto.isCompleted());
    }

    public List<TodoDto> searchTodosByTitle(String keyword) {
        return todoRepository.findByTitleContaining(keyword).stream()
                .map(this::toDto)
                .toList();
    }

    public List<TodoDto> getTodosByCompleted(boolean completed) {
        return todoRepository.findByCompleted(completed).stream()
                .map(this::toDto)
                .toList();
    }

    public TodoDto toggleCompleted(Long id){
        TodoEntity entity = findEntityById(id);
        entity.setCompleted(!entity.isCompleted());
        return toDto(entity);
    }

    public void deleteCompletedTodos() {
        todoRepository.deleteByCompleted(true);
    }

    public long getTotalCount(){
        return todoRepository.count();
    }

    public long getCompletedCount(){
        return todoRepository.countByCompleted(true);
    }

    public long getActiveCount(){
        return todoRepository.countByCompleted(false);
    }

    // TodoEntity -> TodoDTO
    private TodoDto toDto(TodoEntity entity){
        TodoDto dto = new TodoDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCompleted(entity.isCompleted());
        return dto;
    }
}
