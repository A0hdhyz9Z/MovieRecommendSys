package com.example.ex3_2_back.domain.movie;

import com.example.ex3_2_back.entity.*;
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
    List<GenreHub> genreHubs;
    User user;
    Boolean favorite;
    Float rating;
}
