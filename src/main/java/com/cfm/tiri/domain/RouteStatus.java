package com.cfm.tiri.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="route_status")
public class RouteStatus {
	
	private int id;
	private String name;
	private Set<Route> routes;
	
	
	public RouteStatus(){
	}
	
	public RouteStatus(String name){
		this.name = name;
	}
	
    @Id
    @Column(name = "id_route_status")
    @GeneratedValue(strategy = GenerationType.AUTO) //Provides for the specification of generation strategies for the values of primary keys.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "routeStatus", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	

}
