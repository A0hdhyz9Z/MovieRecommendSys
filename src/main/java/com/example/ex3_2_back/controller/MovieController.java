package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.movie.DetailData;
import com.example.ex3_2_back.domain.movie.FilterDomain;
import com.example.ex3_2_back.domain.movie.SearchDomain;
import com.example.ex3_2_back.entity.Favorite;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@Tag(name = "MovieController")
public class MovieController {

    UserRepository userRepository;
    RecommendRepository recommendRepository;

    GenreHubRepository genreHubRepository;

    RateRepository rateRepository;

    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Autowired
    public void setGenreHubRepository(GenreHubRepository genreHubRepository) {
        this.genreHubRepository = genreHubRepository;
    }

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

    @GetMapping
    public TResult<Page<Movie>> getMovie(@RequestParam int page, @RequestParam int pageSize) {
        return TResult.success(movieRepository.findByOrderByVoteAverageDesc(PageRequest.of(page - 1, pageSize)));
    }

    @GetMapping("/one/{id}")
    public TResult<Optional<Movie>> one(@PathVariable Integer id) {
        return TResult.success(movieRepository.findById(id));
    }

    @PostMapping
    public Result create(@RequestBody Movie movie) {
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success();
    }

    @Deprecated
    @PostMapping("/search")
    @Operation(summary = "查找电影1")
    public TResult<Page<Movie>> search(@RequestBody @NotNull SearchDomain searchDomain, @RequestParam int page, @RequestParam int pageSize) {
        return TResult.success(movieRepository.findByOriginalTitleLike(searchDomain.getMovieName(), PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/search2")
    @Operation(summary = "查找电影2", description = "search2")
    public TResult<Page<Movie>> search2(@RequestBody @NotNull SearchDomain searchDomain, @RequestParam int page, @RequestParam int pageSize) {
        return TResult.success(movieRepository.findAll(new Example<Movie>() {
            @NotNull
            @Override
            public Movie getProbe() {
                return Movie.builder().originalTitle(searchDomain.getMovieName()).build();
            }

            @NotNull
            @Override
            public ExampleMatcher getMatcher() {
                return ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
            }
        }, PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/filter/tags")
    @Operation(summary = "filterWithTags", description = "filterWithTags")
    public Result filterWithTags(
            @RequestBody @NotNull @Validated FilterDomain filterDomain,
            @Schema(defaultValue = "1") @RequestParam int page,
            @Schema(defaultValue = "10") @RequestParam int pageSize
    ) {

        return Result.success(movieRepository.findMovieWithTags(filterDomain.getTags(), PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/filter/genres")
    public Result filterWithGenre(
            @RequestBody @NotNull @Validated FilterDomain filterDomain,
            @Schema(defaultValue = "1") @RequestParam int page,
            @Schema(defaultValue = "10") @RequestParam int pageSize) {
        return Result.success(movieRepository.findMovieWithGenres(filterDomain.getGenres(), PageRequest.of(page - 1, pageSize)));
    }

    @GetMapping("/favorite")
    public TResult<List<Movie>> getFavorite(
            @Schema(defaultValue = "15") @Nullable @RequestHeader("username") String username
    ) {

        return TResult.success(favoriteRepository.findFavoriteOfUser(username));
    }

    @GetMapping("/favorite/pageable")
    public TResult<Page<Movie>> getFavoritePageable(
            @Nullable @RequestHeader("username") String username,
            @Schema(defaultValue = "1") @RequestParam int page,
            @Schema(defaultValue = "10") @RequestParam int pageSize
    ) {
        return TResult.success(favoriteRepository.findFavoriteOfUser(username, PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/favorite/{movieId}")
    public Result setFavorite(
            @Schema(defaultValue = "862") @PathVariable Integer movieId,
            @Schema(defaultValue = "15") @Nullable @RequestHeader("username") String username
    ) {

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

    @DeleteMapping("/favorite/{movieId}")
    public Result removeFavorite(
            @Schema(defaultValue = "862") @PathVariable Integer movieId,
            @Schema(defaultValue = "15") @Nullable @RequestHeader("username") String username
    ) {

        Optional<User> optionalUser = userRepository.findByName(username);
        if (optionalUser.isEmpty()) {
            return Result.error("No such user");
        }
        User user = optionalUser.get();

        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            return Result.error("No such movie " + movieId);
        }
        Movie movie = optionalMovie.get();

        if (!favoriteRepository.existsByUserAndMovie(user, movie)) {
            return Result.error("User " + username + " does not favor movie " + movieId);
        }

        favoriteRepository.deleteByUserAndMovie(user, movie);

        return Result.success();
    }

    @GetMapping("/detail/{movieId}")
    @Operation(summary = "电影的详细信息")
    public TResult<DetailData> detail(
            @Schema(defaultValue = "862") @PathVariable Integer movieId,
            @Schema(defaultValue = "15") @Nullable @RequestHeader(name = "username", required = false) String username
    ) {

        DetailData detailData = new DetailData();

        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            return TResult.error("No such movie " + movieId);
        }
        Movie movie = optionalMovie.get();
        movieRepository.incrementSeenCount(movie.getId());
        detailData.setMovie(movie);

        detailData.setActors(actorRepository.findActorsOfMovie(movieId));


        detailData.setGenreHubs(genreHubRepository.findGenreHubOfMovie(movieId));

        Optional<User> optionalUser = userRepository.findByName(username);
        if (optionalUser.isEmpty()) {
            return TResult.success(detailData);
        }
        User user = optionalUser.get();
        detailData.setUser(user);

        detailData.setFavorite(favoriteRepository.existsByUserAndMovie(user, movie));

        workerRepository.getDirectorOfMovie(movie.getId()).ifPresent(detailData::setDirector);

        Optional<Rate> optionalRate = rateRepository.findByUserAndMovie(user, movie);
        if (optionalRate.isPresent()) {
            Rate rate = optionalRate.get();
            detailData.setRating(rate.getRating());
        }

        return TResult.success(detailData);
    }

    @GetMapping("/recommend")
    public TResult<Page<Movie>> recommend(
            @Schema(defaultValue = "862") @Nullable @RequestHeader("username") String username,
            @Schema(defaultValue = "1") @RequestParam int page,
            @Schema(defaultValue = "10") @RequestParam int pageSize
    ) {
        return TResult.success(recommendRepository.findRecommendMovieOfUser(username, PageRequest.of(page - 1, pageSize)));
    }

}
