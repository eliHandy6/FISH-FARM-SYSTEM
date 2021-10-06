package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FarmSection {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String sectionName;


    public FarmSection() {
        super();
    }

    public FarmSection(int id ,String sectionName) {
        super();
        this.id=id;
        this.sectionName=sectionName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
