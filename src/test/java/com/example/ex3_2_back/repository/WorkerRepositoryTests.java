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
        var a = workerRepository.getDirectorOfMovie(862);
        if (a.isPresent()) {
            log.info(a.get().toString());
        } else {
            log.info("None");
        }
    }

    @Test
    public void test_setAllDirector() {

    }
}
