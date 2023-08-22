package PopUps;

import java.time.Duration;
import java.util.Set;

import javax.naming.directory.DirContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlePopUps {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		//open chrome in incognito
		options.addArguments("incognito");
		//handle notification popup
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://pib.gov.in/");
		Thread.sleep(Duration.ofSeconds(2));
		String pibWid = driver.getWindowHandle();
		//handle alert popup
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		//find defence element
		WebElement defence = driver.findElement(By.linkText("Ministry of Defence"));
		Actions actions=new Actions(driver);
		actions.scrollToElement(defence);
		wait.until(ExpectedConditions.elementToBeClickable(defence)).click();
		//handle confirmation popup
		//	driver.switchTo().alert().dismiss();
		System.out.println(wait.until(ExpectedConditions.alertIsPresent()).getText());
		driver.switchTo().alert().accept();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowID : windowHandles) {
			String windowUrl = driver.switchTo().window(windowID).getCurrentUrl();
			if(windowUrl.contains("https://mod.gov.in/")) {
				driver.close();
			}
		}
		driver.switchTo().window(pibWid).manage().window().minimize();
		driver.quit();
	}
}
