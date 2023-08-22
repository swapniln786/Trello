package LearnActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraTask {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		List<WebElement> allLinks = driver.findElements(By.className("desktop-navContent"));
		Actions actions=new Actions(driver);
		for (WebElement singleLink : allLinks) {
			actions.moveToElement(singleLink).pause(5000).perform();	
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
