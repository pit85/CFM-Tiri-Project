package com.cfm.tiri.domain;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "SQUAD")
public class Squad {

	private Integer id;

	@Version
	private Integer version;
	private Integer idTruck;
	private Integer idTrailer;
	private Integer idDriver;
	private Boolean active;
	private LocalDate creationDate;
	
	public Squad(){
		
	}

    @Id
    @Column(name = "ID_SQUAD")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTruck() {
		return idTruck;
	}

	public void setIdTruck(Integer idTruck) {
		this.idTruck = idTruck;
	}

	public Integer getIdTrailer() {
		return idTrailer;
	}

	public void setIdTrailer(Integer idTrailer) {
		this.idTrailer = idTrailer;
	}

	public Integer getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(Integer idDriver) {
		this.idDriver = idDriver;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = LocalDate.now();
	}

}
