package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.data.DataResult;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repositry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/auth")
public class AuthController {

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    @PostMapping("/login")
    DataResult<String> login(@RequestBody User user) {

        Optional<User> optUserInDB = userRepository.findById(user.getId());

        if (optUserInDB.isEmpty()) {
            return new DataResult<>(false, "该用户不存在", "");
        }

        User userInDB = optUserInDB.get();

        if (!userInDB.getPassword().equals(user.getPassword())) {
            return new DataResult<>(false, "密码错误", "");
        }

        // 数据库session逻辑

        return new DataResult<>(true, "登陆成功", "Token?");

    }
}
