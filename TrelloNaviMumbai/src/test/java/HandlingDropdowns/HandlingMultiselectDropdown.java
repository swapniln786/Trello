package HandlingDropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingMultiselectDropdown {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///C:/Users/nikam/OneDrive/Desktop/Dropdown123.html");
	WebElement dropdown = driver.findElement(By.id("cars"));
	Select dropdownSelect=new Select(dropdown);
	if(dropdownSelect.isMultiple()) {
		System.out.println("It is MultiSelect");
	}else{
		System.out.println("It is SingleSelect");
	}
	Thread.sleep(3000);
	//select creta,skoda and tucson
	dropdownSelect.selectByValue("1");
	dropdownSelect.selectByValue("2");
	dropdownSelect.selectByValue("4");
	//print all selected options
	List<WebElement> allSelectedOptions = dropdownSelect.getAllSelectedOptions();
	for (WebElement singleOption : allSelectedOptions) {
		System.out.println(singleOption.getText());
	}
	Thread.sleep(3000);
	//deselect skoda
	dropdownSelect.deselectByValue("2");
	Thread.sleep(3000);
	//deselect all
	dropdownSelect.deselectAll();
}
}
