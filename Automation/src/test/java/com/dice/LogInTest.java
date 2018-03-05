package com.dice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.base.BaseTest;
import com.dice.pages.LogInPage;
import com.dice.pages.ProfilePage;

public class LogInTest extends BaseTest {
	
	@Test
	public void positiveLogInTest() {
		LogInPage logInPage = new LogInPage(driver);
		String expectedPageTitle = "Seeker Dashboard - Profile";
		String correctProfileName = "Kirill Bobrovskikh";
		
		//Open dice login page - https://www.dice.com/dashboard/login
		logInPage.openLogInPage();
		
		//Fill up email and password
		logInPage.fillUpEmailAndPassword("qwerty@gmail.com", "qwerty");
		
		//Push Sign In button and wait for page profile to load
		ProfilePage profilePage = logInPage.pushSignInButton();
		profilePage.pushCloseMsg();
		profilePage.waitForProfilePageToLoad();
			
		//Verifications
		//- Verify title of page is correct Seeker Dashboard - Profile
		System.out.println("Virifications");
		String actualTitle = profilePage.getTitle();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle),
				"Page title is not expected.\nExpected: " + expectedPageTitle + "\nActual " + actualTitle + ".");
		
		//- Verify correct name on profile page
		Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected.");
		
	}
	
	@Test
	public void negativeLogInTest() {
		String expectedErrorMessage = "Email and/or password incorrect.";
		LogInPage logInPage = new LogInPage(driver);
			
		//Open dice login page - https://www.dice.com/dashboard/login
		logInPage.openLogInPage();
		
		//Fill up email and password
		logInPage.fillUpEmailAndPassword("qwerty@gmail.com", "qwerty");
		
		//Push Sign In button and wait for page profile to load
		logInPage.pushSignInButton();
		
		String errorMessage = logInPage.getLogInErrorMessage();
		
		Assert.assertTrue(errorMessage.contains(expectedErrorMessage),
				"Error message is not expected. Expected: " + expectedErrorMessage + "\nActual: " + errorMessage);
		
	}

}
