package com.shelton.example;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/post")
    public String post(
            String message
    ) {
        return "Request accepted and message is:" + message;
    }
}
