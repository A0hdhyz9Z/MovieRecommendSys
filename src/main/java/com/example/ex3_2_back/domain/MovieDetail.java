package com.example.ex3_2_back.domain;

import com.example.ex3_2_back.entity.Actor;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Worker;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDetail {
    Movie movie;
    Worker director;
    final List<Actor> actors = new ArrayList<Actor>();
}
