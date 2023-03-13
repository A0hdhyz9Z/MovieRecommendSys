package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Worker(
    @Id
    var id: Int = 0,
    var gender: Boolean = false,
)
