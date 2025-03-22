package com.myntra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.BaseClass;

public class ProductDescriptionPage {
WebDriver driver=BaseClass.driver;
public WebElement getAddToBagIcon() {
	return addToBagIcon;
}
@FindBy(xpath = "//div[text()='ADD TO BAG']")
private WebElement addToBagIcon;
@FindBy(className = "notify-thumbnail-text")
private WebElement popup;
@FindBy(linkText = "GO TO BAG")
private WebElement goToBagLink;
public ProductDescriptionPage() {
	PageFactory.initElements(driver, this);
}
public void setAddToBag() {
	addToBagIcon.click();
}
public WebElement getPopup() {
	return popup;
}
public void goToBag() {
	goToBagLink.click();
}
}
