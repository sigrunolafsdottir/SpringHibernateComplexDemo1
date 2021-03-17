package com.example.demo.controllers;

import com.example.demo.models.Capital;
import com.example.demo.models.Country;
import com.example.demo.repositories.CapitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/capital")
public class CapitalController {

    private static final Logger log = LoggerFactory.getLogger(CapitalController.class);

        @Autowired
        private CapitalRepository capitalRepository;

        @GetMapping(path = "/add")
        public String addNewUser(@RequestParam String name) {

            log.info("A new Capital was added by name "+name);

            Capital n = new Capital();
            n.setName(name);
            capitalRepository.save(n);
            return name + " is Saved";
        }

        @GetMapping(path="/all")
        public Iterable<Capital> getAllCapitals() {

            log.info("All capitals displayed" );

            return capitalRepository.findAll();
        }

    @GetMapping(path="/getById")
    public Capital getCapById(@RequestParam Long id) {
        return capitalRepository.findById(id).get();
    }



}
