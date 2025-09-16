package com.TestNG_Demo.Day_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider_UsingExcel {

	@DataProvider(name="logindetails")
	public static Object[][] MyExcelDataProvider() throws IOException{
		String dirPath = System.getProperty("user.dir");
		File file = new File(dirPath + "\\src\\test\\resources\\Login_details.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count : " + rowCount);
	    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	    System.out.println("Column count : " + colCount);
	    
		Object[][] data = new Object[rowCount - 1][colCount];
		
		for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
		wb.close();
		fis.close();
		return data;
	}
	
	@Test(dataProvider="logindetails")
	public void login_details(String username, String password) {
		System.out.println("TestSCript");
		System.out.println("User name = " + username +" password= " + password);
		System.out.println("Testcase ended");
	}
	
}
