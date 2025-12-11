package com.example.instagramapi.service;

import com.example.instagramapi.dto.response.KakaoTokenResponse;
import com.example.instagramapi.dto.response.KakaoUserResponse;
import com.example.instagramapi.exception.CustomException;
import com.example.instagramapi.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KakaoOauthService {
    //properties에서 설정한 값 가져오기
    @Value("${oauth.kakao.client-id}")
    private String clientId;
    @Value("${oauth.kakao.client-secret}")
    private String clientSecret;
    @Value("${oauth.kakao.redirect-uri}")
    private String redirectUri;
    @Value("${oauth.kakao.token-uri}")
    private String tokenUri;
    @Value("${oauth.kakao.user-info-uri}")
    private String userInfoUri;

    private final WebClient webClient = WebClient.create();

    // 카카오 authorization code로 accessToken 발급 받기
    public KakaoTokenResponse getToken(String code) {
        try{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("grant_type", "authorization_code");
            formData.add("client_id", clientId);
            formData.add("redirect_uri", redirectUri);
            formData.add("code", code);
            formData.add("client_secret", clientSecret);//필수 아님

            return webClient.post()
                    .uri(tokenUri)
                    .accept(MediaType.APPLICATION_FORM_URLENCODED)
                    .bodyValue(formData)
                    .retrieve()
                    .bodyToMono(KakaoTokenResponse.class)
                    .block();
        }
        catch (Exception e){
            throw new CustomException(ErrorCode.OAUTH_TOKEN_FAILED);
        }
    }

    //accessToken으로 사용자 정보 조회
    public KakaoUserResponse getUserInfo(String accessToken) {
        try {
            return webClient.get()
                    .uri(userInfoUri)
                    .header("Authorization", "Bearer " + accessToken)
                    .accept(MediaType.APPLICATION_FORM_URLENCODED)
                    .retrieve()
                    .bodyToMono(KakaoUserResponse.class)
                    .block();
        }
        catch (Exception e){
            throw new CustomException(ErrorCode.OAUTH_USER_INFO_FAILED);
        }
    }
}
