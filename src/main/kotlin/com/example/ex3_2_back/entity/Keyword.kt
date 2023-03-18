package com.example.ex3_2_back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "keyword")
class Keyword (
    @Id
    var id: Int=0 ,
    @OneToOne
    var keyword: Taghub = Taghub(),
    @OneToOne
    var movie: Movie = Movie(),
)