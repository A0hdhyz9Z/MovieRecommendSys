package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}