/*package com.cfm.tiri.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.RowMapper;

import com.cfm.tiri.domain.RouteReport;

public class RouteReportMapper implements RowMapper<RouteReport> {

	@Query(value = "SELECT  a.registration_number, :startdate as start_date, :enddate as end_date, b.odometer_start, a.odometer_end, a.fuel_consumtion, a.fuel_consumtion/(a.odometer_end - b.odometer_start)*100 as average_consumption FROM ( SELECT registration_number, MAX(odometer) as odometer_end, SUM(amount_of_fuel) as fuel_consumtion FROM tiridb.route r LEFT JOIN tiridb.squad s ON s.id_squad=r.id_squad LEFT JOIN tiridb.truck t ON t.id_truck=s.id_truck WHERE route_date>=:startdate AND route_date<=:enddate GROUP BY registration_number) a  LEFT JOIN (SELECT registration_number, max(odometer) as odometer_start FROM tiridb.route r LEFT JOIN tiridb.squad s ON s.id_squad=r.id_squad LEFT JOIN tiridb.truck t ON t.id_truck=s.id_truck WHERE route_date<:startdate GROUP BY registration_number) b ON b.registration_number=a.registration_number", nativeQuery = true)
	Iterable<RouteReport> generateReport(@Param("startdate") String startDate, @Param("enddate") String endDate) {
		return null;
	}
	
	
    @Override
    public RouteReport mapRow(ResultSet rs, int rowNum) throws SQLException {

    	RouteReport routeReport = new RouteReport();

    	routeReport.setStateId(rs.getInt("STATEID"));
    	routeReport.setAbbreviation(rs.getString("ABBREVIATION"));
    	routeReport.setPostalCode(rs.getString("POSTALCODE"));
    	routeReport.setState(rs.getString("STATE"));

        return state;
    }

}
*/