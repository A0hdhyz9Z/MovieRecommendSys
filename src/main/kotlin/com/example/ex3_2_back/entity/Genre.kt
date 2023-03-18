package com.example.ex3_2_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "genre")
class Genre (
    @Id
    var id: Int=0 ,
    @OneToOne
    var genre: Genrehub = Genrehub(),
    @OneToOne
    var movie: Movie = Movie(),
)