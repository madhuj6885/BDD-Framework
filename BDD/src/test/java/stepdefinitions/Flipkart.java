package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flipkart {
	WebDriver driver;
@Given("User should be present in flipkart")
public void user_should_be_present_in_flipkart() {
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://flipkart.com");}
@When("He searches for iphone")
public void he_searches_for_iphone() {
	driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);}
@Then("iphone page should be displayed")
public void iphone_page_should_be_displayed() {
 System.out.println(driver.getTitle());
}

}
