package com.example.ex3_2_back.entity;


import jakarta.persistence.*;

@Entity
public class Collection {
    @Id
    @Column(name = "collection_id")
    int id = 0;
}