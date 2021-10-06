package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Feed {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String feedName;
	private double feedQuality;
//	private double unitPrice;
	private  String createdAt;
	private  String updatedAt;
	
	
	
	public Feed() {
		super();
	}



	public Feed(int id, String feedName, double feedQuality,String createdAt,String updatedAt) {
		super();
		this.id = id;
		this.feedName = feedName;
		this.feedQuality = feedQuality;
//		this.unitPrice = unitPrice;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}



	public int getId() {
		return id;
	}



	public String getFeedName() {
		return feedName;
	}



	public double getFeedQuality() {
		return feedQuality;
	}



//	public double getUnitPrice() {
//		return unitPrice;
//	}



	public void setId(int id) {
		this.id = id;
	}



	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}



	public void setFeedQuality(double feedQuality) {
		this.feedQuality = feedQuality;
	}


//
//	public void setUnitPrice(double unitPrice) {
//		this.unitPrice = unitPrice;
//	}


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
}
