package com.TestNG_Demo.Day_1;

import org.testng.annotations.Test;

public class TestNG1 {

	@Test(priority=1)
	public void login_TC() {
		System.out.println("Testcase 1");
	}
	
	@Test(priority=2)
	public void changePassword_TC() {
		System.out.println("Testcase 2");
	}
	
	@Test(priority=3)
	public void logout_TC() {
		System.out.println("Testcase 3");
	}
}
