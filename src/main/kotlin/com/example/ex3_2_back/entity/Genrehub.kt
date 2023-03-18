package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "genrehub")
class Genrehub (
    @Id
    @Column(name = "genre_id")
    var id: Int=0 ,
    @Column(name = "genre_name")
    var name:String="",
)