package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private int idNo;
	private String fname;
	private String lname;
	private String email;
	private String phoneno;
//	private String date;


	public Owner() {
	}

	  public  Owner (int id, int id_no, String fname,String lname,String email,String phoneno){
		id=id;
		idNo=id_no;
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.phoneno=phoneno;
	  }

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//}
