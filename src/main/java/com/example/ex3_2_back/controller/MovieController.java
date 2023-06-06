package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    // https://example.com/api/movies?page=${page}&pageSize=${pageSize}
    public Result getMovie(@RequestParam int page, @RequestParam int pageSize) {
        var data = new HashMap<String, Object>();
        data.put("movies", movieRepository.findByOrderByVoteAverage(PageRequest.of(page-1, pageSize)));
        data.put("total", movieRepository.count());
        return Result.success(data);
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
