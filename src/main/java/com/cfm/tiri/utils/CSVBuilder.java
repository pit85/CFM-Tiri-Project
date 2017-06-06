package com.cfm.tiri.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.cfm.tiri.pojo.RouteReport;
import com.cfm.tiri.view.AbstractCsvView;

public class CSVBuilder extends AbstractCsvView {
@Override
protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setHeader("Content-Disposition", "attachment; filename=\"fuelconsumptionreport.csv\"");

    @SuppressWarnings("unchecked")
	List<RouteReport> reports = (List<RouteReport>) model.get("fuelconsumptionreport");
    String[] header = {"registrationNumber","startDate","endDate","odometerStart","odometerEnd","distance","averageConsumption","averageModelConsumption", "fuelSaved"};
    ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
            CsvPreference.STANDARD_PREFERENCE);

    csvWriter.writeHeader(header);

    for(RouteReport report : reports){
        csvWriter.write(report, header);
    }
    csvWriter.close();


}
}