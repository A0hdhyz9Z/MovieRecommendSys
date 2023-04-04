package com.example.ex3_2_back.initializer;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.MovieRepository;
import com.example.ex3_2_back.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataSourceInitializer implements CommandLineRunner {

    EntityManagerFactory entityManagerFactory;

    @SuppressWarnings("all")
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

//    public long getMaxLobSize() {
//        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//        return ((AbstractLobType) sessionFactory.getTypeHelper().basic( Blob.class.getName() )).getLobCreator( lobConfigurationProperties() ).getDefaultLobLength();
//    }

    UserRepository userRepository;

    MovieRepository movieRepository;

    @Value("${data.auto-init:false}")
    boolean enabled = false;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void initializeUsers() {
        for (int i = 0; i < 100; i++) {
            var user = User.builder()
                    .id(i)
                    .name(String.valueOf(i))
                    .password(String.valueOf(i))
                    .build();
            userRepository.save(user);
        }

        userRepository.save(User.builder().name("ZZQ").build());
    }

    void initializeMovies() {
        for (int i = 0; i < 100; i++) {
            var movie = Movie.builder()
                    .id(i)
                    .originalTitle(String.valueOf(i))
                    .voteAverage((float) (i * 100.0))
                    .build();
            movieRepository.save(movie);
        }
    }


    @Override
    public void run(String... args) {
        if (enabled) {
            log.info("开启自动插入数据");
            initializeUsers();
            initializeMovies();
        } else {
            log.info("关闭自动插入数据");
        }
    }
}
