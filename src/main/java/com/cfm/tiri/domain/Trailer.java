package com.cfm.tiri.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table( name="trailer" )
public class Trailer {
	
	private long id;
	private long version;
	@NotNull
    @Size(min=6, max=15)
	private String registrationNumber;
	private String producer;
	private String model;
	@Min(1985)
	@Max(2050)
	private int productionYear;
	private boolean active;
	@Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  creationDate = new Date();
	private TrailerType trailerType;
	private List<Squad> squads;

	public Trailer(){
	}
	
	public Trailer( String registrationNumber, String producer, String model, int productionYear, Boolean active, int idTrailerType ){
		this.registrationNumber = registrationNumber;
		this.producer = producer;
		this.model = model;
		this.productionYear = productionYear;
		this.active = active;
	}
	
	@Version
	@Column(name = "version")
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
    @Id
    @Column(name = "id_trailer")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ" )
	public long getId() {
		return id;
	}
    
	public void setId(long id) {
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
	
	@ManyToOne
    @JoinColumn(name = "id_trailer_type")
    public TrailerType getTrailerType() {
        return trailerType;
    }
	
	public void setTrailerType(TrailerType trailerType){
		this.trailerType = trailerType;
	}
	
	@OneToMany(mappedBy = "trailer", cascade = CascadeType.ALL)
	public List<Squad> getSquads() {
		return squads;
	}
	
	public void setSquads(List<Squad> squads){
		this.squads = squads;
	}
	

}
