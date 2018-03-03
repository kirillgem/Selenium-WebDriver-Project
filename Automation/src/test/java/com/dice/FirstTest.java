package com.dice;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class FirstTest {
	
	@Test
	public void firstTestMethod() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
		//System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver(); 
		WebDriver driver = new ChromeDriver(); 
		
		//Open dice.com
		driver.get("http://dice.com");
		System.out.println("Dice opened. Test Passed!");
		
		driver.quit();
	}

}
