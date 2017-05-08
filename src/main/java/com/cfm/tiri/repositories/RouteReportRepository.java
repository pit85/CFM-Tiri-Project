package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cfm.tiri.domain.RouteReport;



@Repository
public interface RouteReportRepository extends CrudRepository<RouteReport, Long>{
	
	
	@Query(value = "SELECT a.registration_number, COALESCE(b.start_date, :startdate) as start_date, COALESCE(a.end_date, :enddate) as end_date, COALESCE(b.odometer_start, 0) as odometer_start, COALESCE(a.odometer_end, 0) as odometer_end, coalesce(a.fuel_consumption, 0) as fuel_consumption, COALESCE(a.fuel_consumption/(a.odometer_end - b.odometer_start)*100, 0) as average_consumption FROM ( SELECT registration_number, MAX(odometer) as odometer_end, MAX(route_date) as end_date, SUM(amount_of_fuel) as fuel_consumption FROM route r LEFT JOIN squad s ON s.id_squad=r.id_squad LEFT JOIN truck t ON t.id_truck=s.id_truck WHERE route_date>=:startdate AND route_date<=:enddate GROUP BY registration_number) a  LEFT JOIN (SELECT registration_number, max(odometer) as odometer_start, MAX(route_date) as start_date FROM route r LEFT JOIN squad s ON s.id_squad=r.id_squad LEFT JOIN truck t ON t.id_truck=s.id_truck WHERE route_date<:startdate GROUP BY registration_number) b ON b.registration_number=a.registration_number", nativeQuery = true)
	Iterable<RouteReport> generateFuelConsuptionReport(@Param("startdate") String startDate, @Param("enddate") String endDate);


}