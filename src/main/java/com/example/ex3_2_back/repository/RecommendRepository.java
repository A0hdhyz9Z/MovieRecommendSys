package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Recommend;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "RecommendRepository")
@Tag(name = "RecommendRepository")
public interface RecommendRepository extends JpaRepository<Recommend, Integer> {
    @Query("select r.movie from Recommend r where r.user.name = :username order by r.score desc ")
    @RestResource(path = "findRecommendMovieOfUser-Pageable")
    Page<Movie> findRecommendMovieOfUser(String username, Pageable pageable);

    @Query("select r.movie from Recommend r where r.user.name = :username order by r.score desc ")
    List<Movie> findRecommendMovieOfUser(String username);
}