package tipsandtricks.ScrollingPageTricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollingPageDemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://booksbykilo.in/new-books");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Failed
		/*
		 * List<WebElement> books=
		 * driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		 * System.out.println("count of the books "+books.size());
		 */

		// Failed
		/*
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 * List<WebElement> books=
		 * driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		 * System.out.println("count of the books "+books.size());
		 */

		// Logic
		int previuoscount = 0;
		int currentcount = 0;

		while (true) {
			List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			currentcount = books.size();

			if (currentcount == previuoscount) {
				break;
			}
			previuoscount = currentcount;
//			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();

			Thread.sleep(3000);
		}
		System.out.println("Total number of count " + previuoscount);
		driver.close();

	}

}
