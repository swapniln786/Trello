package com.info.trello.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class will  be enhanced usage of WebDriver for the script 
 * @author Swapnil
 *
 */
public class WebDriverUtility {
	/**
	 * This method wil. supply the waiting time for  every invocation of findElement() or findElements()
	 * @author Swapnil
	 * @param driver
	 */
public void implicitWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
public boolean waitForCompleteTitle(WebDriver driver,String expectedTitle) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	boolean validate = wait.until(ExpectedConditions.titleIs(expectedTitle));
	return validate;
}
public WebElement clickableElement(WebDriver driver,WebElement targetEle) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement clickableEle = wait.until(ExpectedConditions.elementToBeClickable(targetEle));
	return clickableEle;
}
public String getCurrentUrl(WebDriver driver) {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
}
public String getTitle(WebDriver driver) {
	String currentTitle = driver.getTitle();
	return currentTitle;
}
}
