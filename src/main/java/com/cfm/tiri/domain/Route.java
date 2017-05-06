

package com.cfm.tiri.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "route")
public class Route {
	
	private long id;

	
	@NotNull
	@Min(0)
	@Max(40)
	private double weightOfCargo;

	private int amountOfFuel;
	@NotNull
	@Min(0)
	@Max(9999999)
	private long odometer;
	private Squad squad;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date routeDate;
	private RouteStatus routeStatus;
	
	public Route(){
		
	}
	
	public Route(int amountOfFuel, int odometer, Squad squad, Date routeDate){
		this.amountOfFuel = amountOfFuel;
		this.odometer = odometer;
		this.routeDate = routeDate;

	}

	@Id
	@Column(name = "id_route")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ" )
	public long getId() {
		return id;
	}	

	public void setId(long id) {
		this.id = id;
	}
	

	public int getAmountOfFuel() {
		return amountOfFuel;
	}

	public void setAmountOfFuel(int amountOfFuel) {
		this.amountOfFuel = amountOfFuel;
	}

	public long getOdometer() {
		return odometer;
	}

	public void setOdometer(long odometer) {
		this.odometer = odometer;
	}

	public Date getRouteDate() {
		return routeDate;
	}

	public void setRouteDate(Date routeDate) {
		this.routeDate = routeDate;
	}
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_squad")
	public Squad getSquad() {
		return squad;
	}
	
	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	public double getWeightOfCargo() {
		return weightOfCargo;
	}

	public void setWeightOfCargo(double weightOfCargo) {
		this.weightOfCargo = weightOfCargo;
	}

	@ManyToOne
	@NotNull
    @JoinColumn(name = "id_route_status")
	public RouteStatus getRouteStatus() {
		return routeStatus;
	}

	public void setRouteStatus(RouteStatus routeStatus) {
		this.routeStatus = routeStatus;
	}
	
	

}
