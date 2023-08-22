package PopUps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NotificationPopup {
public static void main(String[] args) {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("incognito");
//	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("file:///C:/Users/nikam/OneDrive/Desktop/NotificatioPopup.html");
//	driver.switchTo().alert().accept();
//	WebElement defense = driver.findElement(By.linkText("Ministry of Defence"));
//	Actions actions=new Actions(driver);
//	actions.scrollToElement(defense).perform();
//	actions.click(defense).perform();
////	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().accept();
}
}
