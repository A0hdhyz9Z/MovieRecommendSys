package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "repo-worker")
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    @Query("select w.worker from Working w where w.position = 'director' and w.movie.id = :movieId")
    Optional<Worker> getDirectorOfMovie(Integer movieId);

}