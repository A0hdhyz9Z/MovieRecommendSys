package com.example.ex3_2_back.entity;


import com.example.ex3_2_back.entity.util.Gender;
import jakarta.persistence.*;

@Entity
public class Worker {
    @Id
    @Column(name = "worker_id")
    int id = 0;
    Gender gender = Gender.Unknown;
}
