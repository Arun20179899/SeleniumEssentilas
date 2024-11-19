package globalQA;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		String username = "admin";
		String password = "admin5!";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://158.69.124.141/XYZDemo2/default.aspx");
		Thread.sleep(1000);
		Select option = new Select(driver.findElement(By.cssSelector("select[id*='CboFacilities']")));
		Thread.sleep(1000);
		option.selectByVisibleText("Test XYZ Storage Beechgrove");
		driver.findElement(By.xpath("//input[contains(@id,'txtUserId')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(password);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(5000);
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.out.println("No Alert found");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='PanelModal']//div[@class='modalPopupButtWrapper']/img")).click();
//		driver.switchTo().frame(element);
//		driver.findElement(By.xpath("//div[@class='modalPopup']/div/img")).click();
//		
//		driver.close();
	}

}
