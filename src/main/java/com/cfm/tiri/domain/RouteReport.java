package com.cfm.tiri.domain;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class RouteReport {
	

	private String registrationNumber;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private int odometerStart;
	private int odometerEnd;
	private int fuelConsumption;
	private double averageConsumption;
	
	@Id
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
