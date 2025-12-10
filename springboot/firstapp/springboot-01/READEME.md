# 1. 프로젝트 생성 및 Thymeleaf 기본

# 🌱 Spring Framework & Spring Boot 정리

## 1. Spring Framework

- **Java 기반 웹 서버 프레임워크**
- 공식 사이트 : [https://spring.io/](https://spring.io/)
- **Spring Boot** : 최소 설정으로 Spring 프로젝트를 빠르게 실행할 수 있게 해주는 경량화된 버전
    
    (예: Spring Boot **3.5.7**)
    

---

# 2. Spring 프로젝트 생성 과정

## ✔ 2-1. JDK 설치 및 환경 변수 설정

- 기존 JDK 17 → JDK 21로 버전 업 (예: IntelliJ에서 설치)
- **시스템 환경 변수 설정**
    - `JAVA_HOME` 생성
    - `Path`에 `%JAVA_HOME%\bin` 추가
        
        
        ![image.png](image.png)
        
        ![image.png](image%201.png)
        
        ![image.png](image%202.png)
        
        ![image.png](image%203.png)
        
        ![image.png](image%204.png)
        

## ✔ 2-2. VS Code Java 설정 (선택)

- VS Code 실행 → Java extension 설치
- Git Bash 등에서 Java 경로를 설정하여 Java 프로젝트 사용 가능
    
    ![image.png](image%205.png)
    
    ![image.png](image%206.png)
    

---

# 3. Spring Initializr로 프로젝트 생성

사이트 : [https://start.spring.io/](https://start.spring.io/)

- 필요한 설정 선택(Group, Artifact, Boot 버전 등)
- 생성 후 ZIP 다운로드 → 압축 해제 → IntelliJ로 프로젝트 오픈
    
    ![image.png](image%207.png)
    

### 예시 코드 (`DemoApplication.java`)

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }
}
```

- 실행 후 확인 URL
    
    👉 `http://localhost:8080/hello`
    

### 🖥 터미널에서 실행

프로젝트 폴더 이동 후:

```
.\gradlew.bat bootRun
```

---

# 4. IntelliJ에서 프로젝트 생성

- IntelliJ의 **New Project** 사용
- GroupId는 보통 회사 도메인을 뒤집어 작성(ex: `com.company`)
- 필요할 경우 **`build.gradle`** 에 dependency 추가 가능

예시:

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```

![image.png](image%208.png)

![image.png](image%209.png)

![image.png](image%2010.png)

![image.png](image%2011.png)

추후 **`build.gradle`** 에 `dependency` 추가 가능

![image.png](image%2012.png)

---

# 5. MVC 패턴 정리

참고 : https://ko.wikipedia.org/wiki/모델-뷰-컨트롤러

### 🧩 MVC 구성 요소

| 구성 요소 | 역할 |
| --- | --- |
| **Controller (중간 역할)** | 모델과 뷰의 중간 역할, 요청 처리, 모델 업데이트, 뷰 선택 |
| **Model (데이터)** | 데이터 상태 저장 및 CRUD 처리 |
| **View (화면)** | 사용자에게 보여지는 화면, 모델 데이터를 기반으로 결과 표시 |

---

# 6. 간단한 Spring MVC 구조 만들기

### 1. 📂 프로젝트 기본 구조

```
src
 └─ main
     ├─ java
     │   └─ controller        ← 컨트롤러 패키지
     └─ resources
         └─ templates         ← HTML(Thymeleaf) 파일 저장 폴더
             ├─ home.html
             ├─ hello.html
             ├─ fruits.html   ← 반복문 예제
             ├─ grade.html    ← 조건문 예제
             ├─ profile.html  ← PathVariable 예제
             ├─ ping.html     ← form 예제
             └─ pong.html     ← form 예제
