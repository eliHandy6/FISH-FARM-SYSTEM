package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicine {

    @Id
    private int number;
    private String medicineName;
    private double medicineQuantity;
    private double medicinePrice;

    public Medicine() {
        super();
    }

    public Medicine(int number,String medicineName,double medicineQuantity,double medicinePrice) {
        super();
        this.number=number;
        this.medicineName=medicineName;
        this.medicineQuantity=medicineQuantity;
        this.medicinePrice=medicinePrice;
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

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
}
