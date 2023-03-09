package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Collection(
    @Id
    var id: Int = 0,
)