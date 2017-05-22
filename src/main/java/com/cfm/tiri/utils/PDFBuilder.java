package com.cfm.tiri.utils;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfm.tiri.domain.Route;
import com.cfm.tiri.mapping.RouteReport;
import com.cfm.tiri.view.AbstractITextPdfView;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Route> fuelConsumptionReport =  (List<Route>) model.get("fuelconsumptionreport");
         
        doc.add(new Paragraph("Recommended books for Spring framework"));
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
        
        // fonts
        Font smallfont = FontFactory.getFont("Arial", 7);
        Font arial = FontFactory.getFont("Arial", 11);
        smallfont.setColor(BaseColor.WHITE);
        arial.setColor(BaseColor.WHITE);
        

         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("Nr rejestracyjny", arial));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Data początku", arial));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Data końca", arial));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Stan początkowy licznika", arial));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Stan końcowy licznika", arial));
        table.addCell(cell);
 
         
        // write table row data
        for (Route report : fuelConsumptionReport) {
            table.addCell(String.valueOf(report.getOdometer()));
//            table.addCell(String.valueOf(report.getStartDate()));
//            table.addCell(String.valueOf(report.getEndDate()));
//            table.addCell(String.valueOf(report.getOdometerStart()));
//            table.addCell(String.valueOf(report.getOdometerEnd()));

        }
         
        doc.add(table);
         
    }
 
}