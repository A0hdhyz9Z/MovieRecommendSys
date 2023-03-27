package com.example.ex3_2_back.entity;

import com.example.ex3_2_back.entity.util.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    int id = 0;
    String name = "";
    String password = "";
    Gender gender = Gender.Unknown;
    @Transient
    String token = "";
}
