package com.example.ex3_2_back.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "genre_hub")
public class GenreHub {
    @Id
    @Column(name = "genre_hub_id")
    int id = 0;
    String name = "";
}