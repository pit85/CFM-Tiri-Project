package com.cfm.tiri.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SQUAD")
public class Squad {

	private Integer id;

	@Version
	private Integer version;
	private Truck truck;
	@OneToOne(mappedBy = "squad", cascade = CascadeType.ALL, orphanRemoval = true)
	private Trailer trailer;
	private User user;
	private Boolean active;
	@Column(name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
	
	public Squad(){
	}
	
	public Squad(Truck truck, Trailer trailer, User user, Boolean active){

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	

	public Truck getTruck() {
		return truck;
	}




	public Trailer getTrailer() {
		return trailer;
	}

    public void addTrailer(Trailer trailer) {
        this.trailer = trailer;
        trailer.setSquad(this);
    }
 
    public void removeTrailer() {
        if (trailer != null) {
        	trailer.setSquad(null);
        }
        this.trailer = null;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
