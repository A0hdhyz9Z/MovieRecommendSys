package com.example.ex3_2_back.initializer;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.Recommendation;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.MovieRepository;
import com.example.ex3_2_back.repository.RecommendationRepository;
import com.example.ex3_2_back.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataSourceInitializer implements CommandLineRunner {

    UserRepository userRepository;

    MovieRepository movieRepository;

    RecommendationRepository recommendationRepository;


    @Value("${data.auto-init:false}")
    boolean enabled = false;

    @Autowired
    public void setRecommendationRepository(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) {
        if (enabled) {
            log.info("开启自动插入数据");
            List<Movie> movies = new ArrayList<>();
            List<User> users = new ArrayList<>();
            List<Recommendation> recommendations = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                var user = User.builder().name(String.valueOf(i)).build();
                users.add(user);
                var recommendation = Recommendation.builder().build();
                var movie1 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie1);
                recommendation.setMovie1(movie1);
                var movie2 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie2);
                recommendation.setMovie1(movie2);
                var movie3 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie3);
                recommendation.setMovie1(movie3);
                var movie4 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie4);
                recommendation.setMovie1(movie4);
                var movie5 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie5);
                recommendation.setMovie1(movie5);
                var movie6 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie6);
                recommendation.setMovie1(movie6);
                var movie7 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie7);
                recommendation.setMovie1(movie7);
                var movie8 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie8);
                recommendation.setMovie1(movie8);
                var movie9 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie9);
                recommendation.setMovie1(movie9);
                var movie10 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie10);
                recommendation.setMovie1(movie10);
                var movie11 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie11);
                recommendation.setMovie1(movie11);
                var movie12 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie12);
                recommendation.setMovie1(movie12);
                var movie13 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie13);
                recommendation.setMovie1(movie13);
                var movie14 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie14);
                recommendation.setMovie1(movie14);
                var movie15 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie15);
                recommendation.setMovie1(movie15);
                var movie16 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie16);
                recommendation.setMovie1(movie16);
                var movie17 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie17);
                recommendation.setMovie1(movie17);
                var movie18 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie18);
                recommendation.setMovie1(movie18);
                var movie19 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie19);
                recommendation.setMovie1(movie19);
                var movie20 = Movie.builder().originalTitle(String.valueOf(i * i)).build();
                movies.add(movie20);
                recommendation.setMovie1(movie20);

                recommendation.setUser(user);
                recommendations.add(recommendation);
            }

            movieRepository.saveAll(movies);
            userRepository.saveAll(users);
            recommendationRepository.saveAll(recommendations);
        } else {
            log.info("关闭自动插入数据");
        }
    }
}
