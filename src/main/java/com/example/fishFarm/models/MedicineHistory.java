package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class MedicineHistory {

    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Pond pond;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Medicine medicine;

    private double quantity;

    private String description;

    private boolean status;

    private  String createdAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pond getPond() {
        return pond;
    }

    public void setPond(Pond pond) {
        this.pond = pond;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
