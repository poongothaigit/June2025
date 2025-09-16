package com.TestNG_Demo.Day_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingDemo {

	@Test
	public void firBaseTest() throws InterruptedException {
		String expectedTitle="Selenium";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(4000);
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		driver.close();
	}
	
	@Test
	public void demoQATest() throws InterruptedException
	{
		String expectedTitle="DEMOQA";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		Thread.sleep(4000);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
		driver.close();
	}
	
	@Test
	public void googleTest() throws InterruptedException
	{
		String expectedTitle="Google";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		Thread.sleep(4000);
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		driver.close();
	}
}
