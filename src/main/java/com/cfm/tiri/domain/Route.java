

package com.cfm.tiri.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.cfm.tiri.mapping.RouteReport;


@Entity
@NamedNativeQuery(
		  name="FuelConsumptionReport",
		  query="SELECT a.registration_number, COALESCE(b.start_date, ?) as start_date, COALESCE(a.end_date, ?) as end_date, COALESCE(b.odometer_start, 0) as odometer_start, COALESCE(a.odometer_end, 0) as odometer_end, coalesce(a.fuel_consumption, 0) as fuel_consumption, COALESCE(a.fuel_consumption/(a.odometer_end - b.odometer_start)*100, 0) as average_consumption FROM ( SELECT registration_number, MAX(odometer) as odometer_end, MAX(route_date) as end_date, SUM(amount_of_fuel) as fuel_consumption FROM route r LEFT JOIN squad s ON s.id_squad=r.id_squad LEFT JOIN truck t ON t.id_truck=s.id_truck WHERE route_date>=? AND route_date<=? GROUP BY registration_number) a  LEFT JOIN (SELECT registration_number, max(odometer) as odometer_start, MAX(route_date) as start_date FROM route r LEFT JOIN squad s ON s.id_squad=r.id_squad LEFT JOIN truck t ON t.id_truck=s.id_truck WHERE route_date<? GROUP BY registration_number) b ON b.registration_number=a.registration_number",
		  resultSetMapping="RouteReportMapping"
		)
@SqlResultSetMappings({
	@SqlResultSetMapping(
            name = "RouteReportMapping",
            classes = @ConstructorResult(
                   targetClass = RouteReport.class,
                    columns = {
                        @ColumnResult(name = "registration_number", type = String.class),
                        @ColumnResult(name = "start_date", type = Date.class),
                        @ColumnResult(name = "end_date", type = Date.class),
                        @ColumnResult(name = "odometer_start", type = Integer.class),
                        @ColumnResult(name = "odometer_end", type = Integer.class),
                        @ColumnResult(name = "fuel_consumption", type = Integer.class),
                        @ColumnResult(name = "average_consumption", type = Double.class),
                   				}
            )
)})
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
