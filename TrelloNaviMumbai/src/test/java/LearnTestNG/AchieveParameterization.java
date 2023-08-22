package LearnTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AchieveParameterization {
	WebDriver driver;
	@Parameters("browserName")
	@Test
public void launchBrowser(String broswserName) {
	if(broswserName.equals("chrome")) {
		driver=new ChromeDriver();
	}else if (broswserName.equals("edge")) {
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get("https://www.fb.com/");
	driver.manage().window().minimize();
	driver.quit();
}
}
