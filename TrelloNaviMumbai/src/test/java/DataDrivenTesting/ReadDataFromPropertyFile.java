package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadDataFromPropertyFile {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/actitimedata.properties");
		Properties prpt=new Properties();
		prpt.load(fis);
		String browsername = prpt.getProperty("browser");
		if(browsername.equals("chrome")) {
			driver=new ChromeDriver();


		}else if(browsername.equals("edge")){
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prpt.getProperty("url"));
		driver.findElement(By.id("email")).sendKeys(prpt.getProperty("username"));
		driver.findElement(By.id("pass")).sendKeys(prpt.getProperty("password"));
	}
}
