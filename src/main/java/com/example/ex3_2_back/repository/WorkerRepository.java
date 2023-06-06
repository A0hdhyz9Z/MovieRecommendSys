package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}