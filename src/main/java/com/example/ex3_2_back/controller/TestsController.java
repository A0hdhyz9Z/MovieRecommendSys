package com.example.ex3_2_back.controller;

import org.springframework.stereotype.Controller;


@Controller
public class TestsController {

//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    UserRepository userRepository;
//
//    @Autowired
//    public void setMovieRepository(MovieRepository userRepository) {
//        this.movieRepository = userRepository;
//    }
//
//    MovieRepository movieRepository;
//
//    @RequestMapping("/message")
//    @ResponseBody
//    String getGreetingMessage() {
//        return "Hello, this is Spring!";
//    }
//
//    @PostMapping("/addmovie")
//    @ResponseBody
//    Result a(Movie movie) {
//
//        if (movie.getId() < 0) {
//            return new Result(false, "No Id");
//        }
//
//        movieRepository.save(movie);
//
//        return new Result(true, "添加电影成功");
//
//    }
//
//    @GetMapping("/getmovie")
//    @ResponseBody
//    DataResult<Movie> a(Integer movieId) {
//
//        if (movieId == null) {
//            return new DataResult<>(false, "No Id", new Movie());
//        }
//
//        Optional<Movie> byId = movieRepository.findById(movieId);
//
//        if (byId.isEmpty()) {
//            return new DataResult<>(false, "没有这个电影", new Movie());
//        }
//
//        Movie movie = byId.get();
//
//        return new DataResult<>(true, "查询成功", movie);
//
//    }

}
