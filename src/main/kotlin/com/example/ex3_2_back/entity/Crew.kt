package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "crew")
class Crew (
    @Id
    var id: Int=0 ,

    @OneToOne
    var worker: Worker = Worker(),
    @OneToOne
    var movie: Movie = Movie(),

    var department:String="",
    var job:String="",
    var profilePath:String="",
)