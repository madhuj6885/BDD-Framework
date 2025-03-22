package basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Myntra {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");Thread.sleep(2000);
		driver.findElement(By.className("desktop-searchBar")).sendKeys("Puma Shoes for men"+Keys.ENTER);Thread.sleep(2000);
		driver.findElement(By.className("product-imageSliderContainer")).click();Thread.sleep(2000);
		Set<String> allWid = driver.getWindowHandles();
		for (String wid : allWid) {
			driver.switchTo().window(wid);
		}Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='size-buttons-unified-size' and text()='8']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();Thread.sleep(2000);
		String text = driver.findElement(By.className("notify-thumbnail-text")).getText();Thread.sleep(2000);
		System.out.println(text);
		driver.findElement(By.linkText("GO TO BAG")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='REMOVE']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Remove 1 item']/../..//button[text()='REMOVE']")).click();Thread.sleep(2000);
		String text2 = driver.findElement(By.className("notifyText")).getText();Thread.sleep(2000);
		System.out.println(text2);
		driver.quit();
	}
}
