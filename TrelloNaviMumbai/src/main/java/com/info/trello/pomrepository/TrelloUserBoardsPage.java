package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloUserBoardsPage {
WebDriver driver;
public TrelloUserBoardsPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//button[@aria-label='Show menu']")
 private WebElement menuButton;
@FindBy(xpath = "//a[contains(text(),'Close board')]")
private WebElement closeBoardButton;
@FindBy(xpath = "//input[@value='Close']")
private WebElement closeButton;
@FindBy(xpath = "//button[.='Permanently delete board']")
private WebElement permanetlyDeleteBoardButton;
@FindBy(xpath = "//button[.='Delete']")
private WebElement deleteButton;
@FindBy(xpath = "//input[@placeholder='Enter list title…']")
private WebElement listTitleTextfiled;
@FindBy(xpath = "//input[@value='Add list']")
private WebElement addListButton;
@FindBy(xpath = "//span[.='Add another list']")
private WebElement addAnotherListIcon;
@FindBy(xpath = "//textarea[@aria-label='CreatedListOne']")
private WebElement createdListOne;
@FindBy(xpath = "//textarea[@aria-label='CreatedListTwo']")
private WebElement createdListTwo;


public WebElement getCreatedListOne() {
	return createdListOne;
}
public WebElement getCreatedListTwo() {
	return createdListTwo;
}
public WebElement getAddAnotherListIcon() {
	return addAnotherListIcon;
}
public WebElement getMenuButton() {
	return menuButton;
}
public WebElement getListTitleTextfiled() {
	return listTitleTextfiled;
}
public WebElement getAddListButton() {
	return addListButton;
}
public WebElement getCloseBoardButton() {
	return closeBoardButton;
}
public WebElement getCloseButton() {
	return closeButton;
}
public WebElement getPermanetlyDeleteBoardButton() {
	return permanetlyDeleteBoardButton;
}
public WebElement getDeleteButton() {
	return deleteButton;
}

}
