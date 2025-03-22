package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Actitime {
	WebDriver driver;
	@Given("User should trigger {string}")
	public void user_should_trigger(String url) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}
	@When("User enter {string} as username")
	public void user_enter_as_username(String un) {
		driver.findElement(By.id("username")).sendKeys(un);
	}
	@And("He enters {string} as password")
	public void he_enters_as_password(String pwd) {
		driver.findElement(By.name("pwd")).sendKeys(pwd);
	}
	@And("He clicks on login button")
	public void he_clicks_on_login_button() {
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@Then("Home Page should be displayed")
	public void home_page_should_be_displayed() {
		System.out.println(driver.getTitle());
	}

}
