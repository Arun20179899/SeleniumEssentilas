package dropdown;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LatestDropDownLoopinUI {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//div[contains(@id,'divpaxinfo')]")).click();
		Thread.sleep(2000);
		// selecting adults
		for (int i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();

		}
		Thread.sleep(2000);
		// selecting child's
		int j = 1;
		while (j < 4) {
			driver.findElement(By.cssSelector("#hrefIncChd")).click();
			j++;

		}
		Thread.sleep(2000);
		// Selecting INFANT
		for (int k = 1; k < 3; k++) {
			driver.findElement(By.xpath("//span[@id='hrefIncInf']")).click();

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='buttonN']")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(@id,'divpaxinfo')]")).getText());
		driver.close();

	}

}
