package com.excel.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Xls_Data_Reader {
	
	@DataProvider(name = "logindata")
    public String[][] getData() throws IOException {
        
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
        for(int i=0; i < noOfRows; i++) {
        	for (int j=0; j < noOfColumns; j++) {
        		
        		DataFormatter df = new DataFormatter();
        		data [i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
        	//	System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
        	}
        		
        }
        
        workbook.close();
        inputStream.close();
        
//        for (String [] dataArr : data) {
//        	System.out.println(Arrays.toString(dataArr));
//        }
        return data;
        
    }
}
