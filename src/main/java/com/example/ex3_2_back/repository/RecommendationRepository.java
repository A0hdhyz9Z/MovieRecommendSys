package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {
}
