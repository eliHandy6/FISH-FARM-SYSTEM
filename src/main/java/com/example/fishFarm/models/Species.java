package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Species {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String geneName;
	private String speciesName;

	private String createdAt;
	private String updatedAt;

	public Species() {
	}

	public Species(int id ,String name,String geneName,String speciesName,String createdAt,String updatedAt) {

		this.id=id;
		this.name=name;
		this.geneName=geneName;
		this.speciesName=speciesName;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	public void setId(int id) {
		this.id = id;
	}

	public String getGeneName() {
		return geneName;
	}

	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName)
	{
		this.speciesName = speciesName;
	}
}
