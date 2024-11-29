package com.example.demo.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	public void genarate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception {
		Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("plan-data");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Citizen Name");
        headerRow.createCell(2).setCellValue("Plan Name");
        headerRow.createCell(3).setCellValue("Plan Status");
        headerRow.createCell(4).setCellValue("Plan Start Date");
        headerRow.createCell(5).setCellValue("Plan End Date");
        headerRow.createCell(6).setCellValue("Benefit Amt");

        

        int dataRowIndex = 1; // Start from row 1 to avoid overwriting the header
        for (CitizenPlan citizenPlan : records) {
            Row dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(citizenPlan.getCitizenId());
            dataRow.createCell(1).setCellValue(citizenPlan.getCitizenName());
            dataRow.createCell(2).setCellValue(citizenPlan.getPlanName());
            dataRow.createCell(3).setCellValue(citizenPlan.getPlanStatus());
            dataRow.createCell(4).setCellValue(citizenPlan.getPlanStartDate()+""); // Convert Date to String
            dataRow.createCell(5).setCellValue(citizenPlan.getPlanEndDate()+""); // Convert Date to String
           
            
            if(null!=citizenPlan.getBenifitAmt()) {
            	 dataRow.createCell(6).setCellValue(citizenPlan.getBenifitAmt());
            	
            }else {
            	dataRow.createCell(6).setCellValue("N/A");
			}
            dataRowIndex++;
        }
        
        FileOutputStream fos=new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close(); // Close the output stream

		
	}
}
