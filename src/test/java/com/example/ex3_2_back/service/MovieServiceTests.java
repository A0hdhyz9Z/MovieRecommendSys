package com.example.ex3_2_back.service;

import com.example.ex3_2_back.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
@Slf4j
public class MovieServiceTests {
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @Test
    public void test_findMovieDetails() {
        movieService.findMovieDetails().forEach(movieDetail -> log.info(movieDetail.getMovie().getOriginalTitle()));
    }

    @Test
    public void test_findMovieDetails_Pageable() {
        movieService.findMovieDetails(PageRequest.of(2, 10)).forEach(movieDetail -> log.info(movieDetail.getMovie().getOriginalTitle()));
    }
}
