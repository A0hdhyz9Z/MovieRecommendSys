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

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private RateRepository rateRepository;

    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    private WorkerRepository workerRepository;

    @Autowired
    public void setWorkerRepository(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    private WorkingRepository workingRepository;

    @Autowired
    public void setWorkingRepository(WorkingRepository workingRepository) {
        this.workingRepository = workingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // users
        List<User> users = new ArrayList<>();
        var user = User.builder().name("user").password("61259cdf-9cb1-4981-b926-35ebe0906c29").build();
        users.add(user);
        users.add(User.builder().name("Test").password("Test").build());
        users.add(User.builder().name("zzq").password("123").build());
        userRepository.saveAll(users);


        List<Worker> workers = new ArrayList<>();
        List<Working> workings = new ArrayList<>();

        List<Movie> movies = new ArrayList<>();

        var movie = Movie.builder().originalTitle("123123123123123123123").build();
        movies.add(movie);

        for (int i = 0; i < 100; i++) {
            movie = Movie.builder()
                    .originalTitle("Movie " + i)
                    .voteAverage(i * 0.01F)
                    .build();
            var worker = Worker.builder().name("zzq").build();

            var working = Working.builder().worker(worker).movie(movie).build();

            workings.add(working);
            workers.add(worker);
            movies.add(movie);
        }

        movieRepository.saveAll(movies);
        workerRepository.saveAll(workers);
        workingRepository.saveAll(workings);

        rateRepository.save(Rate.builder().user(user).movie(movie).build());
    }
}

