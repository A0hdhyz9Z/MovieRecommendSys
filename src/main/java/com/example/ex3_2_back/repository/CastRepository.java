package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastRepository extends JpaRepository<Cast, Integer> {
}