package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Favorite;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    @Query("select f.movie from Favorite f where f.user.name = :username")
    List<Movie> findFavoriteOfUser(String username);

    boolean existsByUserAndMovie(User user, Movie movie);
}