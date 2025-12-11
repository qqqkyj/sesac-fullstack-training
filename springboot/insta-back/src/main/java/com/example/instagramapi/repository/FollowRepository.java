package com.example.instagramapi.repository;

import com.example.instagramapi.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// A(follower) -> B (following)
public interface FollowRepository  extends JpaRepository<Follow,Long> {
    //팔로우 정보 조회
    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);
    //팔로우 여부 확인
    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);
    //팔로워 수 (나를 팔로우하는 사람들의 수)
    long countByFollowingId(Long followingId);
    //팔로잉 수 (내가 팔로우하는 사람들의 수)
    long countByFollowerId(Long followerId);
    //팔로잉 ID 목록 ( A - follower -> B - following)
    @Query("SELECT f.following.id FROM Follow  f WHERE f.follower.id = :userId")
    List<Long> findFollowingIdsByFollowerId(@Param("userId")Long userId);
    //팔로워 목록(나를 팔로우하는 사람들)
    @Query("SELECT f FROM Follow f JOIN FETCH f.following WHERE f.following.id = :userId")
    List<Follow> findFollowersByFollowingId(@Param("userId") Long userId);
    //팔로잉 목록(내가 팔로우하는 사람들)
    @Query("SELECT f FROM Follow f JOIN FETCH f.follower WHERE f.follower.id = :userId")
    List<Follow> findFollowingsByFollowerId(@Param("userId") Long userId);
}
