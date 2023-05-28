package com.example.ex3_2_back.repositorytest;


import com.example.ex3_2_back.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void nothing() {
        System.out.println("Hello");
    }

    @Test
    void testAll() {
        log.info(Arrays.toString(userRepository.findAll().toArray()));
    }

}