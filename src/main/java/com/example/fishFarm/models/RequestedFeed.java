package com.example.fishFarm.models;

import javax.persistence.*;

@Entity

public class RequestedFeed {
    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Pond pondId;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Feed feedId;

    private double quantity;


    public RequestedFeed() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pond getPondId() {
        return pondId;
    }

    public void setPondId(Pond pondId) {
        this.pondId = pondId;
    }

    public Feed getFeedId() {
        return feedId;
    }

    public void setFeedId(Feed feedId) {
        this.feedId = feedId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
