package com.TestNG_Demo.Day_2;

import org.testng.annotations.Test;

public class TestNGGroupsDemo {

	@Test(groups= {"sanity"})
	public void testscript_1()
	{
		System.out.println("testcase 1 executed - sanity");
	}
	
	@Test(groups = {"regression","smoke"})
	public void testscript_2()
	{
		System.out.println("testcase 2 executed - smoke + regeression");
	}
	
	@Test(groups= {"smoke"})
	public void testscript_3()
	{
		System.out.println("testcase 3 executed - smoke");
	}
	
	@Test(groups = {"smoke","sanity"})
	public void testscript_4()
	{
		System.out.println("testcase 4 executed - smoke + sanity");
	}
}
