package com.example.securitydemo.service;

import com.example.securitydemo.dto.SignupDto;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existByEmail(String email){return userRepository.existsByEmail(email);}

    @Override
    public User register(SignupDto signupDto){
        User user = User.builder()
                .username(signupDto.getUsername())
                .password(passwordEncoder.encode(signupDto.getPassword()))
                .email(signupDto.getEmail())
                .role("ROLE_USER")
                .build();
        return userRepository.save(user);
    }
}
