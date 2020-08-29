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

     @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
     @JoinColumn(nullable = false)
    private FarmSection section;



    public SystemUser() {

    }

    public  SystemUser(int id,String fname,String lname,String username,String password,String email,FarmSection section){
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.username=username;
        this.password=password;
        this.email=email;
        this.section=section;

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
