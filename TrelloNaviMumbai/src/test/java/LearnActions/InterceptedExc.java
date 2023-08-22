package LearnActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InterceptedExc {
public static void main(String[] args) {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("incognito");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.amazon.com/");
	WebElement registry = driver.findElement(By.xpath("//a[text()='Registry']"));
	registry.click();
}
}
