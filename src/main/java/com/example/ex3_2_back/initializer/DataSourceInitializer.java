package com.example.ex3_2_back.initializer;

import com.example.ex3_2_back.entity.*;
import com.example.ex3_2_back.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    RecommendRepository recommendRepository;

    @Autowired
    public void setRecommendRepository(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    KeywordRepository keywordRepository;

    @Autowired
    public void setKeywordRepository(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    TagHubRepository tagHubRepository;

    @Autowired
    public void setTagHubRepository(TagHubRepository tagHubRepository) {
        this.tagHubRepository = tagHubRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        final String[] tagStrings = new String[]{
                "Sci-Fi",
                "Musical",
                "Action",
                "War"
        };

        TagHub[] tagHubs = Arrays.stream(tagStrings).map(tag -> TagHub.builder().name(tag).build()).toArray(TagHub[]::new);

        List<Keyword> keywords = new ArrayList<>();

        List<User> users = new ArrayList<>();
        var user = User.builder().name("user").password("61259cdf-9cb1-4981-b926-35ebe0906c29").build();
        users.add(user);
        users.add(User.builder().name("Test").password("Test").build());
        users.add(User.builder().name("zzq").password("123").build());

        userRepository.saveAll(users);


        List<Recommend> recommends = new ArrayList<>();

        List<Worker> workers = new ArrayList<>();
        List<Working> workings = new ArrayList<>();
        List<Actor> actors = new ArrayList<>();
        List<Cast> casts = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        Movie movie = null;
        for (int i = 0; i < 100; i++) {
            movie = Movie.builder()
                    .originalTitle("Movie " + i)
                    .voteAverage(i * 0.01F)
                    .build();
            var worker = Worker.builder().name("zzq").position("director").build();

            var working = Working.builder().worker(worker).movie(movie).build();

            workings.add(working);
            workers.add(worker);
            movies.add(movie);

            keywords.add(Keyword.builder().tagHub(tagHubs[i % tagHubs.length]).movie(movie).build());

            for (int j = 0; j < 10; j++) {
                var actor = Actor.builder()
                        .name(String.format("Actor(%d,%d)", i, j))
                        .build();
                actors.add(actor);
                casts.add(Cast.builder()
                        .movie(movie)
                        .actor(actor)
                        .build());
            }
        }

        for (User u : users) {
            for (Movie m : movies) {
                recommends.add(Recommend.builder()
                        .movie(m)
                        .user(u)
                        .score(0.3F)
                        .build());
            }
        }

        movieRepository.saveAll(movies);
        workerRepository.saveAll(workers);
        tagHubRepository.saveAll(Arrays.stream(tagHubs).toList());
        actorRepository.saveAll(actors);


        keywordRepository.saveAll(keywords);
        castRepository.saveAll(casts);
        workingRepository.saveAll(workings);
        recommendRepository.saveAll(recommends);

    }
}

