package com.example.ex3_2_back.repositry;

import com.example.ex3_2_back.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Int> {
    fun findByIdAndName(id: Int, name: String): Optional<User>
}