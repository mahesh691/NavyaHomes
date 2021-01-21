package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
public static String TestDATA_SHEET_PATH="E:\\JavaProgrammes\\Home\\mahesh\\src\\main\\java\\com\\Testdata\\Data_asign.xlsx";
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	public static Object[][] getTestData(String sheetname) throws IOException{
		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(TestDATA_SHEET_PATH);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum();i++) {

			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) {

				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				
				System.out.println(data[i][j]);
			}
		}
		
		return data;
		
	}
	
	
	
}
