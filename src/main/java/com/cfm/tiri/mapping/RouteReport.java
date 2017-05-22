package com.cfm.tiri.mapping;
import java.util.Date;

public class RouteReport {
	

	private String registrationNumber;
	private Date startDate;
	private Date endDate;
	private int odometerStart;
	private int odometerEnd;
	private int distance;
	private double averageConsumption;
	private double averageModelConsumption;
	private int fuelSaved;
	
	public RouteReport(){
	}
	
	public RouteReport(String registrationNumber, Date startDate, Date endDate, int odometerStart, int odometerEnd, int distance, double averageModelConsumption, double averageConsumption, int fuelSaved){
		this.registrationNumber = registrationNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.odometerStart = odometerStart;
		this.odometerEnd = odometerEnd;
		this.distance = distance;
		this.averageModelConsumption = averageModelConsumption;
		this.averageConsumption = averageConsumption;
		this.fuelSaved = fuelSaved;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getFuelSaved() {
		return fuelSaved;
	}

	public void setFuelSaved(int fuelSaved) {
		this.fuelSaved = fuelSaved;
	}

	public double getAverageModelConsumption() {
		return averageModelConsumption;
	}

	public void setAverageModelConsumption(double averageModelConsumption) {
		this.averageModelConsumption = averageModelConsumption;
	}

}
