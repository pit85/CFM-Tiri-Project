package com.cfm.tiri.jpa;

import java.time.LocalDate;

import javax.persistence.*;

@Entity // klasa zarządzana przez JPA, odpowiednik w DB
public class Trailer {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) //Provides for the specification of generation strategies for the values of primary keys.
	private Integer id;
	
	@Version //Specifies the version field or property of an entity class that serves as its optimistic lock value. The version is used to ensure integrity when performing the merge operation and for optimistic concurrency control.
	private Integer version;
	private String registrationNumber;
	private String producer;
	private String model;
	private int productionYear;
	private int idTrailerType;
	private boolean Active;
	private LocalDate creationDate;
	

	public Trailer(){
		setCreationDate();
	}
	
//	public Trailer(TrailerType trailerType){
//		setCreationDate();
//		this.trailerType = trailerType;
//	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getIdTrailerType() {
		return idTrailerType;
	}

	public void setIdTrailerType(int idTrailerType) {
		this.idTrailerType = idTrailerType;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate() {
		LocalDate currentDate = LocalDate.now();
		this.creationDate = currentDate;
	}
	
/*	@ManyToOne
    @JoinColumn(name = "id_trailer_type")
    public TrailerType getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(TrailerType trailerType) {
        this.trailerType = trailerType;
    }
*/
}
