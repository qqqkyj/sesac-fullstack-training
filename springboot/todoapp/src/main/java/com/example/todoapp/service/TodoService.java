package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll();
    }

    public TodoDto getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found : id = " + id));
    }

    public TodoDto createTodo(TodoDto todoDto) {
        return todoRepository.save(todoDto);
    }

    public void deleteTodoById(Long id) {
        if(getTodoById(id) != null) {
            todoRepository.deleteById(id);
        }
    }

    public TodoDto updateTodoById(Long id, TodoDto newTodo) {
        TodoDto oldTodo = getTodoById(id);
        oldTodo.setTitle(newTodo.getTitle());
        oldTodo.setContent(newTodo.getContent());
        oldTodo.setCompleted(newTodo.isCompleted());
        return todoRepository.save(oldTodo);
    }

    public List<TodoDto> searchTodosByTitle(String keyword) {
        return todoRepository.findByTitleContaining(keyword);
    }

    public List<TodoDto> getTodosByCompleted(boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    public TodoDto toggleCompleted(Long id){
        TodoDto todo = getTodoById(id);
        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }
}
