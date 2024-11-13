package tipsandtricks.ListBoxSorted;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateValueListBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
//		WebElement listboxelement = driver.findElement(By.xpath("//select[@id='colors']"));
		WebElement listboxelement = driver.findElement(By.xpath("//select[@id='animals']"));
		Select listbox = new Select(listboxelement);
		Set<String> uniqueValues = new HashSet<String>();
		boolean flag = false;
		for (WebElement option : listbox.getOptions()) {
			String optionText = option.getText();
			if (!uniqueValues.add(optionText)) {
				System.out.println("Duplicate values found " + optionText);
				flag = true;
			}

		}
		if (!flag) {
			System.out.println("Duplicate values not found");
		}

		driver.close();
	}

}
