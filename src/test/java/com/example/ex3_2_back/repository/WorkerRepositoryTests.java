package com.example.ex3_2_back.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class WorkerRepositoryTests {

    WorkerRepository workerRepository;

    @Autowired
    public void setWorkerRepository(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Test
    public void test_getDirectorOfMovie() {
        var a = workerRepository.getDirectorOfMovie(1);
        a.ifPresent(worker -> log.info(worker.toString()));
    }

    @Test
    public void test_setAllDirector() {

    }
}
