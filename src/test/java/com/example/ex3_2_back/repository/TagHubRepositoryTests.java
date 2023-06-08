package com.example.ex3_2_back.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TagHubRepositoryTests {
    TagHubRepository tagHubRepository;

    @Autowired
    public void setTagHubRepository(TagHubRepository tagHubRepository) {
        this.tagHubRepository = tagHubRepository;
    }

    @Test
    public void test_findAll() {
        tagHubRepository.findAll().forEach(tagHub -> log.info(tagHub.toString()));
    }
}
