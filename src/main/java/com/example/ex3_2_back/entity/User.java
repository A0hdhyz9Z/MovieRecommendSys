package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_User")
public class User {
    @Id
    String name;
    String password;
    @Builder.Default
    Gender gender = Gender.Unknown;
    String email;
    String phone;
    String address;
}
