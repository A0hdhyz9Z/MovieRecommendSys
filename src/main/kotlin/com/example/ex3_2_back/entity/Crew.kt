package com.example.ex3_2_back.entity

import jakarta.persistence.*

@Entity
@Table(name = "crew")
class Crew(
    @Id
    @Column(name = "crew_id")
    var id: Int = 0,
    @OneToOne
    @JoinColumn(name = "worker_id")
    var worker: Worker = Worker(),
    @OneToOne
    @JoinColumn(name = "movie_id")
    var movie: Movie = Movie(),
    var department: String = "",
    var job: String = "",
    var profilePath: String = "",
)