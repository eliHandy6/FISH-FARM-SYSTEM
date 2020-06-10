package com.example.fishFarm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class Feed {
	@Id
	private int id;
	private String feedName;
	private double feedQuality;
	private double unitPrice;
	
	
	
	public Feed() {
		super();
	}



	public Feed(int id, String feedName, double feedQuality, double unitPrice) {
		super();
		this.id = id;
		this.feedName = feedName;
		this.feedQuality = feedQuality;
		this.unitPrice = unitPrice;
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



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}



	public void setFeedQuality(double feedQuality) {
		this.feedQuality = feedQuality;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	
	
	
	
	

}
