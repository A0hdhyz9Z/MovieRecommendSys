package com.example.ex3_2_back.repository;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RecommendRepositoryTests {
    RecommendRepository recommendRepository;

    @Autowired
    public void setRecommendRepository(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    @Test
    public void test() {
        log.info(recommendRepository.findRecommendMovieOfUser("3").toString());
    }
}
