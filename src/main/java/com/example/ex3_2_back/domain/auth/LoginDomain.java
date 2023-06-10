package com.example.ex3_2_back.domain.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginDomain {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
