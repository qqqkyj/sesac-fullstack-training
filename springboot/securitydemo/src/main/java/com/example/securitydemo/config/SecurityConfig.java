package com.example.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/info", "/login", "/signup","/h2-console/**").permitAll() // 두 개 라우팅 오픈 (로그인 필요X)
                        .requestMatchers("/admin/**").hasRole("ADMIN") //관리자 권한만 볼 수 있는 화면
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN") // 사용자, 관리자 모두
                        .anyRequest().authenticated() //anyRequest() : 그 외 라우팅, authenticated: 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login") // 커스텀 로그인 페이지 주소
                        .defaultSuccessUrl("/dashboard", true) // 로그인 성공 시 이동할 페이지
                        .failureUrl("/login") // 로그인 실패 시 이동할 페이지
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login") //로그아웃 성공시 이동할 페이지
                        .permitAll()
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/access-denied"));

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build(); //빌더 패턴으로 return
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    인메모리 설정용
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}1234") //비밀번호 평문 저장 : {noop}
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}admin")
//                .roles("USER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
