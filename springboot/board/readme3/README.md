# 7. JPA - board(댓글)

# 📘 **📌 JPA 기반 댓글(Comment) 기능 구현 정리**

---

# #️⃣ 1. 댓글(Comment) 엔티티 구현

### ✔ Comment : Post = N : 1 (ManyToOne)

```java
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String content;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Comment(String content, Post post) {
        this.content = content;
        if (post != null) post.addComment(this); // 양방향 연관관계 편의 메서드
    }
}
```

![image.png](image.png)

---

# #️⃣ 2. 댓글 등록 기능

## 📌 Controller

```java
@PostMapping("/{postId}/comments")
public String createComment(
        @PathVariable Long postId,
        @ModelAttribute Comment comment
){
    commentService.createComment(postId, comment);
    return "redirect:/posts/" + postId;
}
```

## 📌 Service

```java
@Transactional
public Comment createComment(Long postId, Comment comment) {
    Post post = postService.getPostById(postId);
    post.addComment(comment); // 양방향 매핑
    return commentRepository.save(comment);
}
```

## ✔ detail.html 의 댓글 작성 Form

```html
<form th:action="@{posts/{id}/comments(id=${post.id})}"
      th:object="${comment}"
      method="post">
    <input type="text" th:field="*{content}">
    <input type="submit">
</form>
```

![image.png](image%201.png)

---

# #️⃣ 3. 댓글 조회 기능

### ✔ Post 기준 양방향 매핑 후 Post.getComments() 로 조회 가능

```java
@GetMapping("/{id}")
public String detail(@PathVariable Long id, Model model){
    Post post = postService.getPostById(id);

    model.addAttribute("post", post);
    model.addAttribute("comment", new CommentDTO());
    model.addAttribute("comments", post.getComments());

    return "posts/detail";
}
```

### ✔ Thymeleaf

```html
<div th:each="comment : ${comments}">
    <p th:text="${comment.content}"></p>
    <small th:text="${comment.createdAt}"></small>
</div>
```

![image.png](image%202.png)

![image.png](image%203.png)

---

# #️⃣ 4. 양방향 연관관계 매핑

### ✔ Post 엔티티에서 comments 관리

```java
@OneToMany(mappedBy = "post",
           cascade = CascadeType.REMOVE,
           orphanRemoval = true)
private List<Comment> comments = new ArrayList<>();

// 관계 편의 메서드
public void addComment(Comment comment){
    this.comments.add(comment);
    comment.setPost(this);
}

public void removeComment(Comment comment){
    comments.remove(comment);
    comment.setPost(null);
}
```

### ✔ 주의

- Comment 생성자에서 post.addComment(this) 호출하면
    
    addComment → setPost → addComment 무한 루프 위험
    
- 따라서 생성자에서 편의 메서드 호출 시 주의 필요

---

# #️⃣ 5. 댓글 삭제(고아 객체 삭제 포함)

## 📌 Service

```java
@Transactional
public void deleteComment(Long commentId) {
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

    Post post = comment.getPost();

    post.removeComment(comment);  // Post 컬렉션에서 제거 → orphan 발생

    commentRepository.delete(comment); // 직접 삭제 (orphanRemoval=true면 생략 가능)
}
```

### orphanRemoval = true 의 의미

- Parent(Post)의 컬렉션에서 Child(Comment)를 remove하면
    
    **JPA가 자동으로 DELETE 쿼리를 실행**
    

![image.png](image%204.png)

---

# #️⃣ 6. N+1 문제 (댓글 개수 표시 시 발생)

### ✔ 예: 게시글 목록에서 댓글 개수 출력

```html
<td th:text="${post.title} + '(' + ${#lists.size(post.comments)} + ')'"></td>
```

### ❗ 문제점

- post.getComments() 실행할 때마다 댓글을 다시 조회
- 게시글 10개 → 댓글 리스트 조회 10번 → N+1 문제 발생
    
    ![image.png](image%205.png)
    

---

# #️⃣ 7. N+1 문제 해결 방법

## 1️⃣ 문제 상황

- Post와 Comment가 **1:N 양방향 관계**로 매핑되어 있음.
- `list.html`이나 `list-test.html`에서 댓글 개수를 표시하려고 하면:

```html
<tr th:each="post: ${posts}">
    <td th:text="${post.id}"></td>
    <td th:text="${post.title}"></td>
    **<td th:text="${#lists.size(post.comments)}"></td>**
</tr>
```

- Post가 여러 개라면, 각 Post의 Comment를 **Lazy 로딩**하기 때문에
    
    → SQL N번 + Post 1번 조회 = **N+1 문제** 발생
    

---

## 2️⃣ 해결 방법

### ① **Fetch Join 직접 사용** (JPQL)

- 장점: 단일 쿼리로 Post와 Comment 조회 가능
- 단점: **페이징 불가** (중복 제거 위해 `DISTINCT` 필요)

```java
// Repository
@Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.comments")
List<Post> findAllWithComments();
```

```java
// Service
public List<Post> getAllPostsWithFetchJoin() {
    return postRepository.findAllWithComments();
}
```

---

### ② **`@EntityGraph` 사용** (JPA 표준 방식)

- 장점: **페이징 가능**, JPQL에 JOIN 생략 가능
- 단점: Fetch Join보다 옵션 제한
- 이때 Batch Fetching과 조합하면 쿼리 최적화 가능

```java
// Repository
@EntityGraph(attributePaths = {"comments"})
@Query("SELECT p FROM Post p")
List<Post> findAllWithCommentsEntityGraph();
```

```java
// Service
public List<Post> getAllPostsWithEntityGraph() {
    return postRepository.findAllWithCommentsEntityGraph();
}
```

---

### ③ **Batch Fetching 적용** (Hibernate 설정)

- Lazy 컬렉션을 **IN절로 한 번에 여러 개씩 묶어서 조회 (묶는 사이즈를 properties에서 설정)**
- 전역 설정:

```
//application.properties
spring.jpa.properties.hibernate.default_batch_fetch_size=100
```

- 개별 엔티티/컬렉션 설정:

```java
//Post
@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
@BatchSize(size = 10)
private List<Comment> comments = new ArrayList<>();
```

> 결과적으로 한 번에 여러 Comment를 묶어서 IN 절로 조회 → N+1 문제 완화
> 

---

## 3️⃣ 댓글 기능과 연관된 핵심 포인트

| 기능 | 핵심 내용 |
| --- | --- |
| 댓글 생성 | Post–Comment N:1, `post.addComment(comment)` 사용 |
| 댓글 조회 | `post.getComments()`로 조회 가능 |
| 양방향 매핑 | `addComment` / `removeComment` 편의 메서드 필수 |
| 고아 객체 삭제 | `orphanRemoval = true` → Post 컬렉션에서 제거하면 자동 삭제 |
| 댓글 삭제 | `removeComment()` → `delete(comment)` 호출 |
| N+1 문제 발생 | Post 여러 개 + Lazy Comment 조회 시 |
| 해결 방법 | Fetch Join, EntityGraph, Batch Fetching 적용 |

---

💡 **핵심 요약:**

> N+1 문제는 Lazy 로딩 컬렉션 조회 시 발생하며,
> 
> 
> **Fetch Join / EntityGraph / Batch Fetching**으로 효율적으로 해결 가능
>