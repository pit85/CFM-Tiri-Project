package com.cfm.tiri.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="truck")
public class Truck {

	private Integer id;

	@Version
	private Integer version;
	@NotNull
    @Size(min=6, max=15)
	private String registrationNumber;
	private String producer;
	private String model;
	@NotNull
	@Size(min=1, max=10)
	private String euroStandard;
	@Min(1985)
	@Max(2100)
	private int productionYear;
	private int horsePower;
	private boolean active;
	@Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  creationDate = new Date();
	private List <Squad> squads;

	public Truck(){
	}
	
	public Truck(Integer version, String registrationNumber, String producer, String model, 
			String euroStandard, int productionYear, int horsePower, boolean active){
		this.version = version;
		this.registrationNumber = registrationNumber;
		this.producer = producer;
		this.model = model;
		this.euroStandard = euroStandard;
		this.productionYear = productionYear;
		this.horsePower = horsePower;
		this.active = active;

	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
    @Id
    @Column(name = "id_truck")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ" )
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
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@OneToMany(mappedBy = "truck", cascade = CascadeType.ALL)
	public List<Squad> getSquads() {
		return squads;
	}
	
	public void setSquads(List<Squad> squads){
		this.squads = squads;
	}



}