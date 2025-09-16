package com.TestNG_Demo.Day_1;

import org.testng.annotations.Test;

public class TestNG3Test {

	@Test(priority = -3)
	public void login_TC()
	{
		System.out.println("This is my Login TC");
	}
	
	
	@Test(priority = 5, enabled = false)
	public void changePasswpord_TC()
	{
		System.out.println("This is my Change Password TC");
		 int a=10/0;
		 System.out.println(a);
	}
	
	@Test(priority = 1)
	public void Logout_TC()
	{
		System.out.println("This is my Logout TC");
	}
	
}
