package com.example.ex3_2_back.initializer;

import com.example.ex3_2_back.entity.*;
import com.example.ex3_2_back.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库初始化
 */
@Component
public class DataSourceInitializer implements CommandLineRunner {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    RateRepository rateRepository;

    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    WorkerRepository workerRepository;

    @Autowired
    public void setWorkerRepository(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    WorkingRepository workingRepository;

    @Autowired
    public void setWorkingRepository(WorkingRepository workingRepository) {
        this.workingRepository = workingRepository;
    }

    ActorRepository actorRepository;

    @Autowired
    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    CastRepository castRepository;

    @Autowired
    public void setCastRepository(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    @Override
    public void run(String... args) throws Exception {


//
//        List<User> users = new ArrayList<>();
//        var user = User.builder().name("user").password("61259cdf-9cb1-4981-b926-35ebe0906c29").build();
//        users.add(user);
//        users.add(User.builder().name("Test").password("Test").build());
//        users.add(User.builder().name("zzq").password("123").build());
//        userRepository.saveAll(users);
//
//
//        List<Worker> workers = new ArrayList<>();
//        List<Working> workings = new ArrayList<>();
//        List<Actor> actors = new ArrayList<>();
//        List<Cast> casts = new ArrayList<>();
//        List<Movie> movies = new ArrayList<>();
//        Movie movie = null;
//        for (int i = 0; i < 100; i++) {
//            movie = Movie.builder()
//                    .originalTitle("Movie " + i)
//                    .voteAverage(i * 0.01F)
//                    .build();
//            var worker = Worker.builder().name("zzq").position("director").build();
//
//            var working = Working.builder().worker(worker).movie(movie).build();
//
//            workings.add(working);
//            workers.add(worker);
//            movies.add(movie);
//
//            for (int j = 0; j < 10; j++) {
//                var actor = Actor.builder()
//                        .name(String.format("Actor(%d,%d)", i, j))
//                        .build();
//                actors.add(actor);
//                casts.add(Cast.builder()
//                        .movie(movie)
//                        .actor(actor)
//                        .build());
//            }
//        }
//
//        movieRepository.saveAll(movies);
//        workerRepository.saveAll(workers);
//        workingRepository.saveAll(workings);
//        actorRepository.saveAll(actors);
//        castRepository.saveAll(casts);
//
//        rateRepository.save(Rate.builder().user(user).movie(movie).build());

    }
}

