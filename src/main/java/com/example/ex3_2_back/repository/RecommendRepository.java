package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<Recommend, Integer> {
}