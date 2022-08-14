package com.springboot.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET HTTP Method
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/hello-world-app")
    public String helloWorldApp(){
        return "Hello World App!";
    }
    

}
