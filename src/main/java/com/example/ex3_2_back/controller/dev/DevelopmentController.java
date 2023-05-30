package com.example.ex3_2_back.controller.dev;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
@Slf4j
public class DevelopmentController {

    @GetMapping
    public String testMessage() {
        return "Hello!";
    }

    @PostMapping
    public Object testResponse(@RequestBody @NotNull Object body) {
        return body;
    }
}
