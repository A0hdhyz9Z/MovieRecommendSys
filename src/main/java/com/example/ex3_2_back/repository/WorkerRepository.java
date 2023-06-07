package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-worker")
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}