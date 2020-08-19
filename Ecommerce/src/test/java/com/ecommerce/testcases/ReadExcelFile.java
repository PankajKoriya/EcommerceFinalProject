package com.ecommerce.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	Workbook wb;
	
	public void readExcel(String fileName, int sheetNumber) throws IOException
	{
		File file = new File(System.getProperty("user.dir") + "/ExcelDataProvider/" + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		String fileExtension = fileName.substring(fileName.indexOf("."));
		
		if(fileExtension.equals(".xlsx"))
		{
			wb = new XSSFWorkbook(fis);
			
			Sheet sh = wb.getSheetAt(sheetNumber);
			
			int rowCount = sh.getLastRowNum()+1;
			
			int colCount = sh.getRow(0).getLastCellNum();
		
			for(int i=0; i<rowCount; i++)
			{
				for(int j=0; j<colCount; j++)
				{
					System.out.print(sh.getRow(i).getCell(j).getStringCellValue() + " || ");
				}
				System.out.println();
			}
		}
		else if(fileExtension.equals(".xls"))
		{
			wb = new HSSFWorkbook(fis);
			
			Sheet sh = wb.getSheetAt(sheetNumber);
			
			int rowCount = sh.getLastRowNum()+1;
			
			int colCount = sh.getRow(0).getLastCellNum();
		
			for(int i=0; i<rowCount; i++)
			{
				for(int j=0; j<colCount; j++)
				{
					System.out.print(sh.getRow(i).getCell(j).getStringCellValue() + " || ");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		ReadExcelFile ref = new ReadExcelFile();
		ref.readExcel("file_example_XLS_10.xls", 0);
	}
}
