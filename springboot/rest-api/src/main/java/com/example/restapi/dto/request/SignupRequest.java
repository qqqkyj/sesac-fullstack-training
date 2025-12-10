package com.example.restapi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequest {
    @NotBlank(message = "username은 필수입니다.")
    @Size(min = 4, max = 20, message = "username길이는 4 ~ 20글자 이내로 작성해야 합니다.")
    private String username;

    @NotBlank(message = "password는 필수입니다.")
    private String password;

    @NotBlank(message = "email은 필수입니다.")
    @Email(message = "email 형식이 올바르지 않습니다.")
    private String email;
    private String name;
}
