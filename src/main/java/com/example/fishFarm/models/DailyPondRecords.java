package com.example.fishFarm.models;

import javax.persistence.*;

@Entity
public class DailyPondRecords {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private double temprature;
	private double nitrogen;
	private double ammonia;
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Pond pond;

	private String createdAt;

	private boolean status;

		@Override
		public String toString() {
			return "DailyPondRecords{" +
					"id=" + id +
					", temprature=" + temprature +
					", nitrogen=" + nitrogen +
					", ammonia=" + ammonia +
					", pond=" + pond +
					", createdAt='" + createdAt + '\'' +
					", status=" + status +
					'}';
		}

		public DailyPondRecords() {
		super();
	}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public double getAmmonia() {
			return ammonia;
		}

		public void setAmmonia(double ammonia) {
			this.ammonia = ammonia;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getTemprature() {
			return temprature;
		}

		public void setTemprature(double temprature) {
			this.temprature = temprature;
		}

		public double getNitrogen() {
			return nitrogen;
		}

		public void setNitrogen(double nitrogen) {
			this.nitrogen = nitrogen;
		}

		public Pond getPond() {
			return pond;
		}

		public void setPond(Pond pond) {
			this.pond = pond;
		}
	}
