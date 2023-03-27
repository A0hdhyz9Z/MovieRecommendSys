package com.example.ex3_2_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tag_hub")
public class TagHub {
    @Id
    @Column(name = "keyword_id")
    int id = 0;
    @Column(name = "keyword_name")
    String name = "";
}
