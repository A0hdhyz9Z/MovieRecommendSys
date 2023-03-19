package com.example.ex3_2_back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tag_hub")
class TagHub(
    @Id
    @Column(name = "keyword_id")
    var id: Int = 0,
    @Column(name = "keyword_name")
    var name: String = "",
)