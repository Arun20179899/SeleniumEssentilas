package tipsandtricks.AlertsTricks;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Thread.sleep(3000);

//		1)switchTo()
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		driver.close();

//		2)Explicit Wait
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
//		alert.accept();

//		3)JavaScriptExecutor
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.alert = function{};");
			driver.close();
		} catch (Exception e) {
			System.out.println("UnhandledAlertException");
		}
		driver.close();

	}

}
