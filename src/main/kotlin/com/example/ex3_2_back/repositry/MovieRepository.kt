package com.example.ex3_2_back.repositry;

import com.example.ex3_2_back.entity.Movie
import com.example.ex3_2_back.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface MovieRepository : JpaRepository<Movie, Int>