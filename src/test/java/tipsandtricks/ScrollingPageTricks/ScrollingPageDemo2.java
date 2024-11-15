package tipsandtricks.ScrollingPageTricks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollingPageDemo2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://booksbykilo.in/new-books");
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

//		1) action failed
//		WebElement book = driver.findElement(By.xpath("//h3[normalize-space()='The Candy House']"));
//		act.scrollToElement(book);

//		2)Failed
//		WebElement book = driver.findElement(By.xpath("//h3[normalize-space()='The Candy House']"));
//		js.executeScript("arguments[0].scrollIntView();", book);

//		3)Logic

		String bookName = "The Candy House";
		boolean found = false;
		while (!found) {
			List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
//			Thread.sleep(3000);

			for (WebElement book : books) {
				if (book.getText().equals(bookName)) {
					System.out.println("Book found !");
					found = true;
					break;
				}
			}
//			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			Thread.sleep(2000);

		}
		driver.quit();

	}

}
