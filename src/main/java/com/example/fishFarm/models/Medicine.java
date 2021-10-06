package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int number;
    private String medicineName;
    private double medicineQuantity;
    private String  medicineUnit;
    private String createdAt;

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

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    private String updatedAt;

    public Medicine() {
        super();
    }

    public Medicine(int number,String medicineName,double medicineQuantity,String medicineUnit,String createdAt,String updatedAt) {
        super();
        this.number=number;
        this.medicineName=medicineName;
        this.medicineQuantity=medicineQuantity;
        this.medicineUnit=medicineUnit;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(double medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }


}
