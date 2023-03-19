package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Actor(
    @Id
    @Column(name = "actor_id")
    var id: Int = 0,
    var gender: Gender = Gender.Unknown
)