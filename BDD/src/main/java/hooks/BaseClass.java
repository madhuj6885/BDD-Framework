package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
	public static WebDriver driver;
	@Before(order = 1)
public void openBrowser() {
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.myntra.com/");
	System.out.println("openBrowser");
}
//	@Before(order=2)
//public void login() {
//	System.out.println("login");
//}
//	@After(order=2)
//public void logout() {
//	System.out.println("logout");
//}
	@After(order=1)
public void closeBrowser() {
	driver.manage().window().minimize();
	driver.quit();
	System.out.println("closeBrowser");
}
}
