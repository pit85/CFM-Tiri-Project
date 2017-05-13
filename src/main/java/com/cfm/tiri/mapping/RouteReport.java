package com.cfm.tiri.mapping;
import java.util.Date;

public class RouteReport {
	

	private String registrationNumber;
	private Date startDate;
	private Date endDate;
	private int odometerStart;
	private int odometerEnd;
	private int fuelConsumption;
	private double averageConsumption;
	
	public RouteReport(){
	}
	
	public RouteReport(String registrationNumber, Date startDate, Date endDate, int odometerStart, int odometerEnd, int fuelConsumption, double averageConsumption){
		this.registrationNumber = registrationNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.odometerStart = odometerStart;
		this.odometerEnd = odometerEnd;
		this.fuelConsumption = fuelConsumption;
		this.averageConsumption = averageConsumption;
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

	public int getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(int fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
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

}
