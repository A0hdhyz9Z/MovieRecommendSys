package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "recommendation")
public class Recommend {
    @Id
    @Column(name = "recommend_id")
    // 加上自动生成
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
    Float score;
}
