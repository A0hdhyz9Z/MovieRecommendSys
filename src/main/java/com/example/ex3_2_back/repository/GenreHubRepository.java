package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.GenreHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreHubRepository extends JpaRepository<GenreHub, Integer> {
    @Query("select gm.genreHub from Genre gm where gm.movie.id = :movieId")
    List<GenreHub> findGenreHubOfMovie(Integer movieId);
}