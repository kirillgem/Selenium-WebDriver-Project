package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class LogInPage extends BasePageObject <LogInPage> {
	private static final String URL = "https://www.dice.com/dashboard/login";
	
	private By emailField = By.xpath("//input[@id='email']");
	private By passwordlField = By.xpath("//input[@id='password']");
	private By sigInButton = By.xpath("//button[@type='submit']");
	private By errorMessage = By.xpath("//span[@data-automation-id='login-failure-help-message']");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	public void openLogInPage() {
		getPage(URL);
	}

	public void fillUpEmailAndPassword(String email, String password) {
		System.out.println("Filling up email and password");
		type(email, emailField);
		type(password, passwordlField);
	}
	
	public ProfilePage pushSignInButton() {	
		System.out.println("Clicking on Sign In Button");
		click(sigInButton);
		return new ProfilePage(driver);
	}

	public String getLogInErrorMessage() {
		waitForVisibilityOf(errorMessage, 5);
		return getText(errorMessage);
	}
	
}
