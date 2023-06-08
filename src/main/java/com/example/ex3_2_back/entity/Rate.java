package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rate")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rate {
    @Id
    // 加上自动生成
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @OneToOne
    Movie movie;
    @OneToOne
    User user;
    Float rating;
}
