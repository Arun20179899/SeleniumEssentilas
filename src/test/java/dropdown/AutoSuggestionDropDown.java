package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestionDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Type to Select']")).sendKeys("Ban");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class*='ui-corner-all'] a.ui-corner-all"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Bangladesh")) {
				option.click();
			}
		}

		driver.close();

	}

}
