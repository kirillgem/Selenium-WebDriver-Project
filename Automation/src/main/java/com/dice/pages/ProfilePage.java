package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {
	private By editProfileButton = By.xpath("//button[@id='editProfile']");
	private By advanceSearchButton = By.xpath("//a[@class='dice-btn-link']");
	private By profileContactNameText = By.xpath("//h1[@class='profile-contact-name']");
	private By msgButton = By.xpath("//button[@id='searchablebtndashboard']");
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void waitForProfilePageToLoad() {
		System.out.println("Waiting For Profile Page To Load");
		waitForVisibilityOf(editProfileButton);
		waitForVisibilityOf(advanceSearchButton, 10);
	}
	
	public boolean isCorrectProfileLoaded(String correctProfileName) {
		if(getText(profileContactNameText).equals(correctProfileName))
		return true;
		
		return false;
	}
	
	public ProfilePage pushCloseMsg() {
		System.out.println("Clicking on Close the Message");
		waitForVisibilityOf(msgButton, 5);
		try{
			driver.switchTo().alert(); 
		}
		catch (NoAlertPresentException e){
		}
		
		return new ProfilePage(driver);
	}
}
