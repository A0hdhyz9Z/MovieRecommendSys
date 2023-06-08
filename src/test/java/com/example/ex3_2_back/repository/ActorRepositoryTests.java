package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ActorRepositoryTests {

    private ActorRepository actorRepository;

    @Autowired
    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Test
    public void test_findAll() {
        log.info(actorRepository.findAll().toString());
    }

    @Test
    public void test() {
        List<Actor> actors = actorRepository.findActorsOfMovie(2);
        log.info(actors.toString());
    }
}
