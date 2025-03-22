package com.myntra.generic;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.BaseClass;

public class WebdriverUtils {
	WebDriver driver=BaseClass.driver;
	/**
	 * It is a generic method to check the partially expected title is present in the actual Title
	 * @param expectedTitle
	 */
public void verifyTitle(String expectedTitle) {
	String actualTitle = driver.getTitle();
	boolean res = actualTitle.contains(expectedTitle);
	Assert.assertTrue(res);
}
}
