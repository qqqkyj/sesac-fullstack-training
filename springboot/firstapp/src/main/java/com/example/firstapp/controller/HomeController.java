package com.example.firstapp.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";//home.html
    }

    //model에 name속성을 담아서 hello.html에 전달
    @GetMapping("/hello")
    public String hello(Model model){
        String name = "gildong";
        model.addAttribute("name", name);
        return "hello";//hello.html
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("username", "HONG");
        model.addAttribute("age", 20);
        model.addAttribute("city","seoul");
        return "user";
    }

    @GetMapping("/fruits")
    public String fruits(Model model){
        List<String> fruitList = new ArrayList<>();
        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("cherry");
        fruitList.add("lemon");
        fruitList.add("kiwi");

        model.addAttribute("fruits", fruitList);
        return "fruits";
    }

    @GetMapping("/grade")
    public String grade(Model model){
        int score = 90;
        model.addAttribute("score", score);
        return "grade";
    }

    @GetMapping("/lunch")
    public String lunch(Model model){
        List<String> menus = new ArrayList<>(Arrays.asList("김밥", "라면", "돈가스"));
        model.addAttribute("pick", menus.get(new Random().nextInt(menus.size())));
        return "lunch";
    }

    @GetMapping("/lotto")
    public String lotto(Model model){
        List<Integer> numbers = IntStream.rangeClosed(1,46)
                .boxed()//auto boxing(int형태의 데이터를 Integer로 형변환)
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lucky = numbers.subList(0, 6);
        model.addAttribute("lucky", lucky);
        return "lotto";
    }

    // PathVariable : url을 통해 들어오는 변수(ex.username)
    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model){
        model.addAttribute("username", username);
        return "profile";
    }

    @GetMapping("/cube/{number}")
    public String cube(@PathVariable int number, Model model){
        model.addAttribute("number", number);
        model.addAttribute("result", number * number * number);
        return "cube";
    }

    // 짝수 홀수 판별
    // /number/{num} => 짝수인지 홀수인지 판별해서 화면에 출력
    @GetMapping("/number/{num}")
    public String number(@PathVariable int num, Model model){
        model.addAttribute("num", num);
        model.addAttribute("result", num % 2 == 0 ? "짝수" : "홀수");
        return "number";
    }

    //나이계산 (Year클래스 사용)
    // /age/{birthYear} => 현재 나이를 계산해서 출력
    // /age/1990 => 36살입니다.
    @GetMapping("/age/{birthYear}")
    public String age(@PathVariable int birthYear, Model model){
        model.addAttribute("birthYear", birthYear);
        model.addAttribute("age", Year.now().getValue() - birthYear + 1);
        return "age";
    }

    @GetMapping("/ping")
    public String ping(Model model){
        return "ping";
    }

    //QueryParameter = RequestParam
    @GetMapping("/pong")
    public String pong(@RequestParam String title,
                       @RequestParam String content,
                       Model model){
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "pong";
    }
}
