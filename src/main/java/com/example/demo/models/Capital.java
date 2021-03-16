package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Capital {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String name;

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
/*
    @OneToOne(mappedBy = "capital", optional = false)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

 */
}
