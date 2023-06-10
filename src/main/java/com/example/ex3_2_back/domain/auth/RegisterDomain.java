package com.example.ex3_2_back.domain.auth;

import com.example.ex3_2_back.entity.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RegisterDomain {
    @NotBlank
    private String username;
    @NotBlank
    private String password1;
    @NotBlank
    private String password2;
    @Email
    private String email;
    private String phone;
    @Builder.Default
    private Gender gender = Gender.Unknown;
}
