package com.example.ex3_2_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_cast")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cast {
    @Id
    @Column(name = "cast_id")
    int id = 0;
    @Column(name = "cast_order")
    int order = 0;
    @OneToOne
    @JoinColumn(name = "actor_id")
    Actor actor = new Actor();
    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie = new Movie();
    @Column(name = "cast_character")
    String character = "";
    @Column(name = "profile_path")
    String profilePath = "";
}