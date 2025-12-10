package com.example.restapi.security;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//controller 실행 직전에 실행됨
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException
    {
        try{
            //JWT -> 현재 로그인한 사용자 정보 추출(@AuthenticationPrincipal)
            // 1. 요청에서 JWT 추출
            String token = resolveToken(request);

            // 2. 토큰 유효성 검사
            if (StringUtils.hasText(token) && jwtProvider.validateToken(token)) {
                // 3. 토큰에서 사용자 정보 추출
                String username = jwtProvider.getUsername(token);

                // 4. UserDetails 가져오기
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // 5. 인증 객체 생성
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 6. SecurityContext에 인증 객체 저장
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                System.out.println("인증 완료!!");
            }
        }
        catch (Exception e)
        {
            System.out.println("JWT 인증 실패 : " + e.getMessage());
        }

        filterChain.doFilter(request, response);//controller로 넘겨줌
    }

    // Authorization 헤더에서 토큰 추출
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
