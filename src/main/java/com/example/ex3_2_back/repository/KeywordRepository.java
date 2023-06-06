package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
}