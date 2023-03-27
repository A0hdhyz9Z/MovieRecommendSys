package com.example.ex3_2_back.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "keyword")
public class Keyword {
    @Id
    @Column(name = "keyword_id")
    int id = 0;
    @OneToOne
    @JoinColumn(name = "tag_hub_id")
    TagHub tagHub = new TagHub();

    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie = new Movie();
}