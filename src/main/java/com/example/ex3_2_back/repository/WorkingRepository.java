package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Worker;
import com.example.ex3_2_back.entity.Working;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingRepository extends JpaRepository<Working, Integer> {
}