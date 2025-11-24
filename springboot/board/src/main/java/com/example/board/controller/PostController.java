package com.example.board.controller;

import com.example.board.dto.PostDTO;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("posts", postRepository.findAll());
        return "posts/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model){
        PostDTO post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "posts/detail";
    }

    //생성 화면 렌더링
    @GetMapping("/new")
    public String newPost(Model model){
        model.addAttribute("post", new PostDTO());
        return "posts/form";
    }

    // 실제 생성
    @PostMapping
    public String create(@ModelAttribute PostDTO postDTO){
        postRepository.save(postDTO);
        return "redirect:/posts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        postRepository.deleteById(id);
        return "redirect:/posts";
    }

    // 수정화면 렌더링
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        PostDTO post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "posts/form";
    }

    // 실제 수정
    @PostMapping("/{id}")
    public String update(@ModelAttribute PostDTO newPost, @PathVariable Long id){
        postRepository.update(id, newPost);
        return "redirect:/posts/"+id;
    }
}
