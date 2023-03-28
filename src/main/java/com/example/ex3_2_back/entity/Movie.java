package com.example.ex3_2_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @Column(name = "movie_id")
    int id = 0;
    Boolean adult = false;
    int budget = 0;
    String homepage = "";
    @Column(name = "original_language")
    String originalLanguage = "";
    @Column(name = "original_title")
    String originalTitle = "";
    Float popularity = 0.0f;
    @Column(name = "poster_path")
    String posterPath = "";
    @Column(name = "release_date")
    String releaseDate = "";
    int revenue = 0;
    int runtime = 0;
    String status = "";
    String tagline = "";
    String title = "";
    @Column(name = "vote_average")
    Float voteAverage = 0.0f;
    @Column(name = "vote_count")
    int voteCount = 0;
    String overview = "";
}

