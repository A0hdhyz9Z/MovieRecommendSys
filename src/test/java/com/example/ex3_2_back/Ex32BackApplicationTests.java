package com.example.ex3_2_back;

import com.example.ex3_2_back.repositry.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;



@SpringBootTest
public class Ex32BackApplicationTests {

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    @Test
    void nothing() {
        System.out.println("Hello");
    }
}
