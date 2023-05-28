package com.example.ex3_2_back.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @Column(name = "worker_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Gender gender = Gender.Unknown;
}
