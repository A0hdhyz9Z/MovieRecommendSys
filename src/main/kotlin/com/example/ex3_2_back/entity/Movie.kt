package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Movie(
    @Id
    var id: Int = 0,
    var adult: Boolean = false,
    var budget: Int = 0,
    var homepage: String = "",
)