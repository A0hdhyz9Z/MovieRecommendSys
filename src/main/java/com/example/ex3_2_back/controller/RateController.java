package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.RateRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public TResult<Optional<Rate>> findOne(@PathVariable Integer id) {
        return TResult.success(rateRepository.findById(id));
    }

    @GetMapping
    public TResult<List<Rate>> findAllOfUser(@Nullable @RequestHeader(name = "username", required = false) String username) {
        return TResult.success(rateRepository.findAllByUser(User.builder().name(username).build()));
    }

    //    TO:DO bug待修改
    @PostMapping
    public Result create(@RequestBody Rate rate) {
        return Result.success(rateRepository.save(rate));
    }


}
