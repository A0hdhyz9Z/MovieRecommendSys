package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Cast;
import com.example.ex3_2_back.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CastRepository extends JpaRepository<Cast, Integer> {
    List<Cast> findByMovie(Movie movie);
}
