package com.example.demo;

import com.example.demo.models.Capital;
import com.example.demo.models.Child;
import com.example.demo.models.Country;
import com.example.demo.models.Present;
import com.example.demo.repositories.CapitalRepository;
import com.example.demo.repositories.ChildRepository;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.PresentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

/*
    //Fyller databasen före start med en huvudstad och ett land
    @Bean   //Denna metod kommer bara att köras om den har en @Bean-annotering
    public CommandLineRunner demo(CountryRepository countryRepo) {
        return (args) -> {
            Capital lissabon = new Capital("Lissabon");
            Country portugal = new Country ("Portugal", lissabon);
            countryRepo.save(portugal);
        };

    }



    //Fyller databasen före start med en huvudstad och ett land
    @Bean   //Denna metod kommer bara att köras om den har en @Bean-annotering
    public CommandLineRunner demo(ChildRepository childRepo) {
        return (args) -> {
            Capital madrid = new Capital("Madrid");
            Country spain = new Country ("Spain", madrid);
            Present pen = new Present("Pen");
            Present eraser = new Present("Eraser");
            Child rubrick = new Child("Rubrick", spain, Arrays.asList(pen, eraser));

            childRepo.save(rubrick);
        };

    }


*/






}
