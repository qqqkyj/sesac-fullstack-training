package com.example.board.controller;

import com.example.board.dto.PostDTO;
import com.example.board.entity.Post;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public String findAll(@PageableDefault(size = 20,
                                      sort = "id",
                                      direction = Sort.Direction.DESC
                              ) Pageable page,
                                Model model){
        //model.addAttribute("posts", postService.getAllPosts());
        Page<Post> postPage = postService.getPostPage(page);
        model.addAttribute("posts", postPage.getContent());
        return "posts/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model){
        Post post = postService.getPostById(id);
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
    public String create(@ModelAttribute Post post){
        postService.createPost(post);
        return "redirect:/posts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        postService.deletePost(id);
        return "redirect:/posts";
    }

    // 수정화면 렌더링
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "posts/form";
    }

    // 실제 수정
    @PostMapping("/{id}")
    public String update(@ModelAttribute Post newPost, @PathVariable Long id){
        postService.updatePost(id, newPost);
        return "redirect:/posts/"+id;
    }

    //검색
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model){
        model.addAttribute("posts", postService.searchPostByTitleOrContent(keyword));
        return "posts/list";
    }

    // 최근 게시물 3개만 출력
    @GetMapping("/recent")
    public String recent(Model model){
        model.addAttribute("posts", postService.findTop3RecentPosts());
        return "posts/list";
    }

    //더미 경로
    @GetMapping("/dummy")
    public String dummy(){
        postService.createDummyPost(100);
        return "redirect:/posts";
    }

    //캐시 테스트
    @GetMapping("/test/cache")
    public String testCache(){
        postService.testFirstLevelCache();
        return "redirect:/posts";
    }

    @GetMapping("/test/write-behind")
    public String testWriteBehind(){
        postService.testWriteBehind();
        return "redirect:/posts";
    }

    @GetMapping("test/dirty-checking")
    public String testDirtyChecking(){
        postService.testDirtyChecking();
        return "redirect:/posts";
    }
}
