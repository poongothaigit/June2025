package com.TestNG_Demo.Day_1;

import org.testng.annotations.Test;

public class TestNGTest {

	@Test(priority = 1)
	public void login_TC()
	{
		System.out.println("This is my Login TC");
		// throw new SkipException("Any Reson");
		// int a=10/0;
		// System.out.println(a);
	}
	
	
	@Test(priority = 2,dependsOnMethods = {"login_TC"})
	public void changePasswpord_TC()
	{
		System.out.println("This is my Change Password TC");
		 int a=10/0;
		 System.out.println(a);
	}
	
	@Test(priority = 3,dependsOnMethods = {"login_TC","changePasswpord_TC"})
	public void Logout_TC()
	{
		System.out.println("This is my Logout TC");
	}
	
	
}
