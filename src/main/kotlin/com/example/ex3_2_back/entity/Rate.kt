package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "rate")
class Rate (
    @Id
    var rating:Float=0.0f,
    var movie_id:Int=0,
    var user_id:Int=0,
)