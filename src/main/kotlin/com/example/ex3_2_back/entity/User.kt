package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Builder

@Entity
class User(
    @Id
    @Column(name = "user_id")
    var id: Int = 0,
    var name: String = "",
    var password: String = "",
    var gender: Gender = Gender.Unknown,
    @Transient
    var token: String = "",

)