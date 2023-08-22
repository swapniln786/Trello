package LearnTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginActitimeUsingParameterization {
	WebDriver driver;
	@BeforeMethod
	@Parameters("browserName")
	public void launchBrowser(String browserName) {
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
	}

	@Parameters({"url","username","password"})
@Test
	public void login(String url,String username,String password) {
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		driver.manage().window().minimize();
		driver.quit();
	}
}
