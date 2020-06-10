package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemUser extends Person {

    @Id
    private int id;
    private String username;
    private String section;
    private  boolean status;


    public SystemUser() {

    }

    public SystemUser(int id,String fname, String lname, String email, String username, String section, boolean status) {
        super(fname, lname, email);
        this.username = username;
        this.section = section;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
