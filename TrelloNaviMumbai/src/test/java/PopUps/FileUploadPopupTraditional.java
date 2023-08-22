package PopUps;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import javax.xml.crypto.KeySelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPopupTraditional {
	public static void main(String[] args) throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://sandbox.abdm.gov.in/applications/cowin/Home/cowin_signup_form");
	WebElement fileUpload = driver.findElement(By.id("docfile"));
	Actions actions=new Actions(driver);
	actions.scrollToElement(fileUpload).pause(2000).click(fileUpload).build().perform();
	Thread.sleep(4000);
	String fileAddress ="C:\\Users\\nikam\\Downloads\\demo.jpeg";
	StringSelection sampleFile = new StringSelection(fileAddress);
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Clipboard clip = toolkit.getSystemClipboard();
	clip.setContents(sampleFile,null);
	Robot robot=new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(2000);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(2000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}
}