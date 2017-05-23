package com.cfm.tiri.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cfm.tiri.mapping.RouteReport;
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
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
    	List<RouteReport> fuelConsumptionReport =   (List<RouteReport>) model.get("fuelconsumptionreport");
 //      	if (fuelConsumptionReport.isEmpty()) {    	System.out.println("empty");}else{System.out.println("not empty");}
        
        // fonts
        Font smallfont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED,7);
        Font arial = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED,11);
        Font arialblack = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED,11);
        smallfont.setColor(BaseColor.WHITE);
        arial.setColor(BaseColor.WHITE);
        arialblack.setColor(BaseColor.BLACK);
        
        //formats
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df2 = new DecimalFormat(".##"); 
    	
    	
        doc.add(new Paragraph("Raport podsumowujący", arialblack));
         
        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {0.9f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.1f});
        table.setSpacingBefore(10);
        

        
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
        
        cell.setPhrase(new Phrase("Dystans", arial));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Średnie zyżycie na 100 km", arial));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Średnie zyżycie na 100 km według normy", arial));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Zaoszczędzone paliwo", arial));
        table.addCell(cell);
         
        // write table row data
        

        for (RouteReport report : fuelConsumptionReport) {

            table.addCell(String.valueOf(report.getRegistrationNumber()));
            table.addCell(String.valueOf(formatter.format(report.getStartDate())));
            table.addCell(String.valueOf(formatter.format(report.getEndDate())));
            table.addCell(String.valueOf(report.getOdometerStart()));
            table.addCell(String.valueOf(report.getOdometerEnd()));
            table.addCell(String.valueOf(report.getDistance()));
            table.addCell(String.valueOf(df2.format(report.getAverageConsumption())));
            table.addCell(String.valueOf(df2.format(report.getAverageModelConsumption())));
            table.addCell(String.valueOf(report.getFuelSaved()));
            table.completeRow();
        }
         
        doc.add(table);
        
         
    }
 
}