package com.example.ex3_2_back.service;

import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate save(Rate rate) {
        return rateRepository.save(rate);
    }
}
