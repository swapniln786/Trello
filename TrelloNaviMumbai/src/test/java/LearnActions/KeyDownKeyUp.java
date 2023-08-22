package LearnActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyDownKeyUp {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	Actions actions=new Actions(driver);
	actions.keyDown(driver.switchTo().activeElement(), Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT).sendKeys("e")
.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").build().perform();
	driver.findElement(By.xpath("//div[@class='_9lsa']")).click();
}
}
