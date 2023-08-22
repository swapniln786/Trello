package PopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://sandbox.abdm.gov.in/applications/cowin/Home/cowin_signup_form");
	WebElement fileUpload = driver.findElement(By.id("docfile"));
	fileUpload.sendKeys("C:\\Users\\nikam\\Downloads/A.jpeg");
}

}
