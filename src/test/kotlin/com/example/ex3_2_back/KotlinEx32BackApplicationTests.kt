package com.example.ex3_2_back

import com.example.ex3_2_back.entity.User
import com.example.ex3_2_back.repositry.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class KotlinEx32BackApplicationTests {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun contextLoads() {
        userRepository.save(User(id = 1))
    }

    @Test
    fun s() {
        println("Hello")
    }

}
