package com.example.ex3_2_back.repositorytest;

import com.example.ex3_2_back.entity.Recommendation;
import com.example.ex3_2_back.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class RecommendationRepositoryTest {

    private RecommendationRepository recommendationRepository;

    @Autowired
    public void setRecommendationRepository(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Test
    public void testAll() {
        List<Recommendation> all = recommendationRepository.findAll();
        log.info(all.toString());
    }
}
