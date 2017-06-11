package com.cfm.tiri.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfm.tiri.pojo.RouteDetailedReport;
import com.cfm.tiri.pojo.RouteReport;
import com.cfm.tiri.view.AbstractITextPdfView;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */
public class PDFFuelReport extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get data model which is passed by the Spring container
		response.setHeader("Content-Disposition", "attachment; filename=\"fuelconsumptionreport.pdf\"");

		@SuppressWarnings("unchecked")
		List<RouteReport> fuelConsumptionReport = (List<RouteReport>) model.get("fuelconsumptionreport");

		@SuppressWarnings("unchecked")
		List<RouteDetailedReport> fuelDetailedConsumptionReport = (List<RouteDetailedReport>) model
				.get("fueldetailedconsumptionreport");

		// fonts
		Font bigfont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 14);
		Font arial = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 10);
		Font arialblack = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 9);
		bigfont.setColor(BaseColor.RED);
		arial.setColor(BaseColor.WHITE);
		arialblack.setColor(BaseColor.BLACK);

		// formats
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat df2 = new DecimalFormat(".##");

		doc.add(new Paragraph("Raport podsumowujący", bigfont));

		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 0.9f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.1f });
		table.setSpacingBefore(10);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("nr rejestracyjny", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("data początku", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("data końca", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("stan początkowy licznika", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("stan końcowy licznika", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("dystans", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("średnie zyżycie na 100 km", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("średnie zyżycie na 100 km według normy", arial));
		table.addCell(cell);

		cell.setPhrase(new Phrase("zaoszczędzone paliwo", arial));
		table.addCell(cell);

		// write table row data

		for (RouteReport report : fuelConsumptionReport) {

			cell.setBackgroundColor(BaseColor.WHITE);
			cell.setPadding(4);

			cell.setPhrase(new Phrase(String.valueOf(report.getRegistrationNumber()), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(formatter.format(report.getStartDate())), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(formatter.format(report.getEndDate())), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(report.getOdometerStart()), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(report.getOdometerEnd()), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(report.getDistance()), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(String.format("%.1f", report.getAverageConsumption())), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(df2.format(report.getAverageModelConsumption())), arialblack));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(report.getFuelSaved()), arialblack));
			table.addCell(cell);

			table.completeRow();
		}

		doc.add(table);

		doc.add(new Paragraph("Szczegóły", bigfont));

		PdfPTable detailedTable = new PdfPTable(12);
		detailedTable.setWidthPercentage(100.0f);
		detailedTable.setWidths(new float[] { 0.6f, 1.0f, 1.0f, 1.0f, 1.0f, 0.6f, 0.6f, 0.7f, 0.7f, 1.0f, 1.0f, 1.0f });
		detailedTable.setSpacingBefore(10);

		// define table header cell
		PdfPCell detailedCell = new PdfPCell();
		detailedCell.setBackgroundColor(BaseColor.GRAY);
		detailedCell.setPadding(5);

		// write table header
		detailedCell.setPhrase(new Phrase("id", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("typ", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("nr rejestracyjny", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("data początku", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("data końca", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("stan początkowy licznika", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("stan końcowy licznika", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("dystans", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("waga", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("liczba litrów", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("średnie zużycie na 100 km według normy", arial));
		detailedTable.addCell(detailedCell);

		detailedCell.setPhrase(new Phrase("zużycie według normy", arial));
		detailedTable.addCell(detailedCell);

		// write table row data

		for (RouteDetailedReport report : fuelDetailedConsumptionReport) {

			detailedCell.setBackgroundColor(BaseColor.WHITE);
			detailedCell.setPadding(4);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getIdRoute()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getName()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getRegistrationNumber()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(formatter.format(report.getRouteDateStart())), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(formatter.format(report.getRouteDateEnd())), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getOdometerStart()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getOdometerEnd()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getDistance()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(String.format("%.1f", report.getWeightOfCargo())), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(report.getAmountOfFuel()), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(df2.format(report.getModelAverageConsumption())), arialblack));
			detailedTable.addCell(detailedCell);

			detailedCell.setPhrase(new Phrase(String.valueOf(df2.format(report.getModelFuelConsumption())), arialblack));
			detailedTable.addCell(detailedCell);

			detailedTable.completeRow();
		}

		doc.add(detailedTable);

	}

}