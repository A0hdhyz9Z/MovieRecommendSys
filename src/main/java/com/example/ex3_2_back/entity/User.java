package com.example.ex3_2_back.entity;

import com.example.ex3_2_back.entity.util.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
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
