package com.todo.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    private final String hallo = "hallo, Im working on port 8080";

    @GetMapping(path="/api/greeting", produces="text/plain")
    public String hallo() {

        return hallo;
    }
}