package com.example.securitydemo.controller;

import com.example.securitydemo.dto.SignupDto;
import com.example.securitydemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model){
        if(userDetails != null){
            model.addAttribute("username",userDetails.getUsername());
            model.addAttribute("password",userDetails.getPassword());
            model.addAttribute("roles",userDetails.getAuthorities());
        }
        return "dashboard";
    }

    //회원가입
    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }

    //@Valid가 Dto클래스에서 설정한 유효성을 체크, 문제가 있다면 BindingResult를 통해 전달
    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("signupDto") SignupDto signupDto, BindingResult bindingResult){
        // 비밀번호 일치 여부 검증
        if (!signupDto.getPassword().equals(signupDto.getPasswordConfirm())) {
            bindingResult.rejectValue(
                    "passwordConfirm",
                    "password_mismatch",
                    "비밀번호가 일치하지 않습니다."
            );
        }

        // 검증 실패
        if (bindingResult.hasErrors()) {return "signup";}

        // DB 조회가 필요한 검증
        // 아이디 중복 체크
        if(userService.existByUsername(signupDto.getUsername())){
            bindingResult.rejectValue(
                    "username",
                    "duplicate",
                    "이미 사용중인 아이디입니다.");
            return "signup";
        }
        // 이메일 중복 체크
        if(userService.existByEmail(signupDto.getEmail())){
            bindingResult.rejectValue(
                    "email",
                    "duplicate",
                    "이미 사용중인 이메일입니다.");
            return "signup";
        }

        // 검증 성공 → 회원가입 처리
        userService.register(signupDto);
        return "redirect:/login";
    }
}
