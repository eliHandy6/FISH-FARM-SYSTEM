package com.example.fishFarm.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

	@Entity
public class DailyPondRecords {
	
	@Id
	private int id;
	private double temprature;
	private double dissolvedOxygen;
	private double ammonia;
	private int pH;
	private double carbonOxide;
	//private double waterLevel;

	//private String date;

	//private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Pond pond;
	
	public DailyPondRecords() {
		super();
	}

	public DailyPondRecords(int id, double temprature, double dissolvedOxygen, double ammonia, int pH,
			int carbonOxide, Pond pond) {
		super();
		this.id = id;
	//ss	this.date = date;
		this.temprature = temprature;
		this.dissolvedOxygen = dissolvedOxygen;
		this.ammonia = ammonia;
		this.pH = pH;
		this.carbonOxide = carbonOxide;
	//	this.waterLevel = waterLevel;
		//this.comment = comment;
		this.pond = pond;
	}

	public int getId() {
		return id;
	}

//	public String getDate() {
//		return date;
//	}

	public double getTemprature() {
		return temprature;
	}

	public double getDissolvedOxygen() {
		return dissolvedOxygen;
	}

	public double getAmmonia() {
		return ammonia;
	}

	public int getpH() {
		return pH;
	}

	public double getCarbonOxide() {
		return carbonOxide;
	}

//	public double getWaterLevel() {
//		return waterLevel;
//	}

//	public String getComment() {
//		return comment;
//	}

	public Pond getPondId() {
		return pond;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public void setDate(String date) {
//		this.date = date;
//	}

	public void setTemprature(double temprature) {
		this.temprature = temprature;
	}

	public void setDissolvedOxygen(double dissolvedOxygen) {
		this.dissolvedOxygen = dissolvedOxygen;
	}

	public void setAmmonia(double ammonia) {
		this.ammonia = ammonia;
	}

	public void setpH(int pH) {
		this.pH = pH;
	}

	public void setCarbonOxide(double carbonOxide) {
		this.carbonOxide = carbonOxide;
	}

//	public void setWaterLevel(double waterLevel) {
//		this.waterLevel = waterLevel;
//	}

//	public void setComment(String comment) {
//		this.comment = comment;
//	}

	public void setPondId(Pond pondId) {
		this.pond = pondId;
	}
	
	
	
	
	
	
	
	

}
