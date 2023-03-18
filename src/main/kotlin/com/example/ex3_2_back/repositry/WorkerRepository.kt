package com.example.ex3_2_back.repositry;

import com.example.ex3_2_back.entity.Worker
import org.springframework.data.jpa.repository.JpaRepository

interface WorkerRepository : JpaRepository<Worker, Int> {

}