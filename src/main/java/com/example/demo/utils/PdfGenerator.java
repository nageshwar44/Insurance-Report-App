package com.example.demo.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	
	public void genarater(HttpServletResponse response, List<CitizenPlan> records,File f)throws Exception {
		Document  document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
		Paragraph paragraph = new Paragraph("Citizen Plans", font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		PdfPTable table=new PdfPTable(7);
		 table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,1.5f,1.5f});
	        table.setSpacingBefore(7);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benifit Amt");
		
		
		for (CitizenPlan citizenPlan : records) {
			table.addCell(String.valueOf(citizenPlan.getCitizenId()));
			table.addCell(citizenPlan.getCitizenName());
			table.addCell(citizenPlan.getPlanName());
			table.addCell(citizenPlan.getPlanStatus());
			table.addCell(citizenPlan.getPlanStartDate()+"");
			table.addCell(citizenPlan.getPlanEndDate()+"");
			table.addCell(String.valueOf(citizenPlan.getBenifitAmt()));
		}
		document.add(table);
		document.close();

		
	}

}
