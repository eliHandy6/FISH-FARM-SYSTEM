package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class Harvest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private SeedStock seedStock;

        private int number;
        private double size;
        private String description;
        private boolean status;
    private String createdAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeedStock getSeedStock() {
        return seedStock;
    }

    public void setSeedStock(SeedStock seedStock) {
        this.seedStock = seedStock;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
