package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Actor;
import com.example.ex3_2_back.entity.Movie;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("select a from Cast c, Actor a where c.actor.id = a.id and c.movie.id = :movieId")
    @RestResource(path = "findActorsOfMovie")
    @Operation(summary = "通过电影ID查询演员")
    List<Actor> findActorsOfMovie(Integer movieId);
}