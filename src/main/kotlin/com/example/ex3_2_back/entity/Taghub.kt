package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "taghub")
class Taghub (
    @Id
    var keyword_id: Int=0 ,
    var keyword_name:String="",
)