package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Recommend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend, Integer> {
    @Query("select r.movie from Recommend r, User u where r.user.id = u.id and u.name = :username order by r.score desc ")
    Page<Movie> findRecommendMovieOfUser(String username, Pageable pageable);

    @Query("select r.movie from Recommend r, User u where r.user.id = u.id and u.name = :username order by r.score desc ")
    @RestResource(path = "findRecommendMovieOfUser-Pageable")
    List<Movie> findRecommendMovieOfUser(String username);
}