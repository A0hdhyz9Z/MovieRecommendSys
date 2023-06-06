package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "repo-movie")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByOrderByVoteAverage();
    // @czy 这里 Pageable pageable
    List<Movie> findByOrderByVoteAverage(Pageable pageable);
}
