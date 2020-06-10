package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class Pond {
	
	@Id
	private int id;
	private int pondNumber;

	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private PondType pondType;
	private double  pondArea;
	private double  avarageDepth;
	//private String date;
	//private Boolean Status;
	
	
	public Pond() {
		super();
	}

	public Pond (int id,int pondnumber,PondType pondtype,int pondArea,int avarageDepth){
		this.id=id;
		this.pondNumber=pondnumber;
		this.pondType=pondtype;
		this.pondArea=pondArea;
		this.avarageDepth=avarageDepth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPondNumber() {
		return pondNumber;
	}


	public void setPondNumber(int pondNumber) {
		this.pondNumber = pondNumber;
	}

	public PondType getPondType() {
		return pondType;
	}


	public void setPondType(PondType pondType) {
		this.pondType = pondType;
	}

	public double getPondArea() {
		return pondArea;
	}

	public void setPondArea(double pondArea) {
		this.pondArea = pondArea;
	}

	public double getAvarageDepth() {
		return avarageDepth;
	}

	public void setAvarageDepth(double avarageDepth) {
		this.avarageDepth = avarageDepth;
	}
}
