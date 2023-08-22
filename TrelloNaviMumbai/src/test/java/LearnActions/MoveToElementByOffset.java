package LearnActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementByOffset {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.ajio.com/shop/men");
		WebElement wishList = driver.findElement(By.xpath("//img[@alt='wishlistIcon']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(wishList).pause(2000).moveToElement(wishList, 54, 0).build().perform();
	}
}
