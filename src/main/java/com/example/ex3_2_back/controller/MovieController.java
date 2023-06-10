package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.movie.DetailData;
import com.example.ex3_2_back.domain.movie.FilterDomain;
import com.example.ex3_2_back.domain.movie.SearchDomain;
import com.example.ex3_2_back.entity.Favorite;
import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movie")
@Tag(name = "MovieController")
public class MovieController {

    UserRepository userRepository;
    RecommendRepository recommendRepository;

    GenreHubRepository genreHubRepository;

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

    //    @GetMapping("/{id}")
    // /movie/123
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

    @PostMapping("/search")
    @Operation(summary = "查找电影1")
    public TResult<Page<Movie>> search(@RequestBody @NotNull SearchDomain searchDomain, @RequestParam int page, @RequestParam int pageSize) {
        return TResult.success(movieRepository.findByOriginalTitleLike(searchDomain.getMovieName(), PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/search2")
    @Operation(summary = "查找电影2")
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
    public Result filterWithTags(@RequestBody @NotNull FilterDomain filterDomain, @RequestParam int page, @RequestParam int pageSize) {
        return Result.success(movieRepository.findMovieWithTags(filterDomain.getTags(), PageRequest.of(page - 1, pageSize)));
    }

    @PostMapping("/filter/genres")
    public Result filterWithGenre(@RequestBody @NotNull FilterDomain filterDomain, @RequestParam int page, @RequestParam int pageSize) {
        return Result.success(movieRepository.findMovieWithGenres(filterDomain.getGenres(), PageRequest.of(page - 1, pageSize)));
    }

    @GetMapping("/favorite")
    public Result getFavorite(@NotNull HttpServletRequest request) {
        String username = request.getHeader("username");
        return Result.success(favoriteRepository.findFavoriteOfUser(username));
    }

    @PostMapping("/favorite/{movieId}")
    public Result setFavorite( @PathVariable Integer movieId,@Nullable @RequestHeader(name = "username", required = false) String username) {
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
    public Result removeFavorite(@PathVariable Integer movieId, @Nullable @RequestHeader(name = "username", required = false) String username) {

        Optional<User> optionalUser = userRepository.findByName(username);

        if (optionalUser.isEmpty()) {
            return Result.error("Invalid username " + username);
        }

        User user = optionalUser.get();
        Movie movie = Movie.builder().id(movieId).build();

        if (favoriteRepository.existsByUserAndMovie(user, movie)) {
            return Result.error(String.format("用户%s已经收藏了电影%d", username, movieId));
        }

        favoriteRepository.delete(Favorite.builder()
                .user(user)
                .movie(movie)
                .build());

        return Result.success();
    }

    @GetMapping("/detail/{movieId}")
    @Operation(summary = "电影的详细信息")
    public TResult<DetailData> detail(@PathVariable Integer movieId, @Nullable @RequestHeader(name = "username", required = false) String username) {
        DetailData detailData = new DetailData();
        detailData.setActors(actorRepository.findActorsOfMovie(movieId));
        var optMovie = movieRepository.findById(movieId);
        var optDirector = workerRepository.getDirectorOfMovie(movieId);
        optDirector.ifPresent(detailData::setDirector);
        optMovie.ifPresent(detailData::setMovie);
        optMovie.ifPresent(movie -> movieRepository.incrementSeenCount(movie.getId()));
        detailData.setGenreHubs(genreHubRepository.findGenreHubOfMovie(movieId));
        userRepository.findByName(username).ifPresent(user -> {
            detailData.setUser(user);
            optMovie.ifPresent(movie -> detailData.setFavorite(favoriteRepository.existsByUserAndMovie(user, movie)));
        });
        return TResult.success(detailData);
    }

    @GetMapping("/recommend")
    @Parameter(name = "")
    public Result recommend(@Nullable @RequestHeader(name = "username", required = false) String username) {
        return Result.success(recommendRepository.findRecommendMovieOfUser(username));
    }

}
