package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class Pond {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private int pondNumber;

	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private PondType pondType;
	private double  pondArea;
	private double  avarageDepth;
	private String pondStockingType;
	private boolean stockingStatus;
	private boolean feedingStatus;
	private boolean paramStatus;
	private boolean medicationStatus;

	private String createdAt;
	private String updatedAt;

	public boolean isMedicationStatus() {
		return medicationStatus;
	}

	public void setMedicationStatus(boolean medicationStatus) {
		this.medicationStatus = medicationStatus;
	}

	public boolean isFeedingStatus() {
		return feedingStatus;
	}

	public void setFeedingStatus(boolean feedingStatus) {
		this.feedingStatus = feedingStatus;
	}

	public boolean isParamStatus() {
		return paramStatus;
	}

	public void setParamStatus(boolean paramStatus) {
		this.paramStatus = paramStatus;
	}

	public Pond() {
		super();
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

	public String getPondStockingType() {
		return pondStockingType;
	}

	public void setPondStockingType(String pondStockingType) {
		this.pondStockingType = pondStockingType;
	}

	public boolean isStockingStatus() {
		return stockingStatus;
	}

	public void setStockingStatus(boolean stockingStatus) {
		this.stockingStatus = stockingStatus;
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
