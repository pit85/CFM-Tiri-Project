package com.cfm.tiri.pojo;

import java.util.Date;

public class RouteDetailedReport {
	
	private int idRoute;
	private String name;
	private String registrationNumber;
	private Date routeDateStart;
	private Date routeDateEnd;
	private Double weightOfCargo;
	private int amountOfFuel;
	private int odometerStart;
	private int odometerEnd;
	private int distance;
	private double modelAverageConsumption;
	private double modelFuelConsumption;
	
	public RouteDetailedReport (){
	}
	
	public RouteDetailedReport (int idRoute, String name, String registrationNumber, Date routeDateStart, Date routeDateEnd, Double weightOfCargo, int amountOfFuel, int odometerStart, int odometerEnd, int distance, double modelAverageConsumption, double modelFuelConsumption){
		this.idRoute = idRoute;
		this.name = name;
		this.registrationNumber = registrationNumber;
		this.routeDateStart = routeDateStart;
		this.routeDateEnd = routeDateEnd;
		this.weightOfCargo = weightOfCargo;
		this.amountOfFuel = amountOfFuel;
		this.odometerStart = odometerStart;
		this.odometerEnd = odometerEnd;
		this.distance = distance;
		this.modelAverageConsumption = modelAverageConsumption;
		this.modelFuelConsumption = modelFuelConsumption;
	}
	
	public int getIdRoute() {
		return idRoute;
	}
	public void setIdRoute(int idRoute) {
		this.idRoute = idRoute;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRouteDateStart() {
		return routeDateStart;
	}
	public void setRouteDateStart(Date routeDateStart) {
		this.routeDateStart = routeDateStart;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Date getRouteDateEnd() {
		return routeDateEnd;
	}
	public void setRouteDateEnd(Date routeDateEnd) {
		this.routeDateEnd = routeDateEnd;
	}
	public Double getWeightOfCargo() {
		return weightOfCargo;
	}
	public void setWeightOfCargo(Double weightOfCargo) {
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
	public int getAmountOfFuel() {
		return amountOfFuel;
	}
	public void setAmountOfFuel(int amountOfFuel) {
		this.amountOfFuel = amountOfFuel;
	}
	public double getModelAverageConsumption() {
		return modelAverageConsumption;
	}
	public void setModelAverageConsumption(double modelAverageConsumption) {
		this.modelAverageConsumption = modelAverageConsumption;
	}
	public double getModelFuelConsumption() {
		return modelFuelConsumption;
	}
	public void setModelFuelConsumption(double modelFuelConsumption) {
		this.modelFuelConsumption = modelFuelConsumption;
	}
	
	

}
