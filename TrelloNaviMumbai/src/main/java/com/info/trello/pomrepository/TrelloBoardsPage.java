package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;
	public TrelloBoardsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[.='Create new board']")
	private WebElement createNewBoard;
	@FindBy(xpath = "//button[@data-testid='header-member-menu-button']")
	private WebElement accountButton;
	@FindBy(xpath = "//button[.='Log out']")
	private WebElement logoutButton;
	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	private WebElement boardTitleTextfield;
	@FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
	private WebElement createBoardFinalButton;
	@FindBy(xpath = "//button[@data-testid='header-create-menu-button']")
	private WebElement createButton;
	@FindBy(xpath = "//span[.='Create board']")
	private WebElement createBoardButton;
	public WebElement getCreateNewBoard() {
		return createNewBoard;
	}
	public WebElement getAccountButton() {
		return accountButton;
	}
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	public WebElement getBoardTitle() {
		return boardTitleTextfield;
	}
	public WebElement getCreateBoardButton() {
		return createBoardButton;
	}
	public WebElement getCreateBoardFinalButton() {
		return createBoardFinalButton;
	}
	public void setCreateBoardFinalButton(WebElement createBoardFinalButton) {
		this.createBoardFinalButton = createBoardFinalButton;
	}
	public WebElement getCreateButton() {
		return createButton;
	}
}
