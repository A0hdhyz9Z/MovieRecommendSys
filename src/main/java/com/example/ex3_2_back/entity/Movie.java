package com.example.ex3_2_back.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
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
    @Schema(defaultValue = "862")
    Integer id;
    Boolean adult;
    Integer budget;
    String homepage;
    @Schema(defaultValue = "功夫熊猫")
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
    Integer seenCount;
    @Schema(defaultValue = "不知道什么公司")
    String companyName;
    @Schema(defaultValue = "美国")
    String countryName;
}

