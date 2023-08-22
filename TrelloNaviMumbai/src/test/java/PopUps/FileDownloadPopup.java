package PopUps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileDownloadPopup {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(5);
		Actions actions=new Actions(driver);
		actions.scrollByAmount(0, 1000).perform();
		WebElement downloads = driver.findElement(By.linkText("4.11.0"));
		downloads.click();
		Thread.sleep(2000);
		driver.get("chrome://downloads/");
		WebElement host1 = driver.findElement(By.tagName("downloads-manager"));
		SearchContext shadowRoot1 = host1.getShadowRoot();
		WebElement host2 = shadowRoot1.findElement(By.cssSelector("downloads-item[id='frb0']"));
		SearchContext shadowRoot2 = host2.getShadowRoot();
		WebElement interactiveEle = shadowRoot2.findElement(By.cssSelector("cr-button[focus-type='save']"));
		interactiveEle.click();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
