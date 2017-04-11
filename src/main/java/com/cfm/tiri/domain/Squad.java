package com.cfm.tiri.domain;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SQUAD")
public class Squad {

	private Integer id;

	@Version
	private Integer version;
	private Truck truck;
	private Trailer trailer;
	private User user;
	private Boolean active;
	private LocalDate creationDate;
	
	public Squad(){
	}
	
	public Squad(Truck truck, Trailer trailer, User user, LocalDate creationDate, Boolean active){

		this.creationDate = creationDate;
		this.active = active;
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
	
	@OneToOne
    @JoinColumn(name = "ID_TRUCK")
	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	@OneToOne
    @JoinColumn(name = "ID_TRAILER")
	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	@OneToOne
    @JoinColumn(name = "ID_USER")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
