package HandlingDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2 {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	driver.navigate().to("https://www.facebook.com/signup");
	List<WebElement> allDropdowns = driver.findElements(By.tagName("select"));
	System.out.println(allDropdowns.size());
	for (WebElement dropdown : allDropdowns) {
		if(dropdown.isEnabled()) {
			System.out.println("Boolean True - Visible");
			Select visibleDropdown=new Select(dropdown);
			if(visibleDropdown.isMultiple()) {
				System.out.println(dropdown.getAttribute("title")+" Boolean True - Multiselect");
			}else {
				System.out.println(dropdown.getAttribute("title")+" Boolean False - SingleSelect");
			}
		}else {
			System.out.println("Boolean False - Not Visible");
		}
	}
}
}
