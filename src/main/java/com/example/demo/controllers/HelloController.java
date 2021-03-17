package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//only for demoing testing

@RestController
@RequestMapping(path = "/")
public class HelloController {

    @GetMapping(path="/")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping(path="/es")
    public String HolaMundo() {
        return "Hola Mundo!";
    }

}
