package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.RateRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
@Slf4j
@Tag(name = "RateController")
public class RateController {

    RateRepository rateRepository;
    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(rateRepository.findById(id));
    }

    @GetMapping
    public Result findAllOfUser(HttpServletRequest request, @Nullable @RequestHeader(name = "username", required = false) String username) {
        return Result.success(rateRepository.findAllByUser(User.builder().name(username).build()));
    }

    //    TO:DO bug待修改
    @PostMapping
    public Result create(@RequestBody Rate rate) {
        return Result.success(rateRepository.save(rate));
    }


}
