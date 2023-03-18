package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "crew")
class Crew (
    @Id
    var worker_id: Int=0 ,
    var movie_id:Int=0,
    var department:String="",
    var job:String="",
    var profilePath:String="",
)