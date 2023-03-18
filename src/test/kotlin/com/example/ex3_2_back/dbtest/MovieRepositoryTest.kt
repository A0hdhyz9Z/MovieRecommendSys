package com.example.ex3_2_back.dbtest

import com.example.ex3_2_back.entity.Movie
import com.example.ex3_2_back.repositry.MovieRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    lateinit var movieRepository: MovieRepository

    @Test
    fun s() {
        movieRepository.save(Movie(title = "dadawd"));
    }

}