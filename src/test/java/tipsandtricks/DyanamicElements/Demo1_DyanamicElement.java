package tipsandtricks.DyanamicElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1_DyanamicElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Number of rows: " + rows.size());
		for (int r = 1; r <= rows.size(); r++) {
			WebElement name = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + r + "]//td[1]"));
//			System.out.println(name.getText());
//			Thread.sleep(5000);
			if (name.getText().equals("Chrome")) {
				String cpuLoad = driver
						.findElement(By
								.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]"))
						.getText();
				String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();

				if (value.contains(cpuLoad)) {
					System.out.println("CPU load of Chrome is equal");
				} else {
					System.out.println("CPU load of Chrome is not equal");
				}
			}

		}

		driver.close();

	}

}
