package com.example.ex3_2_back.domain.movie;

import com.example.ex3_2_back.entity.Actor;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Worker;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDetail {
    public MovieDetail(Movie movie, String director) {
        this.movie = movie;
        this.director = director;
    }

    public MovieDetail(Movie movie, String director, String... actors) {
        this.movie = movie;
        this.director = director;
        addActors(actors);
    }

    Movie movie;
    String director;
    final List<String> tags = new ArrayList<>();
    final List<String> actors = new ArrayList<>();
    boolean favorite;

    public MovieDetail addActors(String... actors) {
        this.actors.addAll(Arrays.asList(actors));
        return this;
    }

    public MovieDetail addActors(Collection<String> actors) {
        this.actors.addAll(actors);
        return this;
    }

    public MovieDetail addTags(String... tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }
}
