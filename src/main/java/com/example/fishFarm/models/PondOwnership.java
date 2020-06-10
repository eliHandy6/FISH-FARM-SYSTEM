package com.example.fishFarm.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PondOwnership {
	
	@Id
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn()
	private Pond pond;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn()
	private Owner owner;
	private String date;
	
	
	
	
	public PondOwnership() {
		super();
	}


	public PondOwnership(int id,Pond pond, Owner owner, String date) {
		super();
		this.id=id;
		this.pond = pond;
		this.owner = owner;
		this.date = date;
	}
	
	
	public Pond getPondId() {
		return pond;
	}
	public Owner getOwner() {
		return owner;
	}
	public String getDate() {
		return date;
	}
	public void setPond(Pond pond) {
		this.pond = pond;
	}
	public void setOwnerid(Owner owner) {
		this.owner = owner;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	


}
