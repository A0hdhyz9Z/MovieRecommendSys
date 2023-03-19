package com.example.ex3_2_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "cast")
class Cast(
    @Id
    @Column(name = "cast_id")
    var id: Int = 0,
    @Column(name = "cast_order")
    var order: Int = 0,
    @OneToOne
    @JoinColumn(name = "actor_id")
    var actor: Actor = Actor(),
    @OneToOne
    @JoinColumn(name = "movie_id")
    var movie: Movie = Movie(),
    @Column(name = "cast_character")
    var character: String = "",
    @Column(name = "profile_path")
    var profilePath: String = "",
)