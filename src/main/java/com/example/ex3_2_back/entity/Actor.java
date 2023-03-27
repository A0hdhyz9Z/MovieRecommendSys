package com.example.ex3_2_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @Column(name = "actor_id")
    int id = 0;
    Gender gender = Gender.Unknown;
}
