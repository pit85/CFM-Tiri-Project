package com.cfm.tiri.jpa;

import java.time.LocalDate;

import javax.persistence.*;

@Entity // klasa zarządzana przez JPA, odpowiednik w DB
@Table(name="TRAILER")
public class Trailer {
	
	private Integer id;
	
	@Version //Specifies the version field or property of an entity class that serves as its optimistic lock value. The version is used to ensure integrity when performing the merge operation and for optimistic concurrency control.
	private Integer version;
	
	private String registrationNumber;
	private String producer;
	private String model;
	private int productionYear;
	
	@Column(name="ID_TRAILER_TYPE")
	private int idTrailerType;
	private boolean active;
	
	private LocalDate creationDate;
	private TrailerType trailerType;

	public Trailer(){
	}
	
	public Trailer(Integer version, String registrationNumber, String producer, String model, int productionYear, boolean active, TrailerType trailerType, int idTrailerType ,LocalDate creationDate){
		this.version = version;
		this.registrationNumber = registrationNumber;
		this.producer = producer;
		this.model = model;
		this.productionYear = productionYear;
		this.active = active;
		this.trailerType = trailerType;
		this.idTrailerType = idTrailerType;
		this.creationDate = LocalDate.now();
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
    @Id
    @Column(name = "ID_TRAILER")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		active = active;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = LocalDate.now();
	}
	
	@ManyToOne
    @JoinColumn(name = "ID_TRAILER_TYPE")
    public TrailerType getTrailerType() {
        return trailerType;
    }
	
	public void setTrailerType(TrailerType trailerType){
		this.trailerType = trailerType;
	}
	

}
