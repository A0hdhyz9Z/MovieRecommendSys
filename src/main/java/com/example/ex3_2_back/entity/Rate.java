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
    @Column(name = "rate_id")
    // 加上自动生成
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    Float rating;
}
