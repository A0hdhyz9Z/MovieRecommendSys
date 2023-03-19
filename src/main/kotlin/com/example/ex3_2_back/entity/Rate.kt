package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "rate")
class Rate(
    @Id
    @Column(name = "rate_id")
    var id: Int = 0,
    @OneToOne
    @JoinColumn(name = "movie_id")
    var movie: Movie = Movie(),
    @OneToOne
    @JoinColumn(name = "user_id")
    var user: User = User(),
    var rating: Float = 0.0f,
)