package com.TestNG_Demo.Day_1;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNG5Test {

	
	@Parameters({"browsername"})
	@Test(priority = 1)
	public void login_TC(@Optional("chrome")String name)
	{
		System.out.println("This is my Login TC");
		System.out.println(name+" browser is startred");
	}
}
