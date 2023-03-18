package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "genre")
class Genre (
    @Id
    var genre_id: Int=0 ,
    var movie_id: Int=0,
)