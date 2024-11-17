package locatorsPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathANDCSSSelectorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Arun");
		driver.findElement(By.xpath("//input[contains(@name,'input')]")).sendKeys("1234");
		driver.findElement(By.xpath("//form/button")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form/input[1]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("ABS@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("ArunTest12@gmail.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("6393629368");
		driver.findElement(By.cssSelector("button[class*='reset']")).click();
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		driver.findElement(By.xpath("//form/div/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Arun");
		driver.findElement(By.cssSelector("input[name*='input']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[contains(@id,'chkboxOne')]")).click();
		driver.findElement(By.cssSelector("input[id*='chkboxTwo']")).click();
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
