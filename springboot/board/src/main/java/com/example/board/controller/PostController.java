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
    public String findAll(@PageableDefault(
                                      sort = "id",
                                      direction = Sort.Direction.DESC
                              ) Pageable pageable,
                                Model model){
        //model.addAttribute("posts", postService.getAllPosts());
        Page<Post> postPage = postService.getPostPage(pageable);
        int currentPage = postPage.getNumber();
        int totalPages = postPage.getTotalPages();
        int startPage = Math.max(0, currentPage - 5);
        int endPage = Math.min(totalPages-1, currentPage + 5);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("postPage", postPage);
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
    public String search(@RequestParam String keyword,
                         @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
                         Model model){
//        model.addAttribute("posts", postService.searchPostByTitleOrContent(keyword));
        Page<Post> postPage =  postService.searchPostsPage(pageable, keyword);
        int currentPage = postPage.getNumber();
        int totalPages = postPage.getTotalPages();
        int startPage = Math.max(0, currentPage - 5);
        int endPage = Math.min(totalPages-1, currentPage + 5);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("postPage", postPage);
        model.addAttribute("keyword", keyword);
        return "posts/search";
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
