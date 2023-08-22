package LearnTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UseOptionalAnnotation {
	WebDriver driver;
	@Test()
	@Parameters("browserName")
public void testCase( @Optional("edge") String browserName) {
	if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(browserName.equals("edge")) {
		driver=new EdgeDriver();
	}
}
}
