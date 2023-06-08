package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.entity.Favorite;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.RateRepository;
import com.example.ex3_2_back.repository.UserRepository;
import com.example.ex3_2_back.service.RateService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
@Slf4j
public class RateController {

    RateRepository rateRepository;

    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(rateRepository.findById(id));
    }

    @GetMapping
    public Result findAllOfUser(HttpServletRequest request) {
        var username = request.getAttribute("username").toString();
        log.info(username);
        return Result.success(rateRepository.findAllByUser(User.builder().name(username).build()));
    }

    @PostMapping("/{movieId}")
    public Result create(HttpServletRequest request,@RequestBody Rate rate, @PathVariable Integer movieId) {
        String username = request.getHeader("username");
        var optUser=userRepository.findByName(username);
        if (optUser.isEmpty()) {
            return Result.error("用户不存在");
        }

        User user = optUser.get();

        return Result.success(Rate.builder()
                .user(user)
                .movie(Movie.builder().id(movieId).build())
                .build());
    }


}
