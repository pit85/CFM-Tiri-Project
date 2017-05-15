package com.cfm.tiri.mapping;

import java.util.Date;

public class RouteDetailedReport {
	
	private long idRoute;
	private String registrationNumber;
	private Date routeDateStart;
	private Date routeDateEnd;
	private double weightOfCargo;
	private int odometerStart;
	private int odometerEnd;
	private int distance; 
	private double modelAverageConsumption;
	private int modelFuelConsumption;
	
	public RouteDetailedReport(){
	};
	
	public RouteDetailedReport(long idRoute, String registrationNumber,  Date routeDateStart, Date routeDateEnd,  double weightOfCargo, int odometerStart, int odometerEnd, int distance, double modelAverageConsumption, int modelFuelConsumption){
		this.idRoute = idRoute;
		this.registrationNumber = registrationNumber;
		this.routeDateStart = routeDateStart;
		this.routeDateEnd = routeDateEnd;
		this.weightOfCargo = weightOfCargo;
		this.odometerStart = odometerStart;
		this.odometerEnd = odometerEnd;
		this.distance = distance;
		this.modelAverageConsumption = modelAverageConsumption;
		this.modelFuelConsumption = modelFuelConsumption;
	}
	
	public long getidRoute() {
		return idRoute;
	}
	public void setidRoute(long idRoute) {
		this.idRoute = idRoute;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Date getRouteDateStart() {
		return routeDateStart;
	}
	public void setRouteDateStart(Date routeDateStart) {
		this.routeDateStart = routeDateStart;
	}
	public Date getRouteDateEnd() {
		return routeDateEnd;
	}
	public void setRouteDateEnd(Date routeDateEnd) {
		this.routeDateEnd = routeDateEnd;
	}
	public double getWeightOfCargo() {
		return weightOfCargo;
	}
	public void setWeightOfCargo(double weightOfCargo) {
		this.weightOfCargo = weightOfCargo;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getModelAverageConsumption() {
		return modelAverageConsumption;
	}

	public void setModelAverageConsumption(double modelAverageConsumption) {
		this.modelAverageConsumption = modelAverageConsumption;
	}

	public int getModelFuelConsumption() {
		return modelFuelConsumption;
	}

	public void setModelFuelConsumption(int modelFuelConsumption) {
		this.modelFuelConsumption = modelFuelConsumption;
	}
}
