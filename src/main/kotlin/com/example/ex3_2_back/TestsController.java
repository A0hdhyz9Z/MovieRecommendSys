package com.example.ex3_2_back;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tests")
public class TestsController {
    @GetMapping({"/", "message"})
    String getGreetingMessage() {
        return "Hello, this is Spring!";
    }
}
