package com.example.todoapp.controller;

import com.example.todoapp.costant.TodoStatus;
import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todos")
public class TodoController {
// 이전 직접 접근
//    private final TodoRepository todoRepository;
//    public TodoController(TodoRepository todoRepository) {
//        this.todoRepository = todoRepository;
//    }

    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String todos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("todosCount", todoService.getTotalCount());
        model.addAttribute("completedCount", todoService.getCompletedCount());
        model.addAttribute("activeCount", todoService.getActiveCount());
        model.addAttribute("status", TodoStatus.NORMAL.getCode());
        return "todos";
    }

    //생성 화면 렌더링
    @GetMapping("/new")
    public String newTodo(Model model) {
        model.addAttribute("todo", new TodoDto());
        return "form";
    }

    //실제 생성
    @PostMapping
    public String create(@ModelAttribute TodoDto todo,
                         RedirectAttributes redirectAttributes) {
        try {
                todoService.createTodo(todo);
                redirectAttributes.addFlashAttribute("message", "create todo!");//잠깐만 보여줌
                return "redirect:/todos";
            }
        catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("status", TodoStatus.DANGER.getCode());
            return "redirect:/todos/new";
        }
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        try{
            model.addAttribute("todo", todoService.getTodoById(id));
        }
        catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
        return "detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirectAttributes) {
        todoService.deleteTodoById(id);
        redirectAttributes.addFlashAttribute("message", "deleted!");
        redirectAttributes.addFlashAttribute("status", TodoStatus.DANGER.getCode());
        return "redirect:/todos";
    }

    //수정 화면 렌더링
    @GetMapping("/{id}/update")
    public String edit(@PathVariable Long id, Model model) {
        try{
            model.addAttribute("todo", todoService.getTodoById(id));
        }
        catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
        return "form";
    }

    //실제 수정
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id,
                         @ModelAttribute TodoDto todo,
                         RedirectAttributes redirectAttributes) {
        try{
            todoService.updateTodoById(id, todo);
            redirectAttributes.addFlashAttribute("message","update todo!");
            redirectAttributes.addFlashAttribute("status",TodoStatus.WARNING.getCode());
        }catch (IllegalArgumentException e){
            if(e.getMessage().contains("제목")){
                redirectAttributes.addFlashAttribute("message",e.getMessage());
                redirectAttributes.addFlashAttribute("status",TodoStatus.DANGER.getCode());
                return "redirect:/todos/"+id+"/update";
            }
            else{
                redirectAttributes.addFlashAttribute("message",e.getMessage());
                redirectAttributes.addFlashAttribute("status",TodoStatus.DANGER.getCode());
                return "redirect:/todos";
            }
        }
        return "redirect:/todos/" + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model){
        model.addAttribute("todos", todoService.searchTodosByTitle(keyword));
        return "/todos";
    }

    @GetMapping("/active")
    public String active(Model model){
        model.addAttribute("todos", todoService.getTodosByCompleted(false));
        return "/todos";
    }

    @GetMapping("/completed")
    public String completed(Model model){
        model.addAttribute("todos", todoService.getTodosByCompleted(true));
        return "/todos";
    }

    @GetMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id){
        try{
            todoService.toggleCompleted(id);
            return "redirect:/todos/" + id;
        }catch (IllegalArgumentException e){
            return "redirect:/todos";
        }
    }

    @GetMapping("/delete-completed")
    public String deleteCompletedTodos(RedirectAttributes redirectAttributes) {
        todoService.deleteCompletedTodos();
        redirectAttributes.addFlashAttribute("status", TodoStatus.DANGER.getCode());
        redirectAttributes.addFlashAttribute("message", "완료된 할 일 전체 삭제!");
        return "redirect:/todos";
    }


    // 1. 제목 검증 추가
    // - 제목이 비어있이면 예외
    // - 50자 초과시 예외

    // 2. 통계 기능 추가
    // - 전체, 완료된, 미완료 할 일 개수 => /todos에 표시

    // 3. 완료된 할 일 일괄 삭제

}
