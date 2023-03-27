package com.example.ex3_2_back.config;

import com.example.ex3_2_back.util.TestAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAlgorithmConfiguration {
    @Bean
    public TestAlgorithm getTestAlgorithm() {
        return new TestAlgorithm();
    }



}