package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "t_Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Boolean adult;
    Integer budget;
    String homepage;
    String originalLanguage;
    String originalTitle;
    Float popularity;
    String posterPath;
    String releaseDate;
    Integer revenue;
    Integer runtime;
    String status;
    String tagline;
    String title;
    Float voteAverage;
    Integer voteCount;
    String overview;
    Integer seenCount ;
}

