package com.TestNG_Demo.Day_2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNG_DataProvider {

	@DataProvider(name="userdetails")
	public Object[][] MydataProvider(){
		String[][] a = new String[4][4];
		a[0][0]="aana";
		a[0][1]="a@gmail.com";
		a[0][2]="28";
		a[0][3]="developer";
		
		a[1][0]="john";
		a[1][1]="j@gmail.com";
		a[1][2]="34";
		a[1][3]="QA";
		
		a[2][0]="banu";
		a[2][1]="b@gmail.com";
		a[2][2]="54";
		a[2][3]="lead";
		
		a[3][0]="tom";
		a[3][1]="t@gmail.com";
		a[3][2]="45";
		a[3][3]="manager";
		
		return a;
	}
	
	@Test(dataProvider="userdetails")
	public void user_details(String name, String email, String age, String role) {
		System.out.println("testscript");
		System.out.println("name= "+name+" email= "+email+" age= "+age+" role= "+role);
		System.out.println("testcase ended");
		
		
	}
}
