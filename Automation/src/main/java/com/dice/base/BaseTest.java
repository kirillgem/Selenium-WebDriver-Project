package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	protected void methodSetUp() {
		System.out.println("Method set up");
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		driver = new ChromeDriver(); 
		//System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver(); 
	}
	
	@AfterMethod
	protected void methodTearDown() {
		System.out.println("Method tear down");
		driver.quit();
	}

}
