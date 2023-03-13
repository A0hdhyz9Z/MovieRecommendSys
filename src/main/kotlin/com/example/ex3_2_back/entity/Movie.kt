package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "movies")
class Movie(
    @Id
    var id: Int = 0,
    var adult: Boolean = false,
    var budget: Int = 0,
    var homepage: String = "",
)