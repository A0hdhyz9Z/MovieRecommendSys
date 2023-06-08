package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.movie.SearchDomain;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.repository.MovieRepository;
import com.example.ex3_2_back.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Result getMovie(@RequestParam int page, @RequestParam int pageSize) {
        return Result.success(movieService.findMovieDetails(PageRequest.of(page - 1, pageSize)));
    }

    //    @GetMapping("/{id}")
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

    @PostMapping("/search")
    public Result search(@RequestBody SearchDomain searchDomain) {
        return Result.success();
    }

    @GetMapping("/favorite")
    public Result favorite(@NotNull HttpServletRequest request) {
        String username = request.getHeader("username");
        return Result.success();
    }


}
