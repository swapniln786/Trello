package LearnActions;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleDoodles {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	driver.get("https://www.google.com/doodles");
	Thread.sleep(5000);
	
	Actions actions=new Actions(driver);
	for(;;) {
		try {
			WebElement venezeula = driver.findElement(By.xpath("//a[text()='Venezuela Independence Day 2023']"));
			actions.click(venezeula).perform();
			break;
		} catch (NoSuchElementException e) {
			actions.scrollByAmount(0, 200).perform();
		}
	}
}
}
