package com.example.ex3_2_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tag_hub")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TagHub {
    @Id
    @Column(name = "keyword_id")
    Integer id;
    @Column(name = "keyword_name")
    String name;
}
