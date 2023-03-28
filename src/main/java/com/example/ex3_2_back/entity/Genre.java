package com.example.ex3_2_back.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genre")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @Column(name = "genre_id")
    int id = 0;
    @OneToOne
    @JoinColumn(name = "genre_hub_id")
    GenreHub genreHub = new GenreHub();

    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie = new Movie();
}