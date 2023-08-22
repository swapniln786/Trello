package PopUps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prompt {
public static void main(String[] args) throws Throwable{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("file:///C:/Users/nikam/OneDrive/Desktop/PromptPopup.html");
	Thread.sleep(2000);
	driver.switchTo().alert().sendKeys("2134");
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
}
}
