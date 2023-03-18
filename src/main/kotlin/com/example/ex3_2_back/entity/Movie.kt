package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "movies")
class Movie (
    @Id
    @Column(name = "movie_id")
    var id: Int = 0,
    var adult: Boolean = false,
    var budget: Int = 0,
    var homepage: String = "",
    var original_language: String = "",
    var original_title: String = "",
    var popularity: Float = 0.0f,
    var posterPath: String = "",
    var release_date: String = "",
    var revenue: Int = 0,
    var runtime: Int = 0,
    var status: String = "",
    var tagline: String = "",
    var title: String = "",
    var vote_average: Float = 0.0f,
    var vote_count: Int = 0,
    var overview: String = "",
)