package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class VarietyStock {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private  Species species;
    private int number;
    //private double Price;
    private  String createdAt;
    private  String updatedAt;


    public VarietyStock(){

    }

    public VarietyStock(int id, Species species, int number,String createdAt,String updatedAt) {
        this.id = id;
        this.species = species;
        this.number = number;

        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
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

//    public Double getPrice() {
//        return Price;
//    }
//
//    public void setPrice(Double price) {
//        Price = price;
//    }
//
//    public void setPrice(double price) {
//        Price = price;
//    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
