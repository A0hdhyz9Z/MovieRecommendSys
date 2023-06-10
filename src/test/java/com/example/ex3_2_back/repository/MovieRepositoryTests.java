package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

@SpringBootTest
@Slf4j
public class MovieRepositoryTests {
    MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Test
    public void test_findMovieDetails() {
        log.info(movieRepository.findMovieDetails().toString());
    }

    @Test
    public void test_findMovieDetails_Pageable() {
        log.info(movieRepository.findMovieDetails(PageRequest.of(2, 10)).toString());
    }

    @Test
    public void test_findMovieWithTags() {
        movieRepository.findMovieWithTags(Arrays.asList("poem", "Sci-Fi")).forEach(movie -> log.info(movie.toString()));
    }

    @Test
    public void test_findMovieDetailsObjects() {
    }

    @Test
    public void testSpecification() {
//        Specification<Movie> specification= Specification.where()
    }

    @Test
    public void test_findAll() {
        movieRepository.findAll().forEach(movie -> log.info(movie.toString()));
    }

    @Test
    public void test() {

        Page<Movie> dark = movieRepository.findAll(new Example<>() {
            @Override
            public @NotNull Movie getProbe() {
                return Movie.builder().originalTitle("Ark").build();
            }

            @Override
            public @NotNull ExampleMatcher getMatcher() {
                return ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

            }
        }, PageRequest.of(0, 10));



        dark.getContent().forEach(movie -> log.info(movie.getOriginalTitle()));
    }

    @Test
    public void test_incrementSeenCount() {
        movieRepository.incrementSeenCount(862);
    }

}
