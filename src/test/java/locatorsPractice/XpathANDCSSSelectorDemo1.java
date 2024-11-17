package locatorsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class XpathANDCSSSelectorDemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String name = "Arun";
		String actPassword = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name*=input]")).sendKeys(actPassword);
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		Thread.sleep(2000);
		driver.close();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[class*='reset']")).click();
		String passwordText = driver.findElement(By.cssSelector(".infoMsg")).getText();
//		Please use temporary password 'rahulshettyacademy' to Login.
//		String[] passwordArray = passwordText.split("'");
//		index[0th] - Please use temporary password 
//		index[1st] - 'rahulshettyacademy' to Login.
//		String password = passwordArray[1].split("'")[0];
		String password = passwordText.split("'")[1].split("'")[0];
		return password;

	}

}
