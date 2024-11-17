package locatorsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FollowingSiblingANDParentSibling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(
				driver.findElement(By.xpath("//body/header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver
				.findElement(By
						.xpath("//body/header/div/button[1]/parent::div/parent::header/a/parent::header/div/button[2]"))
				.getText());
		System.out.println(driver.findElement(By.xpath("//body/header/div/button[1]/parent::div/button[2]")).getText());
		driver.close();

	}

}
