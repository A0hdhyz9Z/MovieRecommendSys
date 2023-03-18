package com.example.ex3_2_back.utiltest

import com.example.ex3_2_back.entity.User
import com.example.ex3_2_back.util.MySecurity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MySecurityTest {

    @Autowired
    lateinit var mySecurity: MySecurity

    val user = User(id = 999)

    @Test
    fun testExpired() {
        val token = mySecurity.genTestToken(user, 300000)
        assert(mySecurity.decToken(token).isPresent)
    }

    @Test
    fun testUnexpired() {
        val token = mySecurity.genTestToken(user, 1)
        assert(mySecurity.decToken(token).isPresent)
    }
}