package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Collection(
    @Id
    @Column(name = "collection_id")
    var id: Int = 0,
)