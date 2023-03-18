package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "rate")
class Rate (
    @Id
    var id:Int=0,
    @OneToOne
    var movie:Movie=Movie(),
    @OneToOne
    var user:User=User(),
    var rating:Float=0.0f,

)