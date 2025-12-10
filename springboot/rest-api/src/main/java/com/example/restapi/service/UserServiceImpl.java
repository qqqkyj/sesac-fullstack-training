package com.example.restapi.service;

import com.example.restapi.dto.response.UserResponse;
import com.example.restapi.entity.User;
import com.example.restapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return UserResponse.from(user);
    }
}
