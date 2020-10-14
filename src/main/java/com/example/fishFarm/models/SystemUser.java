package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class SystemUser  {

    @Id
    private int id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String email;
    private String phoneNo;
    private String createdAt;
    private String updatedAt;

     @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
     @JoinColumn(nullable = false)
    private FarmSection section;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public SystemUser() {

    }

    public  SystemUser(int id,String fname,String lname,String username,String password,String email,FarmSection section,String createdAt,String updatedAt,String phoneno){
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.username=username;
        this.password=password;
        this.email=email;
        this.section=section;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.phoneNo=phoneno;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FarmSection getSection() {
        return section;
    }

    public void setSection(FarmSection section) {
        this.section = section;
    }
}
