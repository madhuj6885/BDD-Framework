package stepdefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.myntra.generic.WebdriverUtils;
import com.myntra.pom.HomePage;
import com.myntra.pom.ProductDescriptionPage;
import com.myntra.pom.ProductListPage;
import com.myntra.pom.ShoppingBagPage;

import hooks.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Myntra {
	WebDriver driver=BaseClass.driver;
	static WebdriverUtils w;
	static ProductDescriptionPage p;
	static ShoppingBagPage s;
@Given("User should be present in myntra home page")
public void user_should_be_present_in_myntra_home_page() {
	w=new WebdriverUtils();
	w.verifyTitle("Online Shopping");
}

@When("User search for {string}")
public void user_search_for(String item) {
	HomePage h=new HomePage(driver);
	h.searchItem(item);
}

@Then("{string} page should be displayed")
public void page_should_be_displayed(String item) {
	w.verifyTitle(item);
}

@When("He selects the first product")
public void he_selects_the_first_product() {
	ProductListPage p=new ProductListPage(driver);
	p.clickFirstProduct();
}

@Then("Product details page should be displayed")
public void product_details_page_should_be_displayed() {
	Set<String> allWid = driver.getWindowHandles();
	for (String wid : allWid) {
		driver.switchTo().window(wid);
	}
	p=new ProductDescriptionPage();
	boolean res = p.getAddToBagIcon().isDisplayed();
	Assert.assertTrue(res,"Product description is not displayed");
}

@When("he selects the size as {string}")
public void he_selects_the_size_as(String size) {
	driver.findElement(By.xpath("//p[@class='size-buttons-unified-size' and text()='"+size+"']")).click();
}
@And("he clicks on add to bag")
public void he_clicks_on_add_to_bag() {
	p.setAddToBag();
}

@Then("Added to bag popup should be displayed")
public void added_to_bag_popup_should_be_displayed() throws InterruptedException {
	Thread.sleep(2000);
	String text = p.getPopup().getText();
	System.out.println(text);
	boolean res = p.getPopup().isDisplayed();
	Assert.assertTrue(res);
}

@When("he clicks on the bag")
public void he_clicks_on_the_bag() {
	p.goToBag();
}

@Then("Shopping bag page should be displayed")
public void shopping_bag_page_should_be_displayed() {
	w.verifyTitle("SHOPPING BAG");
}

@When("he clicks on remove option")
public void he_clicks_on_remove_option() {
	s=new ShoppingBagPage(driver);
	s.removeButton1();
}

@And("click on remove button")
public void click_on_remove_button() {
	s.removeButton2();
}

@Then("Item has been removed should be displayed")
public void item_has_been_removed_should_be_displayed() throws InterruptedException {
	Thread.sleep(2000);
	String text2 = s.getPopup().getText();
	boolean res = s.getPopup().isDisplayed();
	Assert.assertTrue(res);
	System.out.println(text2);
}

}
