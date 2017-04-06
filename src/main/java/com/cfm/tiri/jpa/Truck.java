package com.cfm.tiri.jpa;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Truck {

	private Integer id;

	@Version
	private Integer version;
	private String registrationNumber;
	private String producer;
	private String model;
	private String euroStandard;
	private int productionYear;
	private int horsePower;
	private boolean Active;
	private LocalDate creationDate;

	public Truck(){
	}
	
	public Truck(Integer version, String registrationNumber, String producer, String model, 
			String euroStandard, int productionYear, int horsePower, boolean Active, LocalDate creationDate){
		this.version = version;
		this.registrationNumber = registrationNumber;
		this.producer = producer;
		this.model = model;
		this.euroStandard = euroStandard;
		this.productionYear = productionYear;
		this.horsePower = horsePower;
		this.Active =Active;
		this.creationDate = LocalDate.now();

	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
    @Id
    @Column(name = "ID_TRUCK")
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

	public String getEuroStandard() {
		return euroStandard;
	}

	public void setEuroStandard(String euroStandard) {
		this.euroStandard = euroStandard;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean Active) {
		this.Active = Active;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = LocalDate.now();
	}

}