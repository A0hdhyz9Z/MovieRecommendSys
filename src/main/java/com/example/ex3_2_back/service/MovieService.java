package com.example.ex3_2_back.service;

import com.example.ex3_2_back.domain.movie.MovieDetail;
import com.example.ex3_2_back.entity.Actor;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.TagHub;
import com.example.ex3_2_back.repository.ActorRepository;
import com.example.ex3_2_back.repository.MovieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    private ActorRepository actorRepository;

    @Autowired
    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDetail> findMovieDetails() {

        final List<MovieDetail> details = movieRepository.findMovieDetails();

        for (MovieDetail detail : details) {
            detail.addActors(actorRepository.findActorsOfMovie(detail.getMovie().getId()).stream().map(Actor::getName).collect(Collectors.joining()));
        }

        return details;
    }

    public List<MovieDetail> findMovieDetails(Pageable pageable) {

        final List<MovieDetail> details = movieRepository.findMovieDetails(pageable);

        for (MovieDetail detail : details) {
            detail.addActors(actorRepository.findActorsOfMovie(detail.getMovie().getId()).stream().map(Actor::getName).collect(Collectors.joining()));
        }

        return details;
    }

}
