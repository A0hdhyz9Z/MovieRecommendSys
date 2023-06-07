package com.example.ex3_2_back.domain.movie;

import com.example.ex3_2_back.entity.Actor;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Worker;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDetailData {
    int total;
    final List<MovieDetail> details = new ArrayList<>();

    public MovieDetailData addMovieDetail(MovieDetail ...details) {
        this.details.addAll(Arrays.asList(details));
        return this;
    }
}
