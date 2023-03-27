package com.example.ex3_2_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @Column(name = "rate_id")
    int id = 0;
    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie = new Movie();
    @OneToOne
    @JoinColumn(name = "user_id")
    User user = new User();
    float rating = 0.0f;
}
