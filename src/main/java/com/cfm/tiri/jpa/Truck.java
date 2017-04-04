package com.cfm.tiri.jpa;

import java.time.LocalDate;
import javax.persistence.*;
 
@Entity
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    	setCreationDate();
    }
    
    
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

	public boolean getActive() {
		return Active;
	}

	public void setActive(boolean Active) {
		this.Active = Active;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate() {
		LocalDate currentDate = LocalDate.now();
	    this.creationDate = currentDate;
	}
	
}