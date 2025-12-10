package com.example.restapi.service;

import com.example.restapi.dto.request.LoginRequest;
import com.example.restapi.dto.request.SignupRequest;
import com.example.restapi.dto.response.TokenResponse;
import com.example.restapi.dto.response.UserResponse;
import com.example.restapi.entity.User;
import com.example.restapi.exception.CustomException;
import com.example.restapi.exception.ErrorCode;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    @Transactional
    public UserResponse signUp(SignupRequest signupRequest) {
        //중복 검사
        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            throw new CustomException(ErrorCode.DUPLICATE_USERNAME);
        }
        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());
        User user = User.builder()
                .username(signupRequest.getUsername())
                .password(encodedPassword)
                .email(signupRequest.getEmail())
                .name(signupRequest.getName())
                .build();
        userRepository.save(user);
        return UserResponse.from(user);
    }

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_PASSWORD);
        }

        String accessToken = jwtProvider.createToken(user.getUsername());
        return TokenResponse.of(accessToken);
    }
}
