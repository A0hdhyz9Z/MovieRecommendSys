package com.example.ex3_2_back.repositry;

import com.example.ex3_2_back.entity.Actor
import org.springframework.data.jpa.repository.JpaRepository

interface ActorRepository : JpaRepository<Actor, Int> {
}