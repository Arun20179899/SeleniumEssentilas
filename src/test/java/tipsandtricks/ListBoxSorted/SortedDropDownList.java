package tipsandtricks.ListBoxSorted;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortedDropDownList {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		// sorted list
//		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		// unsorted list
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='colors']")));

		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		List<WebElement> options = dropdown.getOptions();

		for (WebElement option : options) {
			originalList.add(option.getText());

			tempList.add(option.getText());

		}
		System.out.println("Before sorting.......");
		System.out.println("Original List " + originalList);
		System.out.println("temp List" + tempList);

		// using below built-in function for sorting elements of collections
		Collections.sort(tempList);

		System.out.println("After sorting.......");
		System.out.println("Original List " + originalList);
		System.out.println("temp List" + tempList);

		if (originalList.equals(tempList)) {
			System.out.println("list box is sorted");
		} else {
			System.out.println("List box is not sorted");
		}
		driver.close();
	}

}
