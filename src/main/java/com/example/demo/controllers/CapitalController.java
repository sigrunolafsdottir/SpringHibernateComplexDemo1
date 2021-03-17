package com.example.demo.controllers;

import com.example.demo.models.Capital;
import com.example.demo.repositories.CapitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController                            // This means that this class is a Controller
@RequestMapping(path = "/capital")
public class CapitalController {

        @Autowired
        private CapitalRepository capitalRepository;

        @GetMapping(path = "/add")
        public String addNewUser(@RequestParam String name) {

            Capital n = new Capital();
            n.setName(name);
            capitalRepository.save(n);
            return name + " is Saved";
        }

        @GetMapping(path="/all")
        public Iterable<Capital> getAllCapitals() {
            return capitalRepository.findAll();
        }



}
