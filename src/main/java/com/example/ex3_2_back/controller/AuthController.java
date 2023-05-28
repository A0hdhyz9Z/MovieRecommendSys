package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.data.Result;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.UserRepository;
import com.example.ex3_2_back.security.MySecurity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/auth"))
@Slf4j
public class AuthController {

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    @Autowired
    public void setMySecurity(MySecurity mySecurity) {
        this.mySecurity = mySecurity;
    }

    MySecurity mySecurity;

    @PostMapping("/register")
    Result register(@NotNull @RequestBody User user) {

        Optional<User> optUserInDB = userRepository.findById(user.getId());

        if (optUserInDB.isPresent()) {
            return new Result(false, "该用户已存在");
        }

        userRepository.save(user);

        return new Result(true, "注册成功");

    }


    @PostMapping("/login")
    Result login(@NotNull @RequestBody User user, HttpServletResponse response) {

        if (!userRepository.existsByNameAndPassword(user.getName(), user.getPassword())) {
            return new Result(false, "Id或者密码错误", "")
                    .addDevMessages(userRepository.findByName(user.getName()));
        }

        // 数据库session逻辑

        setTokenCookie(user.getName(), response);

        return new Result(true, "登陆成功");

    }

    public void setTokenCookie(String username, @NotNull HttpServletResponse response) {
        String token = mySecurity.genToken(User.builder().name(username).build());
        log.info(String.format("new token for %s: %s", username, token));
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
    }
}
