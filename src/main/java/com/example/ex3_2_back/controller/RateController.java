package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.RateRepository;
import com.example.ex3_2_back.service.RateService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
@Slf4j
public class RateController {

    private RateRepository rateRepository;
    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
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

//    TO:DO bug待修改
    @PostMapping
    public Result create(@RequestBody Rate rate) {
        return Result.success(rateService.save(rate));
    }


}
