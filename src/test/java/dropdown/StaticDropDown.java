package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		for static drop down always use select tag
		WebElement dropdown=driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		Select dropdownoption = new Select(dropdown);
//		Access through index
		dropdownoption.selectByIndex(2);
		System.out.println(dropdownoption.getFirstSelectedOption().getText());
//		through visible text
		dropdownoption.selectByVisibleText("INR");
		System.out.println(dropdownoption.getFirstSelectedOption().getText());
//		through value
		dropdownoption.selectByValue("USD");
		System.out.println(dropdownoption.getFirstSelectedOption().getText());
		driver.close();
	}

}
