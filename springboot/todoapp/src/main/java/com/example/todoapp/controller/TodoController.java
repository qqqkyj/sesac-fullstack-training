package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todos")
public class TodoController {
// TodoRepository클래스에 @Repository
//    private final TodoRepository todoRepository = new  TodoRepository();

    private final TodoRepository todoRepository;
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String todos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    //화면 표시
    @GetMapping("/new")
    public String newTodo() {
        return "new";
    }

    //실제 생성
    @PostMapping
    public String create(@RequestParam String title,
                         @RequestParam String content,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        TodoDto dto = new TodoDto(null, title, content, false);
        model.addAttribute("todo", todoRepository.save(dto));
        //todos.html에서 "message" 사용 가능
        redirectAttributes.addFlashAttribute("message", "create todo!");//잠깐만 보여줌
        return "redirect:/todos";
    }

    @GetMapping("/{id}")
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

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirectAttributes) {
        todoRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "deleted!");
        redirectAttributes.addFlashAttribute("status", "delete");
        return "redirect:/todos";
    }

    //화면 표시
    @GetMapping("/{id}/update")
    public String edit(@PathVariable Long id, Model model) {
        try{
            model.addAttribute("todo", todoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("todo not found")));
        }
        catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
        return "update";
    }

    //실제 수정
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id,
                         @RequestParam String title,
                         @RequestParam String content,
                         @RequestParam(defaultValue = "false") Boolean completed,
                         RedirectAttributes redirectAttributes) {

        try{
            TodoDto dto = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("todo not found"));
            dto.setTitle(title);
            dto.setContent(content);
            dto.setCompleted(completed);
            todoRepository.save(dto);
            redirectAttributes.addFlashAttribute("message","update todo!");
            redirectAttributes.addFlashAttribute("status","update");
        }catch (IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("message","This todo is not exist!");
            return "redirect:/todos";
        }
        return "redirect:/todos/" + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model){
        model.addAttribute("todos", todoRepository.findByTitleContaining(keyword));
        return "/todos";
    }

    @GetMapping("/active")
    public String active(Model model){
        model.addAttribute("todos", todoRepository.findByCompleted(false));
        return "/todos";
    }

    @GetMapping("/completed")
    public String completed(Model model){
        model.addAttribute("todos", todoRepository.findByCompleted(true));
        return "/todos";
    }

    @GetMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id, Model model){
        try{
            TodoDto todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("todo not found"));
            todo.setCompleted(!todo.isCompleted());
            todoRepository.save(todo);
            return "redirect:/todos/" + id;
        }catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
    }
}
