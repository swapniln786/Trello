package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinue {
	WebDriver driver;

	public TrelloLoginToContinue(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextfield;
	@FindBy(xpath = "//button[@id='login-submit']")
	private WebElement loginButton;

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
}
