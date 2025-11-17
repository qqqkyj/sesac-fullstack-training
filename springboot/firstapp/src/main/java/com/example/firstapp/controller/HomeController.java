package com.example.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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
}
