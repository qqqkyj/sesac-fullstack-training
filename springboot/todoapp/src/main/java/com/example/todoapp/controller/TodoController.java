package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    private final TodoRepository todoRepository = new  TodoRepository();

    @GetMapping("/todos")
    public String todos(Model model) {
        //아래 todoRepository는 새로운 인스턴스라 storage가 다름
        // 공통의 respository가 필요
        //TodoRepository todoRepository = new TodoRepository();
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @GetMapping("/todos/new")
    public String newTodo() {
        return "new";
    }

    @GetMapping("/todos/create")
    public String create(@RequestParam String title, @RequestParam String content, Model model) {
        TodoDto dto = new TodoDto(null, title, content, false);
        model.addAttribute("todo", todoRepository.save(dto));
        return "redirect:/todos";
    }
}
