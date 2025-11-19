package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
// TodoRepository클래스에 @Repository
//    private final TodoRepository todoRepository = new  TodoRepository();

    private final TodoRepository todoRepository;
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

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

    @GetMapping("/todos/{id}")
    public String detail(@PathVariable Long id, Model model) {
        try{
            model.addAttribute("todo", todoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("todo not found")));
        }
        catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
        return "detail";
    }

    @GetMapping("/todos/{id}/delete")
    public String delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @GetMapping("/todos/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        try{
            model.addAttribute("todo", todoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("todo not found")));
        }
        catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
        return "edit";
    }

    @GetMapping("/todos/{id}/update")
    public String update(@PathVariable Long id,
                         @RequestParam String title,
                         @RequestParam String content,
                         @RequestParam(defaultValue = "false") Boolean completed) {

        try{
            TodoDto dto = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("todo not found"));
            dto.setTitle(title);
            dto.setContent(content);
            dto.setCompleted(completed);
            todoRepository.save(dto);
        }catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
        return "redirect:/todos/" + id;
    }

    @GetMapping("/todos/search")
    public String search(@RequestParam String keyword, Model model){
        model.addAttribute("todos", todoRepository.findByTitleContaining(keyword));
        return "/todos";
    }

    @GetMapping("/todos/active")
    public String active(Model model){
        model.addAttribute("todos", todoRepository.findByCompleted(false));
        return "/todos";
    }

    @GetMapping("/todos/completed")
    public String completed(Model model){
        model.addAttribute("todos", todoRepository.findByCompleted(true));
        return "/todos";
    }
}
