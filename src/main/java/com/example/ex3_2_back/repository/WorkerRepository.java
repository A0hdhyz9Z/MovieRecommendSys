package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Worker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "repo-worker")
@Tag(name = "获取工作人员")
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    @Query("select w.worker from Working w where w.position = 'director' and w.movie.id = :movieId")
    @RestResource(path = "getDirectorOfMovie")
    @Operation(summary = "获取电影导演")
    Optional<Worker> getDirectorOfMovie(Integer movieId);

}