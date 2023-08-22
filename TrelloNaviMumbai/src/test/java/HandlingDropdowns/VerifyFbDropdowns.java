package HandlingDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyFbDropdowns {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		List<WebElement> allDropdowns = driver.findElements(By.tagName("select"));
		for (WebElement dropdown : allDropdowns) {
			if(dropdown.isDisplayed()) {
				Select selectDropdown = new Select(dropdown);
				List<WebElement> allOptions = selectDropdown.getOptions();
				for (WebElement option : allOptions) {
					selectDropdown.selectByVisibleText(option.getText());
					if(option.isEnabled()) {
						System.out.println(option.getText()+" is selected");
					}else{
						System.out.println(option.getText()+" is not selected");
					}
				}
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
