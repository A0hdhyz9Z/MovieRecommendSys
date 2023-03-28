package com.example.ex3_2_back.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "keyword")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Keyword {
    @Id
    @Column(name = "keyword_id")
    int id = 0;
    @OneToOne
    @JoinColumn(name = "tag_hub_id")
    TagHub tagHub = new TagHub();

    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie = new Movie();
}