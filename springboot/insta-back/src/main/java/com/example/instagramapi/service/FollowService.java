package com.example.instagramapi.service;

import com.example.instagramapi.dto.response.FollowResponse;
import com.example.instagramapi.entity.Follow;
import com.example.instagramapi.entity.User;
import com.example.instagramapi.exception.CustomException;
import com.example.instagramapi.exception.ErrorCode;
import com.example.instagramapi.repository.FollowRepository;
import com.example.instagramapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// A(follower) -> B(following)
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    //팔로워/팔로잉 수 조회
    private FollowResponse getFollowCounts(Long userId, boolean isFollowing) {
        long followerCount = followRepository.countByFollowingId(userId); // 내가 팔로우하는 사람들의 수
        long followingCount = followRepository.countByFollowerId(userId); // 나를 팔로우하는 사람들의 수
        return FollowResponse.of(isFollowing, followerCount, followingCount);
    }

    public FollowResponse follow(String username, Long followerId){
        //username => 프로필 페이지 주인
        //followerId => 화살표를 보내는 사람(로그인한 사람)
        User following = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Follow follow = Follow.builder()
                .follower(follower)
                .following(follower)
                .build();

        followRepository.save(follow);

        return getFollowCounts(following.getId(), true);
    }
}
