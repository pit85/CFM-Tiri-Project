

package com.cfm.tiri.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.cfm.tiri.mapping.RouteDetailedReport;
import com.cfm.tiri.mapping.RouteReport;



@NamedNativeQueries({
@NamedNativeQuery(
		  name="FuelConsumptionReport",
		  query="SELECT a.registration_number, min(a.route_date_start) as route_date_start, max(a.route_date_end) as route_date_end, min(a.odometer_start) as odometer_start, max(a.odometer_end) as odometer_end, sum(a.distance) as distance, ROUND(sum(a.amount_of_fuel)/sum(a.distance)*100,1) as average_consumption, ROUND(sum(a.model_fuel_consumption)/sum(a.distance)*100,1) as average_model_consumption, ROUND(sum(a.model_fuel_consumption) - sum(a.amount_of_fuel),0)  as fuel_saved FROM (SELECT a.id_route, a.name, a.registration_number, COALESCE(route_date, '2000-01-01 00:00:00') AS route_date_start, a.route_date AS route_date_end, COALESCE(b.weight_of_cargo, 0) AS weight_of_cargo, amount_of_fuel, COALESCE(a.odometer_start, 0) AS odometer_start, a.odometer_end, a.odometer_end - COALESCE(a.odometer_start, 0) AS distance, COALESCE((28 + 0.9 * b.weight_of_cargo), 0) AS model_average_consumption, ROUND(COALESCE((a.odometer_end - a.odometer_start) * (28 + 0.3 * b.weight_of_cargo) / 100, 0), 0) AS model_fuel_consumption FROM (SELECT r.id_route, r.amount_of_fuel, rs.name, registration_number, route_date, weight_of_cargo, odometer AS odometer_end, (SELECT MAX(odometer) FROM route rr LEFT JOIN squad ss ON ss.id_squad = rr.id_squad LEFT JOIN truck tt ON tt.id_truck = ss.id_truck WHERE tt.registration_number = t.registration_number AND rr.odometer < r.odometer) AS odometer_start FROM route r LEFT JOIN squad s ON s.id_squad = r.id_squad LEFT JOIN truck t ON t.id_truck = s.id_truck LEFT JOIN route_status rs ON rs.id_route_status = r.id_route_status) a LEFT JOIN (SELECT odometer, registration_number, weight_of_cargo FROM route r LEFT JOIN squad s ON s.id_squad = r.id_squad LEFT JOIN truck t ON t.id_truck = s.id_truck) b ON b.odometer = a.odometer_start AND b.registration_number = a.registration_number WHERE route_date <= ?) a LEFT JOIN (SELECT MAX(r.odometer) AS odometer, t.registration_number FROM route r LEFT JOIN squad s ON s.id_squad = r.id_squad LEFT JOIN truck t ON t.id_truck = s.id_truck WHERE route_date <= ? AND id_route_status = 1) b ON b.registration_number = a.registration_number AND a.odometer_end > b.odometer WHERE b.odometer IS NOT NULL GROUP BY a.registration_number",
		  resultSetMapping="RouteReportMapping"
		),
@NamedNativeQuery(
		  name="DetailedFuelConsumptionReport",
		  query="SELECT a.id_route, a.registration_number, COALESCE(b.route_date, '2000-01-01 00:00:00') AS route_date_start, a.route_date AS route_date_end, COALESCE(b.weight_of_cargo, 0) AS weight_of_cargo, COALESCE(a.odometer_start, 0) AS odometer_start, a.odometer_end, a.odometer_end - COALESCE(a.odometer_start, 0) AS distance, COALESCE((28 + 0.9 * b.weight_of_cargo), 0) AS model_average_consumption, ROUND(COALESCE((a.odometer_end - a.odometer_start) * (28 + 0.3 * b.weight_of_cargo) / 100, 0), 0) AS model_fuel_consumption FROM (SELECT r.id_route, registration_number, route_date, weight_of_cargo, odometer AS odometer_end, (SELECT MAX(odometer) FROM route rr LEFT JOIN squad ss ON ss.id_squad = rr.id_squad LEFT JOIN truck tt ON tt.id_truck = ss.id_truck WHERE rr.id_route_status IN (2 , 3) AND tt.registration_number = t.registration_number AND rr.odometer < r.odometer) AS odometer_start FROM route r LEFT JOIN squad s ON s.id_squad = r.id_squad LEFT JOIN truck t ON t.id_truck = s.id_truck WHERE id_route_status IN (2 , 3)) a LEFT JOIN (SELECT odometer, registration_number, route_date, weight_of_cargo FROM route r LEFT JOIN squad s ON s.id_squad = r.id_squad LEFT JOIN truck t ON t.id_truck = s.id_truck WHERE id_route_status IN (2 , 3)) b ON b.odometer = a.odometer_start AND b.registration_number = a.registration_number WHERE b.route_date>? and a.route_date<?",
		  resultSetMapping="DetailedRouteReportMapping"
		)
})


@SqlResultSetMappings({
	@SqlResultSetMapping(
          name = "RouteReportMapping",
          classes = @ConstructorResult(
          targetClass = RouteReport.class,
          columns = {
        		  	@ColumnResult(name = "registration_number", type = String.class),
        		  	@ColumnResult(name = "route_date_start", type = Date.class),
        		  	@ColumnResult(name = "route_date_end", type = Date.class),
        		  	@ColumnResult(name = "odometer_start", type = Integer.class),
        		  	@ColumnResult(name = "odometer_end", type = Integer.class),
        		  	@ColumnResult(name = "distance", type = Integer.class),
        		  	@ColumnResult(name = "average_consumption", type = Double.class),
        		  	@ColumnResult(name = "average_model_consumption", type = Double.class),
        		  	@ColumnResult(name = "fuel_saved", type = Integer.class),
                   	}
            )
),
	@SqlResultSetMapping(
	       name = "DetailedRouteReportMapping",
	       classes = @ConstructorResult(
	       targetClass = RouteDetailedReport.class,
	       columns = {
	        		@ColumnResult(name = "id_route", type = Long.class),
	        		@ColumnResult(name = "registration_number", type = String.class),
	        		@ColumnResult(name = "route_date_start", type = Date.class),
	        		@ColumnResult(name = "route_date_end", type = Date.class),
	        		@ColumnResult(name = "weight_of_cargo", type = Double.class),
	        		@ColumnResult(name = "odometer_start", type = Integer.class),
	        		@ColumnResult(name = "odometer_end", type = Integer.class),
	        		@ColumnResult(name = "distance", type = Integer.class),
	        		@ColumnResult(name = "model_average_consumption", type = Double.class),
	        		@ColumnResult(name = "model_fuel_consumption", type = Integer.class)
	                 }
	       )
	)
})

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
	private int odometer;
	private Squad squad;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date routeDate;
	private RouteStatus routeStatus;
	
	public Route(){
		
	}
	
	public Route(int amountOfFuel, int odometer, Squad squad, Date routeDate, RouteStatus routeStatus, double weightOfCargo){
		this.amountOfFuel = amountOfFuel;
		this.odometer = odometer;
		this.routeDate = routeDate;
		this.routeStatus = routeStatus;
		this.weightOfCargo = weightOfCargo;
		this.squad = squad;


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

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
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
