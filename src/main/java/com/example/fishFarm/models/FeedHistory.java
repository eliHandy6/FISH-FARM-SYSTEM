package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class FeedHistory {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Feed feed;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Pond pond;
	private double Quanity;

	private double fishWeight;

	private  String createdAt;

	private boolean status ;


	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FeedHistory() {
		super();
	}


	public double getFishWeight() {
		return fishWeight;
	}

	public void setFishWeight(double fishWeight) {
		this.fishWeight = fishWeight;
	}

	public int getId() {
		return id;
	}
	public Feed getFeed() {
		return feed;
	}
	public Pond getPond() {
		return pond;
	}
	public double getQuanity() {
		return Quanity;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	public void setPond(Pond pond) {
		this.pond = pond;
	}
	public void setQuanity(double quanity) {
		Quanity = quanity;
	}


	
	
}
