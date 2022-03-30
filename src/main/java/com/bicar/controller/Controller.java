package com.bicar.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller{


	
	@GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
	
	@GetMapping
    public String helloWorld() {
        return "you don't need to be logged in";
    }

    @GetMapping("/notrestricted")
    public String notRestricted() {
        return "you don't need to be logged in";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }
    
   
    
}

