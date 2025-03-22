package com.myntra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingBagPage {
@FindBy(xpath = "//button[text()='REMOVE']")
private WebElement removeButton1;
@FindBy(xpath = "//div[text()='Remove 1 item']/../..//button[text()='REMOVE']")
private WebElement removeButton2;
@FindBy(className  = "notifyText")
private WebElement popup;
public ShoppingBagPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void removeButton1() {
	removeButton1.click();
}
public WebElement getPopup() {
	return popup;
}
public void removeButton2() {
	removeButton2.click();
}
}
