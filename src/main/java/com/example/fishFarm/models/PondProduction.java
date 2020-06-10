package com.example.fishFarm.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class PondProduction {

	
		@Id
		private int productionid;
		
		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinColumn()
		
		private Pond pondId;
		
		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinColumn()
		private Species species;
		private int Quantity;
		private  String source;
		private String date;
		
		
		public PondProduction() {
			super();
		}
		public PondProduction(int productionid, Pond pondId, Species species, int quantity, String source,
				String date) {
			super();
			this.productionid = productionid;
			this.pondId = pondId;
			this.species = species;
			Quantity = quantity;
			this.source = source;
			this.date = date;
		}
		public int getProductionid() {
			return productionid;
		}
		public Pond getPondId() {
			return pondId;
		}
		public Species getSpecies() {
			return species;
		}
		public int getQuantity() {
			return Quantity;
		}
		public String getSource() {
			return source;
		}
		public String getDate() {
			return date;
		}
		public void setProductionid(int productionid) {
			this.productionid = productionid;
		}
		public void setPondId(Pond pondId) {
			this.pondId = pondId;
		}
		public void setSpecies(Species species) {
			this.species = species;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public void setDate(String date) {
			this.date = date;
		}
		

	

}
