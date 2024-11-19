package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);

		/*
		 * // 1st Method thru index
		 * driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("(//a[text()=' Chennai (MAA)'])[2]")).click();
		 */

		// if the manager not allowed to use index than we will use this below second
		// 2nd Method thru Parent-child relationship locators
		String from = driver
				.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='IXG']"))
				.getText();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='IXG']"))
				.click();
		Thread.sleep(2000);
		String to = driver
				.findElement(
						By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD'] "))
				.getText();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD'] ")).click();
		Thread.sleep(2000);
		System.out.println("City Selected FROM: " + from + " City Selected TO: " + to);

		driver.close();

	}

}
