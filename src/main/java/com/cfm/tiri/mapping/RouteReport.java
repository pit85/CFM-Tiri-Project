package com.cfm.tiri.mapping;
import java.util.Date;

public class RouteReport {
	

	private String registrationNumber;
	private Date routeStartDate;
	private Date routeEndDate;
	private int odometerStart;
	private int odometerEnd;
	private int distance;
	private double averageConsumption;
	private double averageModelConsumption;
	private int fuelSaved;
	
	public RouteReport(){
	}
	
	public RouteReport(String registrationNumber, Date routeStartDate, Date routeEndDate, int odometerStart, int odometerEnd, int distance, double averageConsumption, double averageModelConsumption, int fuelSaved){
		this.registrationNumber = registrationNumber;
		this.routeStartDate = routeStartDate;
		this.routeEndDate = routeEndDate;
		this.odometerStart = odometerStart;
		this.odometerEnd = odometerEnd;
		this.distance = distance;
		this.averageConsumption = averageConsumption;
		this.averageModelConsumption = averageModelConsumption;
		this.setFuelSaved(fuelSaved);
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getOdometerStart() {
		return odometerStart;
	}

	public void setOdometerStart(int odometerStart) {
		this.odometerStart = odometerStart;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getOdometerEnd() {
		return odometerEnd;
	}

	public void setOdometerEnd(int odometerEnd) {
		this.odometerEnd = odometerEnd;
	}

	public double getAverageConsumption() {
		return averageConsumption;
	}

	public void setAverageConsumption(double averageConsumption) {
		this.averageConsumption = averageConsumption;
	}

	public Date getRouteStartDate() {
		return routeStartDate;
	}

	public void setRouteStartDate(Date routeStartDate) {
		this.routeStartDate = routeStartDate;
	}

	public Date getRouteEndDate() {
		return routeEndDate;
	}

	public void setRouteEndDate(Date routeEndDate) {
		this.routeEndDate = routeEndDate;
	}

	public double getAverageModelConsumption() {
		return averageModelConsumption;
	}

	public void setAverageModelConsumption(double averageModelConsumption) {
		this.averageModelConsumption = averageModelConsumption;
	}

	public int getFuelSaved() {
		return fuelSaved;
	}

	public void setFuelSaved(int fuelSaved) {
		this.fuelSaved = fuelSaved;
	}

}
