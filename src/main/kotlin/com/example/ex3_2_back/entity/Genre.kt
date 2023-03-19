package com.example.ex3_2_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "genre")
class Genre(
    @Id
    @Column(name = "genre_id")
    var id: Int = 0,
    @OneToOne
    @JoinColumn(name = "genre_hub_id")
    var genreHub: GenreHub = GenreHub(),
    @OneToOne
    @JoinColumn(name = "movie_id")
    var movie: Movie = Movie(),
)