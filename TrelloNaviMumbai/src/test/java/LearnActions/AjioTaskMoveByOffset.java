package LearnActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AjioTaskMoveByOffset {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.ajio.com/shop/men");
	WebElement wishList = driver.findElement(By.xpath("//a[text()='MEN']/parent::li"));
	Actions actions=new Actions(driver);
	actions.moveToElement(wishList).pause(2000).moveToElement(wishList, 78, 0).pause(2000).moveToElement(wishList, 157, 0).pause(2000).moveToElement(wishList, 227, 0).pause(2000).moveToElement(wishList, 354, 0).build().perform();
}
}
