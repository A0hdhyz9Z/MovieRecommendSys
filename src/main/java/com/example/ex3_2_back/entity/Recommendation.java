package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recommendation")
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    @OneToOne
    @JoinColumn(name = "movie1_id")
    Movie movie1;
    @OneToOne
    @JoinColumn(name = "movie2_id")
    Movie movie2;
    @OneToOne
    @JoinColumn(name = "movie3_id")
    Movie movie3;
    @OneToOne
    @JoinColumn(name = "movie4_id")
    Movie movie4;
    @OneToOne
    @JoinColumn(name = "movie5_id")
    Movie movie5;
    @OneToOne
    @JoinColumn(name = "movie6_id")
    Movie movie6;
    @OneToOne
    @JoinColumn(name = "movie7_id")
    Movie movie7;
    @OneToOne
    @JoinColumn(name = "movie8_id")
    Movie movie8;
    @OneToOne
    @JoinColumn(name = "movie9_id")
    Movie movie9;
    @OneToOne
    @JoinColumn(name = "movie10_id")
    Movie movie10;

    @OneToOne
    @JoinColumn(name = "movie11_id")
    Movie movie11;
    @OneToOne
    @JoinColumn(name = "movie12_id")
    Movie movie12;
    @OneToOne
    @JoinColumn(name = "movie13_id")
    Movie movie13;
    @OneToOne
    @JoinColumn(name = "movie14_id")
    Movie movie14;
    @OneToOne
    @JoinColumn(name = "movie15_id")
    Movie movie15;
    @OneToOne
    @JoinColumn(name = "movie16_id")
    Movie movie16;
    @OneToOne
    @JoinColumn(name = "movie17_id")
    Movie movie17;
    @OneToOne
    @JoinColumn(name = "movie18_id")
    Movie movie18;
    @OneToOne
    @JoinColumn(name = "movie19_id")
    Movie movie19;
    @OneToOne
    @JoinColumn(name = "movie20_id")
    Movie movie20;

}
