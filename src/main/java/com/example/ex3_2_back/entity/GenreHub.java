package com.example.ex3_2_back.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genre_hub")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenreHub {
    @Id
    @Column(name = "genre_hub_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
}