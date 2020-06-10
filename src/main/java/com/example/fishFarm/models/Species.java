package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Species {
	@Id
	private int id;
	private String geneName;
	private String speciesName;

	public Species() {
	}

	public Species(int id,String geneName,String speciesName) {

		this.id=id;
		this.geneName=geneName;
		this.speciesName=speciesName;
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
