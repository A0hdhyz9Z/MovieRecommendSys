package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.rate.PostRateDomain;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.MovieRepository;
import com.example.ex3_2_back.repository.RateRepository;
import com.example.ex3_2_back.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rate")
@Slf4j
@Tag(name = "RateController", description = "RateController")
public class RateController {

    RateRepository rateRepository;

    UserRepository userRepository;

    MovieRepository movieRepository;

    @Autowired
    @Operation(summary = "setMovieRepository", description = "setMovieRepository")
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    @Operation(summary = "setUserRepository", description = "setUserRepository")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    @Operation(summary = "setRateRepository",description = "setRateRepository")
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @GetMapping("/{id}")
    @Operation(summary = "单个ID查询评分",description = "单个ID查询评分")
    public TResult<Optional<Rate>> findOne(@PathVariable Integer id) {
        return TResult.success(rateRepository.findById(id));
    }

    @GetMapping
    @Operation(summary = "查询所有用户评分",description = "查询所有用户评分")
    public TResult<List<Rate>> findAllOfUser(@RequestHeader("username") String username) {
        return TResult.success(rateRepository.findAllByUser(User.builder().name(username).build()));
    }

    //    TO:DO bug待修改
    @PostMapping("/{movieId}")
    @Operation(summary = "用户进行评分",description = "用户进行评分")
    public Result postRate(
            @Schema(defaultValue = "15") @RequestHeader("username") String username,
            @Schema(defaultValue = "862") @PathVariable Integer movieId,
            @NotNull @RequestBody PostRateDomain postRateDomain
    ) {

        Optional<User> optionalUser = userRepository.findByName(username);
        if (optionalUser.isEmpty()) {
            return Result.error("No user with username " + username);
        }
        User user = optionalUser.get();

        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            return Result.error("No movie with movieId " + movieId);
        }
        Movie movie = optionalMovie.get();

        if (rateRepository.existsByUserAndMovie(user, movie)) {
            return Result.error("user " + username + " already rated " + movieId);
        }
        rateRepository.save(Rate.builder().user(user).movie(movie).rating(postRateDomain.getRating()).build());

        return Result.success();
    }


}
