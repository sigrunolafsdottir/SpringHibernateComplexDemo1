package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "capitalId", referencedColumnName = "id")
    private Capital capital;         //bara för att ha en 1-1-relation att dema

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

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }


}
