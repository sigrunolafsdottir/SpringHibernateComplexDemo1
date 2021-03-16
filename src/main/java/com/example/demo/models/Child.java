package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


public class Child {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private Country country;
    private List<Present> wishes;
    private List<Present> gifts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Present> getWishes() {
        return wishes;
    }

    public void setWishes(List<Present> wishes) {
        this.wishes = wishes;
    }

    public List<Present> getGifts() {
        return gifts;
    }

    public void setGifts(List<Present> gifts) {
        this.gifts = gifts;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
