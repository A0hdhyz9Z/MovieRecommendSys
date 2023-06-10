package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Favorite;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "FavoriteRepository")
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    @Operation(summary = "通过用户名获取用户收藏-无分页")
    @RestResource(path = "findFavoriteOfUser(String username)")
    @Query("select f.movie from Favorite f where f.user.name = :username")
    List<Movie> findFavoriteOfUser(String username);

    @RestResource(path = "findFavoriteOfUser-Pageable")
    @Query("select f.movie from Favorite f where f.user.name = :username")
    @Operation(summary = "通过用户名获取用户收藏-分页")
    Page<Movie> findFavoriteOfUser(String username, Pageable pageable);

    boolean existsByUserAndMovie(User user, Movie movie);

    Optional<Favorite> findByUserAndMovie(User user, Movie movie);

    @Transactional
    void deleteByUserAndMovie(User user, Movie movie);

}