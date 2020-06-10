package com.example.fishFarm.models;

//@Entity
public class DiseaseAttack {

	
//	@Id
	private int id;
	private String date;
	private String diseaseType;
	private String description;
	private String Treatment;
	private Pond pondId;
	
	
	
	public DiseaseAttack() {
		super();
	}



	public DiseaseAttack(int id, String date, String diseaseType, String description, String treatment, Pond pondId) {
		super();
		this.id = id;
		this.date = date;
		this.diseaseType = diseaseType;
		this.description = description;
		Treatment = treatment;
		this.pondId = pondId;
	}



	public int getId() {
		return id;
	}



	public String getDate() {
		return date;
	}



	public String getDiseaseType() {
		return diseaseType;
	}



	public String getDescription() {
		return description;
	}



	public String getTreatment() {
		return Treatment;
	}



	public Pond getPondId() {
		return pondId;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setTreatment(String treatment) {
		Treatment = treatment;
	}



	public void setPondId(Pond pondId) {
		this.pondId = pondId;
	}
	
	
	
	
	
}
