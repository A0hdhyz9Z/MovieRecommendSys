package com.example.ex3_2_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "cast")
class Cast(
    @Id
    var castId: Int = 0,
    @Column(name = "order_")
    var order: Int = 0,
    @OneToOne
    var actor: Actor = Actor(),
    @OneToOne
    var movie: Movie = Movie(),
    @Column(name = "character_")
    var character: String = "",
    var profilePath: String = "",
)