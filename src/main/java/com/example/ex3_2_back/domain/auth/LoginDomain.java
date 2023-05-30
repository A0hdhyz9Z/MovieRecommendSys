package com.example.ex3_2_back.domain.auth;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginDomain {
    private String username;
    private String password;
}
