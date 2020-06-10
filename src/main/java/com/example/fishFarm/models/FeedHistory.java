package com.example.fishFarm.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FeedHistory {
	@Id
	
	private int id;
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "Feed")
	private Feed feed;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "pondNumber")
	private Pond pond;
	private double Quanity;
	private String date;
	
	
	public FeedHistory() {
		super();
	}
	public FeedHistory(int id, Feed feed, Pond pond, double quanity, String date) {
		super();
		this.id = id;
		this.feed = feed;
		this.pond = pond;
		Quanity = quanity;
		this.date = date;
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
	public String getDate() {
		return date;
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
	public void setDate(String date) {
		this.date = date;
	}

	
	
}
