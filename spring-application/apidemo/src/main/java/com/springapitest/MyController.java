package com.springapitest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private List<String> users = List.of(
        "Prasunamba",
        "Meher",
        "Kom"
    );

    @GetMapping("/usersApi")
    public List<String> getUsers() {
        // returns JSON response
        return users;
    }

    @GetMapping("/hello")
    public String print(){
        return "Hello";
    }
}