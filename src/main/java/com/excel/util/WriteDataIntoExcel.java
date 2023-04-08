package com.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {

	public static  void main(String args[]) throws IOException {
		
		
		//Create an object of File class to open xlsx file
        File srcFile =    new File("C:\\Users\\RAVI KUMAR\\Desktop\\New Microsoft Excel Worksheet 01.xlsx");
        System.out.println(srcFile.exists());
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(srcFile);
        
        //Creating workbook instance that refers to .xls file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        
        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        
        
        
      //Create a row object to retrieve row at index 3
        XSSFRow row2=sheet.createRow(1);
        
        //create a cell object to enter value in it using cell Index
        row2.createCell(0).setCellValue("Ravi");
        row2.createCell(1).setCellValue("Kumar");
        row2.createCell(2).setCellValue("Ravikumar@gmail.com");
        row2.createCell(3).setCellValue("Male");
        row2.createCell(4).setCellValue("9876543210");
        row2.createCell(5).setCellValue("R3 Icon Building, Shaikpet, Hyd");
        
        //write the data in excel using output stream
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\RAVI KUMAR\\Desktop\\New Microsoft Excel Worksheet 01.xlsx");
        workbook.write(outputStream);
        workbook.close();
	}
}