```

---

### 2. 🌱 기본 Controller & View 연동

## 📌 Controller

```java
package com.example.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // home.html
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        String name = "gildong";
        model.addAttribute("name", name); // name을 hello.html로 전달
        return "hello"; // hello.html
    }
}
```

---

### 3. 🌼 Thymeleaf 사용 기본 설정

HTML 태그에 템플릿 엔진 사용을 위한 속성 추가:

```html
<html lang="en" xmlns:th="https://www.thymeleaf.org">
```

---

### 4. 📄 hello.html 예시

```html
<!doctype html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    <h1>Hello!</h1>
    <h1 th:text="${name}"></h1>  <!-- Model에 담긴 name 출력 -->
</body>
</html>
```

---

### 5. 💡 IntelliJ – HTML 템플릿 자동 생성 설정

- **커스텀 템플릿 생성**
    
    **설정 → 에디터 → 라이브 템플릿 → + > 그룹 생성 > 라이브 템플릿 생성**
    
    HTML파일 생성 후 `thhtml + Tab`  
    
    ![image.png](image%2013.png)
    
- **기본 템플릿 수정**
    
    **설정 → 에디터 → 파일 및 코드 템플릿 → HTML File**
    
    기본 template 안에 다음 추가:
    
    ```html
    <html lang="en" xmlns:th="https://www.thymeleaf.org">
    ```
    
    ![image.png](image%2014.png)
    

---

### 6. 🔁 반복문 (foreach)

## 📌 Controller

```java
@GetMapping("/fruits")
public String fruits(Model model){
    List<String> fruitList = Arrays.asList("apple", "banana", "cherry", "lemon", "kiwi");
    model.addAttribute("fruits", fruitList);
    return "fruits";
}
```

## 📄 fruits.html

```html
<ul>
    <li th:each="fruit : ${fruits}" th:text="${fruit}"></li>
</ul>
```

---

### 7. ✔ 조건문 (if)

## 📌 Controller

```java
@GetMapping("/grade")
public String grade(Model model){
    int score = 90;
    model.addAttribute("score", score);
    return "grade";
}
```

## 📄 grade.html

```html
<p th:text="${score}"></p>
<p th:if="${score > 90}">1등급</p>
<p th:if="${score > 80 && score <= 90}">2등급</p>
<p th:if="${score <= 80}">탈락</p>
```

---

### 8. 🔗 PathVariable 사용

## 📌 Controller

```java
@GetMapping("/profile/{username}")
public String profile(@PathVariable String username, Model model){
    model.addAttribute("username", username);
    return "profile";
}
```

## 📄 profile.html

```html
<p th:text="${username}"></p>
```

![image.png](image%2015.png)

---

### 9. 🆚 PathVariable vs Query Parameter

| 구분 | PathVariable | Query Parameter |
| --- | --- | --- |
| 위치 | `/users/{id}` | `/users?id=123` |
| 목적 | 리소스 식별 | 옵션, 필터링, 검색 |
| RESTful | 준수 | 선택적 |
| 필수 여부 | 보통 필수 | 기본값 허용 |

### 예시

- PathVariable → `/products/123`
- Query Parameter → `/products?category=shoes&sort=price`

---

### 10. 📝 form 데이터 전달 (GET & POST)

## 📌 Controller

```java
@GetMapping("/ping")
public String ping() {
    return "ping";
}

// GET 방식 (URL에 QueryParam 노출됨)
@GetMapping("/pong")
public String pong(
        @RequestParam String title,
        @RequestParam String content,
        Model model) {

    model.addAttribute("title", title);
    model.addAttribute("content", content);
    return "pong";
}

// POST 방식 (URL에 노출되지 않음 - 보안 강화)
// @PostMapping("/pong")
// public String pong(@RequestParam String title,
//                    @RequestParam String content,
//                    Model model){
//
//    model.addAttribute("title", title);
//    model.addAttribute("content", content);
//    return "pong";
// }
```

---

## 📄 ping.html

```html
<form action="/pong"> <!-- GET 방식 (URL 노출됨) -->
<!-- <form action="/pong" method="post">  POST 방식 (보안 ↑) -->
    <input type="text" name="title">
    <input type="text" name="content">
    <input type="submit">
</form>
```

![image.png](image%2016.png)

---

## 📄 pong.html

```html
<p th:text="${title}"></p>
<p th:text="${content}"></p>
```

![image.png](image%2017.png)