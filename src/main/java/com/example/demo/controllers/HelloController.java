package com.example.demo.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//only for demoing testing

@Controller
@RequestMapping(path = "/")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(path="/")
    public String HelloWorld() {
        //log.info("SomeOne looked at our web site!!!");
        //return "Hello World!";
        return "index.html";
    }

    @GetMapping(path="/es")
    public @ResponseBody
    String HolaMundo() {
        return "Hola Mundo!";
    }

}
