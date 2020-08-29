package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PondType {
	
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String createdAt;
	private String updatedAt;
	
	
	
	public PondType() {
		super();
	}



	public PondType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public int getId() {
		return id;
	}




	public String getName() {
		return name;
	}




	public void setId(int id) {
		this.id = id;
	}




	public void setName(String name) {
		this.name = name;
	}



}
