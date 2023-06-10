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
public class DetailData {
    List<Actor> actors;
    Worker director;
    Movie movie;
}
