package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByOrderByVoteAverage();
    List<Movie> findByOrderByVoteAverage(Pageable pageable);
}
