package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.GenreHub;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class GenreHubRepositoryTests {
    GenreHubRepository genreHubRepository;

    @Autowired
    public void setGenreHubRepository(GenreHubRepository genreHubRepository) {
        this.genreHubRepository = genreHubRepository;
    }

    @Test
    public void test(){
        List<GenreHub> genreHubs = genreHubRepository.findGenreHubOfMovie(862);
        log.info(genreHubs.toString());
    }
}
