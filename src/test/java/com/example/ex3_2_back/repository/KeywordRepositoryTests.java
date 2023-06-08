package com.example.ex3_2_back.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class KeywordRepositoryTests {
    KeywordRepository keywordRepository;

    @Autowired
    public void setKeywordRepository(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Test
    public void test_findAll() {
        keywordRepository.findAll().forEach(keyword -> log.info(keyword.toString()));
    }
}
