package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "genre_hub")
class GenreHub(
    @Id
    @Column(name = "genre_hub_id")
    var id: Int = 0,
    var name: String = "",
)