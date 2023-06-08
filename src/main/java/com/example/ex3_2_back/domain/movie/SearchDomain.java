package com.example.ex3_2_back.domain.movie;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.TagHub;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDomain {
    Movie movie;
    final List<String> tags = new ArrayList<>();
}
