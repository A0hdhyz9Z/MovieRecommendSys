package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ex3_2_back.entity.Movie;

@RestController
@RequestMapping("/cast")
public class CastController {
    private CastRepository castRepository;

    @Autowired
    public void setCastRepository(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    @GetMapping
    public Result getCast() {
        return Result.success(castRepository.findByMovie(Movie.builder().id(862).build()));
    }

}
