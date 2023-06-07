package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.movie.MovieDetail;
import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.movie.MovieDetailData;
import com.example.ex3_2_back.entity.Actor;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Worker;
import com.example.ex3_2_back.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Result getMovie(@RequestParam int page, @RequestParam int pageSize) {
        return Result.success(MovieDetailData.builder()
                .total(100)
                .build()
                .addMovieDetail(
                        MovieDetail.builder()
                                .movie(Movie.builder()
                                        .originalTitle("功夫熊猫")
                                        .id(10086)
                                        .build())
                                .director("张泽清")
                                .favorite(true)
                                .build()
                                .addTags("动作", "戏剧", "搞笑")
                                .addActors("张泽清", "赵牧", "李宗浩"),
                        MovieDetail.builder().build()
                )
        );
    }

    @GetMapping("/{id}")
    // /movie/123
    public Result one(@PathVariable Integer id) {
        return Result.success(movieRepository.findById(id));
    }

    @PostMapping
    public Result create(@RequestBody Movie movie) {
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success();
    }

}
