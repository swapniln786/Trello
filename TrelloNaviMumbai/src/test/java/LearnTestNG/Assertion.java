package LearnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertion {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.instagram.com/");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		//hard assert
		//in this use testng class directly
		//	Assert.assertTrue(loginButton.isEnabled(), "Login is in disabled state");
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(loginButton.isEnabled(), "Login is in disabled state");
		driver.manage().window().minimize();
		driver.quit();
		//in softassert this is mandatory at end of script
		softAssert.assertAll();
	}
}
