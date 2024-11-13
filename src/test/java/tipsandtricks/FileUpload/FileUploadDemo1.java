package tipsandtricks.FileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo1 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.foundit.in/upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();
		Thread.sleep(3000);
//		1) upload file through send keys if the HTML have file tag element
//		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\lenovo\\Documents\\Hello.txt");

//		2)Robot Class
//		driver.findElement(By.xpath("//input[@id='file-upload']")).click();
//		Exception in thread "main" org.openqa.selenium.InvalidArgumentException: invalid argument  - because it is a Input tag we cannot click action on input tag

//		We can perform click action on input tag through JavaScriptExecutor Class
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='file-upload']")));

//		1)copy the file path into clip board(Ctrl+C)
		String filePath = "C:\\Users\\lenovo\\Documents\\Hello.txt";
		StringSelection filePathSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

//		2) (Ctrl+V)
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL); // rb.keyPress(KeyEvent.VK_META); -- for mac user
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000);
//		3) click on return/enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.close();

	}

}
