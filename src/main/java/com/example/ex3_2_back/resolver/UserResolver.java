package com.example.ex3_2_back.resolver;

import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver {
    UserRepository userRepository;

    @SuppressWarnings("all")
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
