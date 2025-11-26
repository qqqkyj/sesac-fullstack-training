package com.example.board.controller;

import com.example.board.dto.CommentDTO;
import com.example.board.dto.PostDTO;
import com.example.board.entity.Comment;
import com.example.board.entity.Post;
import com.example.board.service.CommentService;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

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

        // 최대 5페이지 표시
        int displayPages = 5;
        int startPage = Math.max(0, currentPage - displayPages / 2);
        int endPage = Math.min(totalPages - 1, startPage + displayPages - 1);
        startPage = Math.max(0, endPage - displayPages + 1);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("postPage", postPage);
        return "posts/list";
    }

    @GetMapping("/more")
    public String more(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        Slice<Post> postSlice = postService.getPostSlice(pageable);
        model.addAttribute("postSlice", postSlice);
        return "posts/list-more";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model){
        Post post = postService.getPostById(id);
        List<Comment> comments = post.getComments();
//        List<Comment> comments = commentService.getCommentsByPostId(id);

        model.addAttribute("post", post);
        //빈 댓글 객체를 생성하여 detail페이지에서 타임림프를 통해 매핑
        model.addAttribute("comment", new CommentDTO());
        model.addAttribute("comments", comments);
        return "posts/detail";
    }

    // Comment(댓글)
    @PostMapping("/{postId}/comments")
    public String createComment(
            @PathVariable Long postId,
            @ModelAttribute Comment comment,
            Model model
    ){
        commentService.createComment(postId, comment);
        return "redirect:/posts/" + postId;
    }

    //댓글 삭제
    @PostMapping("/{postId}/comments/{cId}/delete")
    public String deleteComment(@PathVariable Long postId, @PathVariable Long cId){
        commentService.deleteComment(cId);
        return "redirect:/posts/" + postId;
    }

    //페이징처리 빠진 조인 방법
    @GetMapping("/fetch-join")
    public String listWithFetchJoin(Model model){
        List<Post> posts = postService.getAllPostsWithFetchJoin();
        model.addAttribute("posts",posts);
        return "posts/list-test";
    }

    @GetMapping("/entity-graph")
    public String listWithEntityGraph(Model model){
        List<Post> posts = postService.getAllPostsWithEntityGraph();
        model.addAttribute("posts",posts);
        return "posts/list-test";
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

        // 최대 5페이지 표시
        int displayPages = 5;
        int startPage = Math.max(0, currentPage - displayPages / 2);
        int endPage = Math.min(totalPages - 1, startPage + displayPages - 1);
        startPage = Math.max(0, endPage - displayPages + 1);

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
