package checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxDemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// isSelected() - checking if check box is selected or not
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());

		// deselect the check box
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		Thread.sleep(2000);

		// Validating through Assert Class - TestNG
		// assertFalse() and assertTrue()
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());

		// Find the number of check boxes are available in the page
		// for finding we need to inspect the element which is should match all the
		// check boxes

		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.quit();

	}

}
