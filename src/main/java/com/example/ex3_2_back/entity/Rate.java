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
public class Rate {
    @Id
    @Column(name = "rate_id")
    int id = 0;
    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie = new Movie();
    @OneToOne
    @JoinColumn(name = "user_id")
    User user = new User();
    float rating = 0.0f;
}
