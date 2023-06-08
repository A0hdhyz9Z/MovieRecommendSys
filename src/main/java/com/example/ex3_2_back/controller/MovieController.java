package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.movie.FavoriteResponseData;
import com.example.ex3_2_back.domain.movie.FilterDomain;
import com.example.ex3_2_back.domain.movie.MovieDetailData;
import com.example.ex3_2_back.domain.movie.SearchDomain;
import com.example.ex3_2_back.entity.Favorite;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.*;
import com.example.ex3_2_back.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    UserRepository userRepository;
    RecommendRepository recommendRepository;

    @Autowired
    public void setRecommendRepository(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    WorkerRepository workerRepository;

    @Autowired
    public void setWorkerRepository(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    ActorRepository actorRepository;

    @Autowired
    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    FavoriteRepository favoriteRepository;

    @Autowired
    public void setFavoriteRepository(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

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
        // return Result.success(movieService.findMovieDetails(PageRequest.of(page - 1, pageSize)));
        return Result.success(movieRepository.findByOrderByVoteAverage(PageRequest.of(page - 1, pageSize)));
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
    public Result search(@RequestBody SearchDomain searchDomain, @RequestParam int page, @RequestParam int pageSize) {
        return Result.success(movieRepository.findAll(new Example<Movie>() {
            @Override
            public @NotNull Movie getProbe() {
                return searchDomain.getMovie();
            }

            @Override
            public @NotNull ExampleMatcher getMatcher() {
                return ExampleMatcher.matchingAll()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                        .withIgnoreCase();
            }
        }, PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/filter")
    public Result filter(@RequestBody FilterDomain filterDomain, @RequestParam int page, @RequestParam int pageSize) {
        return Result.success(movieRepository.findMovieWithTags(filterDomain.getTags(), PageRequest.of(page - 1, pageSize)));
    }

    @GetMapping("/favorite")
    public Result getFavorite(@NotNull HttpServletRequest request) {
        String username = request.getHeader("username");
        return Result.success(favoriteRepository.findFavoriteOfUser(username));
    }

    @PostMapping("/favorite/{movieId}")
    public Result setFavorite(@NotNull HttpServletRequest request, @PathVariable Integer movieId) {
        String username = request.getHeader("username");
        Optional<User> optionalUser = userRepository.findByName(username);

        if (optionalUser.isEmpty()) {
            return Result.error("Invalid username " + username);
        }

        User user = optionalUser.get();
        Movie movie = Movie.builder().id(movieId).build();

        if (favoriteRepository.existsByUserAndMovie(user, movie)) {
            return Result.error(String.format("用户%s已经收藏了电影%d", username, movieId));
        }

        favoriteRepository.save(Favorite.builder()
                .user(user)
                .movie(movie)
                .build());

        return Result.success();
    }

    @GetMapping("/detail/{movieId}")
    public Result details(@PathVariable Integer movieId) {
        FavoriteResponseData favoriteResponseData = new FavoriteResponseData();
        favoriteResponseData.setActors(actorRepository.findActorsOfMovie(movieId));
        var optMovie = movieRepository.findById(movieId);
        var optDirector = workerRepository.getDirectorOfMovie(movieId);
        optDirector.ifPresent(favoriteResponseData::setDirector);
        optMovie.ifPresent(favoriteResponseData::setMovie);
        return Result.success(favoriteResponseData);
    }

    @GetMapping("/recommend")
    public Result recommend(@NotNull HttpServletRequest request) {
        String username = request.getHeader("username");
        return Result.success(recommendRepository.findRecommendMovieOfUser(username));
    }

}
