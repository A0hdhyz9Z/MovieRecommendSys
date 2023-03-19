package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "movie")
class Movie (
    @Id
    @Column(name = "movie_id")
    var id: Int = 0,
    var adult: Boolean = false,
    var budget: Int = 0,
    var homepage: String = "",
    @Column(name = "original_language")
    var originalLanguage: String = "",
    @Column(name = "original_title")
    var originalTitle: String = "",
    var popularity: Float = 0.0f,
    @Column(name = "poster_path")
    var posterPath: String = "",
    @Column(name = "release_date")
    var releaseDate: String = "",
    var revenue: Int = 0,
    var runtime: Int = 0,
    var status: String = "",
    var tagline: String = "",
    var title: String = "",
    @Column(name = "vote_average")
    var voteAverage: Float = 0.0f,
    @Column(name = "vote_count")
    var voteCount: Int = 0,
    var overview: String = "",
)