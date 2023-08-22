package LearnTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningAnnotations {
	WebDriver driver;
	@BeforeMethod
public void login() throws InterruptedException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();
	Thread.sleep(5000);
}
	@Test
public void searchTask() throws InterruptedException {
	driver.findElement(By.id("taskSearchControl_field")).sendKeys("selenium");
	Thread.sleep(5000);
}
	@Test
	public void clickOnBigBangCompany() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Big Bang Company']")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("hideButton_panelContainer")).click();
		Thread.sleep(5000);
	}
	@AfterMethod
public void logout() {
	driver.findElement(By.id("logoutLink")).click();
	driver.manage().window().minimize();
	driver.quit();
}
}
