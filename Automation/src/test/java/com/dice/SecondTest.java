package com.dice;

import org.testng.annotations.Test;
import com.dice.base.BaseTest;

public class SecondTest extends BaseTest{
	@Test
	public void secondTestMethod() {
		//Open linkedin.com
		driver.get("http://linkedin.com");
		System.out.println("Linkedin opened. Test Passed!");
	}

}
