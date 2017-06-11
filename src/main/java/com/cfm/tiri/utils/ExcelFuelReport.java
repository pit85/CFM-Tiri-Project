package com.cfm.tiri.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.cfm.tiri.pojo.RouteDetailedReport;
import com.cfm.tiri.pojo.RouteReport;

public class ExcelFuelReport extends AbstractXlsxView {

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"fuelconsumptionreport.xlsx\"");

		@SuppressWarnings("unchecked")
		List<RouteReport> fuelConsumptionReport = (List<RouteReport>) model.get("fuelconsumptionreport");

		@SuppressWarnings("unchecked")
		List<RouteDetailedReport> fuelDetailedConsumptionReport = (List<RouteDetailedReport>) model
				.get("fueldetailedconsumptionreport");

		// create excel xlsx sheets
		Sheet fuelConsumptionSheet = workbook.createSheet("Raport spalania");
		fuelConsumptionSheet.setDefaultColumnWidth(15);

		Sheet fuelDetailedConsumptionSheet = workbook.createSheet("Szczegóły");
		fuelDetailedConsumptionSheet.setDefaultColumnWidth(15);

		// formats
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row for main Fuel Consumption Report
		Row fuelConsumptionReportHeader = fuelConsumptionSheet.createRow(0);
		fuelConsumptionReportHeader.createCell(0).setCellValue("nr rejestracyjny");
		fuelConsumptionReportHeader.getCell(0).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(1).setCellValue("data początku");
		fuelConsumptionReportHeader.getCell(1).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(2).setCellValue("data końca");
		fuelConsumptionReportHeader.getCell(2).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(3).setCellValue("stan początkowy licznika");
		fuelConsumptionReportHeader.getCell(3).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(4).setCellValue("stan końcowy licznika");
		fuelConsumptionReportHeader.getCell(4).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(5).setCellValue("dystans");
		fuelConsumptionReportHeader.getCell(5).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(6).setCellValue("średnie zyżycie na 100 km");
		fuelConsumptionReportHeader.getCell(6).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(7).setCellValue("średnie zyżycie na 100 km według normy");
		fuelConsumptionReportHeader.getCell(7).setCellStyle(style);
		fuelConsumptionReportHeader.createCell(8).setCellValue("zaoszczędzone paliwo");
		fuelConsumptionReportHeader.getCell(8).setCellStyle(style);

		int rowCount = 1;

		for (RouteReport report : fuelConsumptionReport) {
			Row reportRow = fuelConsumptionSheet.createRow(rowCount++);
			reportRow.createCell(0).setCellValue(report.getRegistrationNumber());
			reportRow.createCell(1).setCellValue(formatter.format(report.getStartDate()));
			reportRow.createCell(2).setCellValue(formatter.format(report.getEndDate()));
			reportRow.createCell(3).setCellValue(report.getOdometerStart());
			reportRow.createCell(4).setCellValue(report.getOdometerEnd());
			reportRow.createCell(5).setCellValue(report.getDistance());
			reportRow.createCell(6).setCellValue(report.getAverageConsumption());
			reportRow.createCell(7).setCellValue(report.getAverageModelConsumption());
			reportRow.createCell(8).setCellValue(report.getFuelSaved());

		}

		// create header row for main Fuel Consumption Report
		Row fuelDetailedConsumptionReportHeader = fuelDetailedConsumptionSheet.createRow(0);
		fuelDetailedConsumptionReportHeader.createCell(0).setCellValue("id");
		fuelDetailedConsumptionReportHeader.getCell(0).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(1).setCellValue("typ");
		fuelDetailedConsumptionReportHeader.getCell(1).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(2).setCellValue("nr rejestracyjny");
		fuelDetailedConsumptionReportHeader.getCell(2).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(3).setCellValue("data początku");
		fuelDetailedConsumptionReportHeader.getCell(3).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(4).setCellValue("data końca");
		fuelDetailedConsumptionReportHeader.getCell(4).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(5).setCellValue("stan początkowy licznika");
		fuelDetailedConsumptionReportHeader.getCell(5).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(6).setCellValue("stan końcowy licznika");
		fuelDetailedConsumptionReportHeader.getCell(6).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(7).setCellValue("dystans");
		fuelDetailedConsumptionReportHeader.getCell(7).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(8).setCellValue("waga");
		fuelDetailedConsumptionReportHeader.getCell(8).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(9).setCellValue("liczba litrów");
		fuelDetailedConsumptionReportHeader.getCell(9).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(10).setCellValue("średnie zużycie na 100 km według normy");
		fuelDetailedConsumptionReportHeader.getCell(10).setCellStyle(style);
		fuelDetailedConsumptionReportHeader.createCell(11).setCellValue("zużycie według normy");
		fuelDetailedConsumptionReportHeader.getCell(11).setCellStyle(style);

		rowCount = 1;

		for (RouteDetailedReport report : fuelDetailedConsumptionReport) {
			Row reportRow = fuelDetailedConsumptionSheet.createRow(rowCount++);
			reportRow.createCell(0).setCellValue(report.getIdRoute());
			reportRow.createCell(1).setCellValue(report.getName());
			reportRow.createCell(2).setCellValue(report.getRegistrationNumber());
			reportRow.createCell(3).setCellValue(formatter.format(report.getRouteDateStart()));
			reportRow.createCell(4).setCellValue(formatter.format(report.getRouteDateEnd()));
			reportRow.createCell(5).setCellValue(report.getOdometerStart());
			reportRow.createCell(6).setCellValue(report.getOdometerEnd());
			reportRow.createCell(7).setCellValue(report.getDistance());
			reportRow.createCell(8).setCellValue(report.getWeightOfCargo());
			reportRow.createCell(9).setCellValue(report.getAmountOfFuel());
			reportRow.createCell(10).setCellValue(report.getModelAverageConsumption());
			reportRow.createCell(11).setCellValue(report.getModelFuelConsumption());

		}

	}

}