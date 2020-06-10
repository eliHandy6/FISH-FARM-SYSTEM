package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class SeedStock {

    @Id
    private  int number;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Pond pond;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private VarietyStock varietyStock;

    private int quantity;
    private int available;


//    private String date;

    public SeedStock() {
    }

    public SeedStock(int number,Pond pond,int quantity,int available_quantity){
        this.number=number;
        this.pond=pond;
        this.quantity=quantity;
        this.available=available_quantity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Pond getPond() {
        return pond;
    }

    public void setPond(Pond pond) {
        this.pond = pond;
    }

    public VarietyStock getVarietyStock() {
        return varietyStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailable_quantity() {
        return available;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available = available_quantity;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
}
