package com.cfm.tiri.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "squad")
public class Squad {

	private Integer id;

	@Version
	private Integer version;
	private Truck truck;
	private Trailer trailer;
	private User user;
	private Boolean active;
	@Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  creationDate = new Date();
	
	public Squad(){
	}
	
	public Squad(Truck truck, Trailer trailer, User user){
		this.truck = truck;
		this.trailer = trailer;
		this.user = user;
	}

    @Id
    @Column(name = "id_squad")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ" )
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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

	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_truck")
	public Truck getTruck() {
		return truck;
	}
	
	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_trailer")
	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}			

}
