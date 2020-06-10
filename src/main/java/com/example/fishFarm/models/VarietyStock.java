package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class VarietyStock {
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private  Species species;
    private int number;
    private double Price;

    public VarietyStock(){

    }

    public VarietyStock(int id, Species species, int number, Double price) {
        this.id = id;
        this.species = species;
        this.number = number;
        Price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
