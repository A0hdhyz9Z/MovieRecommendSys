package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "genrehub")
class Genrehub (
    @Id
    var genre_id: Int=0 ,
    var genre_name:String="",
)