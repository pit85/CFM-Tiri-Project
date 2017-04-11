package com.cfm.tiri.domain;

import java.time.LocalDate;
import java.util.Date;

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
	@Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  creationDate = new Date();
	
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
