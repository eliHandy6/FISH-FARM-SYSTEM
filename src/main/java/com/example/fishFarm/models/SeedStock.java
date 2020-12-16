package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class SeedStock {

    @Id
    private int number;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Pond pond;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private VarietyStock variety;


    private int stockingDensity;


    private String stockingRatio;


    private boolean status;


    private  String createdAt;
    private  String updatedAt;



    public int getStockingDensity() {
        return stockingDensity;
    }

    public void setStockingDensity(int stockingDensity) {
        this.stockingDensity = stockingDensity;
    }


    public String getStockingRatio() {
        return stockingRatio;
    }

    public void setStockingRatio(String stockingRatio) {
        this.stockingRatio = stockingRatio;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    public SeedStock() {
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

    public VarietyStock getVariety() {
        return variety;
    }

    public void setVariety(VarietyStock variety) {
        this.variety = variety;
    }


}


