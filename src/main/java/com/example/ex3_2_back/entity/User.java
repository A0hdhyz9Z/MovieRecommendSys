package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(unique = true, nullable = false)
    String name;
    String password;
    @Builder.Default
    Gender gender = Gender.Unknown;
    @Email
    String email;
    String phone;
    String address;
}
