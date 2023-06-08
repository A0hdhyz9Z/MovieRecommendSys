package com.example.ex3_2_back.domain.movie;

import com.example.ex3_2_back.entity.Movie;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDomain {
    Movie movie;
}
