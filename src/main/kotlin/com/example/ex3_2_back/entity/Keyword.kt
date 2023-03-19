package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "keyword")
class Keyword (
    @Id
    @Column(name = "keyword_id")
    var id: Int=0,
    @OneToOne
    @JoinColumn(name = "tag_hub_id")
    var tagHub: TagHub = TagHub(),
    @OneToOne
    @JoinColumn(name = "movie_id")
    var movie: Movie = Movie(),
)