package com.TestNG_Demo.Day_1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG4Test {

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method executing..");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method executing..");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test executing..");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test executing..");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite executing..");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite executing..");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test1 Method executing..");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Test2 Method executing..");
	}
	
	
	@Test
	public void test3()
	{
		System.out.println("Test3 Method executing..");
	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class executing..");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class executing..");
	}
}
