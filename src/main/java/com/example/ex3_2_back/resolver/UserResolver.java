package com.example.ex3_2_back.resolver;

import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repositry.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver {
    private UserRepository userRepository;

    @SuppressWarnings("all")
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
