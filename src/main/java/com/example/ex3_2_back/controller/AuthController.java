package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.auth.LoginDomain;
import com.example.ex3_2_back.domain.auth.RegisterDomain;
import com.example.ex3_2_back.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @NotNull
    public Result login(@RequestBody @NotNull @Valid LoginDomain loginDomain, HttpServletResponse response) {
        return authService.login(loginDomain, response);
    }

    @RequestMapping("/logout")
    @NotNull
    public Result logout(HttpServletResponse response) {
        authService.removeTokenCookie(response);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody @NotNull @Valid RegisterDomain registerDomain) {
        return authService.register(registerDomain);
    }

}
