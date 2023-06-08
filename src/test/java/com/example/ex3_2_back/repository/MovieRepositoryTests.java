package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        movieRepository.findMovieWithTags(Arrays.asList("War", "Sci-Fi")).forEach(movie -> log.info(movie.toString()));
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

        var l = movieRepository.findAll(new Example<Movie>() {
            @Override
            public @NotNull Movie getProbe() {
                return Movie.builder().originalTitle("1").build();
            }

            @Override
            public @NotNull ExampleMatcher getMatcher() {
                return ExampleMatcher.matching()
                        .withMatcher("seenCount", ExampleMatcher.GenericPropertyMatcher::exact)
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                        .withIgnoreCase();
            }
        });

        l.forEach(m -> log.info(m.getOriginalTitle()));
    }


}
