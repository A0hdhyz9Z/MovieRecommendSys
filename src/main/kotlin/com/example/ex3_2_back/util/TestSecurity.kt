package com.example.ex3_2_back.util


import com.example.ex3_2_back.entity.User
import org.springframework.stereotype.Component

@Component
class TestSecurity {

    fun genToken(user: User): String {
        return "TestToken"
    }


    fun decToken(token: String): User {
        return User()
    }

}