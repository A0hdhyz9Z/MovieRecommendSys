package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(
    @Id
    var id: Int = 0,
    var name: String = "",
    var password: String = "",
    @Transient
    var token: String = "",
    @Transient
    var isLogin: Boolean = false,
    @Transient
    var requestTime: Boolean = false
)