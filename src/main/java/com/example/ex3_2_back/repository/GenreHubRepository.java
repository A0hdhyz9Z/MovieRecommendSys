package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.GenreHub;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface GenreHubRepository extends JpaRepository<GenreHub, Integer> {
    @Query("select gm.genreHub from Genre gm where gm.movie.id = :movieId")
    @Operation(summary = "根据ID获取电影种类")
    @RestResource(path = "findGenreHubOfMovie")
    List<GenreHub> findGenreHubOfMovie(Integer movieId);
}