package com.cfm.tiri.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "trailer_type")
public class TrailerType {
	
	private long id;
	private long version;
	private String name;
	private Set<Trailer> trailers;
	
	
	public TrailerType(){	
	}
	
	public TrailerType(String name){
		this.name = name;
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
    @Column(name = "id_trailer_type")
    @GeneratedValue(strategy = GenerationType.AUTO) //Provides for the specification of generation strategies for the values of primary keys.
	public long getId() {
		return id;
	}
    
    public void setId(long id){
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