package com.example.ex3_2_back.utiltest

import com.example.ex3_2_back.entity.User
import com.example.ex3_2_back.util.MySecurity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.Thread.sleep

@SpringBootTest
class SecurityTest {
    @Autowired
    lateinit var mySecurity: MySecurity

    val srcUser=User(id=999)

    @Test
    fun testGenToken() {
        println("GenToken")
        println(mySecurity.genToken(srcUser))
    }

    @Test
    fun testDecToken() {
        println("DecToken")
        val token = mySecurity.genToken(srcUser)
        sleep(2000)
        println(mySecurity.decToken(token))
    }
}