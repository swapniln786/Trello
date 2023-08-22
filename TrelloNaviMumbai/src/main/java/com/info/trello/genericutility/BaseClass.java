package com.info.trello.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fileUtils=new FileUtility();
	public WebDriverUtility webDriverUtils=new WebDriverUtility();
	public ExcelUtility excelUtils=new ExcelUtility();
	@BeforeMethod
public void configBeforeMethod() throws IOException {
	String browserName = fileUtils.readCommonData("browser");
	if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(browserName.equals("edge")) {
		driver=new EdgeDriver();
	}else if(browserName.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.get(fileUtils.readCommonData("url"));
}
	@AfterMethod
public void configAfterMethod() {
	driver.manage().window().minimize();
	driver.quit();
}
}
