package com.example.ex3_2_back.resolver;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.MovieRepository;
import com.example.ex3_2_back.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver {
    UserRepository userRepository;

    MovieRepository movieRepository;


    public User getUserById(Integer id) {
        var optUser = userRepository.findById(id);
        return optUser.orElseGet(User::new);
    }

    public Movie getMovieById(Integer id) {
        var optMovie = movieRepository.findById(id);
        return optMovie.orElseGet(Movie::new);
    }



    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
