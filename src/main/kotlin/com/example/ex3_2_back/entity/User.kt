package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
class User(
    @Id
    var id: Int = 0,
    var name: String = "",
    var password: String = "",
    @Transient
    var token: String = "",
)