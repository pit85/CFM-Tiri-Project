package com.cfm.tiri.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TRAILER_TYPE")
public class TrailerType {
	
	private Integer id;
	
	@Version //Specifies the version field or property of an entity class that serves as its optimistic lock value. The version is used to ensure integrity when performing the merge operation and for optimistic concurrency control.
	private Integer version;
	
	private String name;
	private Set<Trailer> trailers;
	
	
	public TrailerType(){	
	}
	
	public TrailerType(String name){
		this.name = name;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
    @Id
    @Column(name = "ID_TRAILER_TYPE")
    @GeneratedValue(strategy = GenerationType.AUTO) //Provides for the specification of generation strategies for the values of primary keys.
	public Integer getId() {
		return id;
	}
    
    public void setId(Integer id){
    	this.id = id;
    }
	
	@OneToMany(mappedBy = "trailerType", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Trailer> getTrailers() {
		return trailers;
	}

	public void setTrailers(Set<Trailer> trailers) {
		this.trailers = trailers;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}