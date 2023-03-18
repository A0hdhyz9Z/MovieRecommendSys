package com.example.ex3_2_back.util


import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.ex3_2_back.entity.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class MySecurity {

    companion object

    val algorithm = Algorithm.HMAC256("movie")

    fun genToken(user: User): String {

        val calendar = Calendar.getInstance()
        val currentTime = calendar.time
        calendar.add(Calendar.HOUR, 1) // 设置1小时后过期
        val expirationTime = calendar.time

        return JWT.create()
            .withSubject("authentication")
            .withIssuer("your_issuer")
            .withClaim("id", user.id)
            .withIssuedAt(currentTime)
            .withExpiresAt(expirationTime)
            .sign(algorithm)
    }

    fun genTestToken(user: User, millis: Int): String {

        val calendar = Calendar.getInstance()
        val currentTime = calendar.time
        calendar.add(Calendar.MILLISECOND, millis) // 设置1小时后过期
        val expirationTime = calendar.time

        return JWT.create()
            .withSubject("authentication")
            .withIssuer("your_issuer")
            .withClaim("id", user.id)
            .withIssuedAt(currentTime)
            .withExpiresAt(expirationTime)
            .sign(algorithm)
    }

    fun decToken(token: String): Optional<User> {
        try {
            val verifier = JWT.require(algorithm).build()
            val jwt = verifier.verify(token)
            val id = jwt.getClaim("id").asInt()
            return Optional.of(User(id))
        } catch (e: Exception) {
            return Optional.empty()
        }
    }
}