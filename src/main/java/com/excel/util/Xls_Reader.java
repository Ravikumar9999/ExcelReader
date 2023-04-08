package com.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

	public static void main(String[] args) throws IOException {
		
	        
	        //Create an object of File class to open xlsx file
	        File excelFile =    new File("C:\\Users\\RAVI KUMAR\\eclipse-workspace\\ExcelReader\\src\\main\\java\\com\\excel\\util\\New Microsoft Excel Worksheet 01.xlsx");
	        System.out.println(excelFile.exists());
	        
	        //Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(excelFile);
	        
	        //Creating workbook instance that refers to .xls file
	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        
	        //Creating a Sheet object using the sheet Name
	        XSSFSheet sheet = workbook.getSheet("Sheet1");
	        
	        int noOfRows = sheet.getPhysicalNumberOfRows();
	        int noOfColumns = sheet.getRow(0).getLastCellNum();
	        

	        String [][] data = new String [noOfRows][noOfColumns];
	        for(int i=1; i < noOfRows; i++) {
	        	for (int j=0; j < noOfColumns; j++) {
	        	System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
	        	}
	        		
	        }
	        
}
}