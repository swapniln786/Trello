package boards.info.trello.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.info.trello.genericutility.BaseClass;
import com.info.trello.pomrepository.TrelloBoardsPage;
import com.info.trello.pomrepository.TrelloHomePage;
import com.info.trello.pomrepository.TrelloLoginPage;
import com.info.trello.pomrepository.TrelloLoginToContinue;
import com.info.trello.pomrepository.TrelloLogoutPage;
import com.info.trello.pomrepository.TrelloUserBoardsPage;

public class MyTestCases extends BaseClass{
	@Test
	public void trelloHomePageCheck() throws EncryptedDocumentException, IOException {
		//verify homepage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		Reporter.log("Homepage is displayed");
	}
	@Test
	public void trelloLoginPageCheck() throws Throwable, IOException {
		//verify homepage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify using url
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 0, 1));
		Reporter.log("Homepage is displayed");
		//click on login option\
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		//verify loginpage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 3, 1));
		//verify using url
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 2, 1));
		Reporter.log("Login page is displayed");
	}
	@Test
	public void trelloBoardsPageCheck() throws EncryptedDocumentException, IOException {
		//verify homepage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify using url
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 0, 1));
		Reporter.log("Homepage is displayed");
		//click on login option\
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		//verify loginpage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 3, 1),"Login page is not displayed");
		//verify loginpage using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).equals(excelUtils.readStringData("trello", 2, 1)), "Login page is not displayed");
		Reporter.log("Login page is displayed");
		TrelloLoginPage loginPage=new TrelloLoginPage(driver);
		//enter username in username textfield
		loginPage.getUsernameTextfield().sendKeys(fileUtils.readCommonData("username"));
		//click on continue button
		loginPage.getContinueButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 5, 1));
		//verify loginTocontinue page using title
		assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 5, 1));
		//verify login to continue page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 4, 1)), "Login to continue page is not displayed");
		Reporter.log("LoginToContinue Page is displayed");
		TrelloLoginToContinue loginToContinue=new TrelloLoginToContinue(driver);
		//enter password in password textfield
		webDriverUtils.clickableElement(driver, loginToContinue.getPasswordTextfield());
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		//click on final login button
		loginToContinue.getLoginButton().click();
		//verify Boardspage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 7, 1));
		//verify boards page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 6, 1)), "Boardspage is not displayed");
		Reporter.log("Boards page is displayed");
		//click on profile menu option
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		boardsPage.getAccountButton().click();
		webDriverUtils.clickableElement(driver, boardsPage.getLogoutButton());
		//click on logout button
		boardsPage.getLogoutButton().click();
		//verify logout page using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 9, 1));
		//verify logout page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 8, 1)), "logout page is not displayed");
		Reporter.log("logout page is displayed");
		//click on  final logout button
		TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().click();
		//verify homepage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 1, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify homepage using url
		//verify using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 0, 1)),"Homepage is not displayed");
		Reporter.log("Homepage is displayed");
	}
	@Test
	public void trelloCreateAndDeleteBoard() throws EncryptedDocumentException, IOException {
		//verify homepage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify using url
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 0, 1));
		Reporter.log("Homepage is displayed");
		//click on login option\
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		//verify loginpage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 3, 1),"Login page is not displayed");
		//verify loginpage using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).equals(excelUtils.readStringData("trello", 2, 1)), "Login page is not displayed");
		Reporter.log("Login page is displayed");
		TrelloLoginPage loginPage=new TrelloLoginPage(driver);
		//enter username in username textfield
		loginPage.getUsernameTextfield().sendKeys(fileUtils.readCommonData("username"));
		//click on continue button
		loginPage.getContinueButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 5, 1));
		//verify loginTocontinue page using title
		assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 5, 1));
		//verify login to continue page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 4, 1)), "Login to continue page is not displayed");
		Reporter.log("LoginToContinue Page is displayed");
		TrelloLoginToContinue loginToContinue=new TrelloLoginToContinue(driver);
		//enter password in password textfield
		webDriverUtils.clickableElement(driver, loginToContinue.getPasswordTextfield());
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		//click on final login button
		loginToContinue.getLoginButton().click();
		//verify Boardspage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 7, 1));
		//verify boards page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 6, 1)), "Boardspage is not displayed");
		Reporter.log("Boards page is displayed");
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		//click on create button
		boardsPage.getCreateButton().click();
		//click on create board button
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardButton());
		Assert.assertTrue(boardsPage.getCreateBoardButton().isDisplayed(), "Create Board Button is not displayed");
		boardsPage.getCreateBoardButton().click();
		//enter board title
		assertTrue(boardsPage.getBoardTitle().isDisplayed(), "Board title textfield is visible");
		boardsPage.getBoardTitle().sendKeys(excelUtils.readStringData("trelloboardsdata", 0, 1));
		//clcik on final create board button
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardFinalButton());
		boardsPage.getCreateBoardFinalButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 10, 1));
		//verify user board page using title
		assertTrue(webDriverUtils.getTitle(driver).contains(excelUtils.readStringData("trello", 10, 1)),"USer board page is not displayed");
		//verify user board page using url
		assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 11, 1)), "USer board page is not displayed");
		Reporter.log("UserBoardPage is displayed");
		//click on menu option
		TrelloUserBoardsPage userBoardsPage=new TrelloUserBoardsPage(driver);
		userBoardsPage.getMenuButton().click();
		//click on close board option
		webDriverUtils.clickableElement(driver, userBoardsPage.getCloseBoardButton());
		userBoardsPage.getCloseBoardButton().click();
		//click on close button
		userBoardsPage.getCloseButton().click();
		//click on permanently delete button
		webDriverUtils.clickableElement(driver, userBoardsPage.getPermanetlyDeleteBoardButton());
		userBoardsPage.getPermanetlyDeleteBoardButton().click();
		userBoardsPage.getDeleteButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		//click on profile icon menu
		boardsPage.getAccountButton().click();
		webDriverUtils.clickableElement(driver, boardsPage.getLogoutButton());
		//click on logout button
		boardsPage.getLogoutButton().click();
		//verify logout page using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 9, 1));
		//verify logout page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 8, 1)), "logout page is not displayed");
		Reporter.log("logout page is displayed");
		//click on  final logout button
		TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().click();
		//verify homepage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 1, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify homepage using url
		//verify using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 0, 1)),"Homepage is not displayed");
		Reporter.log("Homepage is displayed");
	}
	@Test
	public void trelloCreateMultipleListInCreatedBoard() throws EncryptedDocumentException, IOException, InterruptedException {
		//verify homepage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify using url
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 0, 1));
		Reporter.log("Homepage is displayed");
		//click on login option\
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		//verify loginpage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 3, 1),"Login page is not displayed");
		//verify loginpage using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).equals(excelUtils.readStringData("trello", 2, 1)), "Login page is not displayed");
		Reporter.log("Login page is displayed");
		TrelloLoginPage loginPage=new TrelloLoginPage(driver);
		//enter username in username textfield
		loginPage.getUsernameTextfield().sendKeys(fileUtils.readCommonData("username"));
		//click on continue button
		loginPage.getContinueButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 5, 1));
		//verify loginTocontinue page using title
		assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 5, 1));
		//verify login to continue page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 4, 1)), "Login to continue page is not displayed");
		Reporter.log("LoginToContinue Page is displayed");
		TrelloLoginToContinue loginToContinue=new TrelloLoginToContinue(driver);
		//enter password in password textfield
		webDriverUtils.clickableElement(driver, loginToContinue.getPasswordTextfield());
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		//click on final login button
		loginToContinue.getLoginButton().click();
		//verify Boardspage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 7, 1));
		//verify boards page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 6, 1)), "Boardspage is not displayed");
		Reporter.log("Boards page is displayed");
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		//click on create button
		boardsPage.getCreateButton().click();
		//click on create board button
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardButton());
		Assert.assertTrue(boardsPage.getCreateBoardButton().isDisplayed(), "Create Board Button is not displayed");
		boardsPage.getCreateBoardButton().click();
		//enter board title
		assertTrue(boardsPage.getBoardTitle().isDisplayed(), "Board title textfield is visible");
		boardsPage.getBoardTitle().sendKeys(excelUtils.readStringData("trelloboardsdata", 0, 1));
		//clcik on final create board button
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardFinalButton());
		boardsPage.getCreateBoardFinalButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 10, 1));
		//verify user board page using title
		assertTrue(webDriverUtils.getTitle(driver).contains(excelUtils.readStringData("trello", 10, 1)),"USer board page is not displayed");
		//verify user board page using url
		assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 11, 1)), "USer board page is not displayed");
		Reporter.log("UserBoardPage is displayed");
		//create list one
		TrelloUserBoardsPage userBoardsPage=new TrelloUserBoardsPage(driver);
		webDriverUtils.clickableElement(driver, userBoardsPage.getAddAnotherListIcon());
		userBoardsPage.getAddAnotherListIcon().click();
		webDriverUtils.clickableElement(driver, userBoardsPage.getListTitleTextfiled());
		userBoardsPage.getListTitleTextfiled().sendKeys(excelUtils.readStringData("trelloboardsdata", 1, 1));
		webDriverUtils.clickableElement(driver, userBoardsPage.getAddListButton());
		userBoardsPage.getAddListButton().click();
		//create list two
		userBoardsPage.getListTitleTextfiled().sendKeys(excelUtils.readStringData("trelloboardsdata", 2, 1));
		userBoardsPage.getAddListButton().click();
		//click on menu option
		webDriverUtils.clickableElement(driver, userBoardsPage.getMenuButton());
		userBoardsPage.getMenuButton().click();
		//click on close board option
		webDriverUtils.clickableElement(driver, userBoardsPage.getCloseBoardButton());
		userBoardsPage.getCloseBoardButton().click();
		//click on close button
		webDriverUtils.clickableElement(driver, userBoardsPage.getCloseButton());
		userBoardsPage.getCloseButton().click();
		//click on permanently delete button
		webDriverUtils.clickableElement(driver, userBoardsPage.getPermanetlyDeleteBoardButton());
		userBoardsPage.getPermanetlyDeleteBoardButton().click();
		//click on delete
		webDriverUtils.clickableElement(driver, userBoardsPage.getDeleteButton());
		userBoardsPage.getDeleteButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		//click on profile icon menu
		boardsPage.getAccountButton().click();
		webDriverUtils.clickableElement(driver, boardsPage.getLogoutButton());
		//click on logout button
		boardsPage.getLogoutButton().click();
		//verify logout page using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 9, 1));
		//verify logout page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 8, 1)), "logout page is not displayed");
		Reporter.log("logout page is displayed");
		//click on  final logout button
		TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().click();
		//verify homepage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 1, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify homepage using url
		//verify using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 0, 1)),"Homepage is not displayed");
		Reporter.log("Homepage is displayed");
	}
	@Test
	public void trelloCreateMultipleListAndSwapInCreateBoard() throws EncryptedDocumentException, IOException, InterruptedException {
		//verify homepage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify using url
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 0, 1));
		Reporter.log("Homepage is displayed");
		//click on login option\
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		//verify loginpage using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 3, 1),"Login page is not displayed");
		//verify loginpage using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).equals(excelUtils.readStringData("trello", 2, 1)), "Login page is not displayed");
		Reporter.log("Login page is displayed");
		TrelloLoginPage loginPage=new TrelloLoginPage(driver);
		//enter username in username textfield
		loginPage.getUsernameTextfield().sendKeys(fileUtils.readCommonData("username"));
		//click on continue button
		loginPage.getContinueButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 5, 1));
		//verify loginTocontinue page using title
		assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 5, 1));
		//verify login to continue page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 4, 1)), "Login to continue page is not displayed");
		Reporter.log("LoginToContinue Page is displayed");
		TrelloLoginToContinue loginToContinue=new TrelloLoginToContinue(driver);
		//enter password in password textfield
		webDriverUtils.clickableElement(driver, loginToContinue.getPasswordTextfield());
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		//click on final login button
		loginToContinue.getLoginButton().click();
		//verify Boardspage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 7, 1));
		//verify boards page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 6, 1)), "Boardspage is not displayed");
		Reporter.log("Boards page is displayed");
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		//click on create button
		boardsPage.getCreateButton().click();
		//click on create board button
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardButton());
		Assert.assertTrue(boardsPage.getCreateBoardButton().isDisplayed(), "Create Board Button is not displayed");
		boardsPage.getCreateBoardButton().click();
		//enter board title
		assertTrue(boardsPage.getBoardTitle().isDisplayed(), "Board title textfield is visible");
		boardsPage.getBoardTitle().sendKeys(excelUtils.readStringData("trelloboardsdata", 0, 1));
		//clcik on final create board button
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardFinalButton());
		boardsPage.getCreateBoardFinalButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 10, 1));
		//verify user board page using title
		assertTrue(webDriverUtils.getTitle(driver).contains(excelUtils.readStringData("trello", 10, 1)),"USer board page is not displayed");
		//verify user board page using url
		assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 11, 1)), "USer board page is not displayed");
		Reporter.log("UserBoardPage is displayed");
		//create list one
		TrelloUserBoardsPage userBoardsPage=new TrelloUserBoardsPage(driver);
		webDriverUtils.clickableElement(driver, userBoardsPage.getAddAnotherListIcon());
		userBoardsPage.getAddAnotherListIcon().click();
		webDriverUtils.clickableElement(driver, userBoardsPage.getListTitleTextfiled());
		userBoardsPage.getListTitleTextfiled().sendKeys(excelUtils.readStringData("trelloboardsdata", 1, 1));
		webDriverUtils.clickableElement(driver, userBoardsPage.getAddListButton());
		userBoardsPage.getAddListButton().click();
		//create list two
		userBoardsPage.getListTitleTextfiled().sendKeys(excelUtils.readStringData("trelloboardsdata", 2, 1));
		userBoardsPage.getAddListButton().click();
		//capture location of ListTwo before swapping
		Point positonOfListTwo = userBoardsPage.getCreatedListTwo().getLocation();
		System.out.println(positonOfListTwo);
		Actions actions=new Actions(driver);
		//swap the lists
		actions.clickAndHold(userBoardsPage.getCreatedListTwo()).pause(2000).moveByOffset(-200, 0).pause(2000).release().perform();
		Thread.sleep(3000);
		System.out.println(userBoardsPage.getCreatedListOne().getLocation());
		//verify lists are swapped
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(userBoardsPage.getCreatedListOne().getLocation().equals(positonOfListTwo), "Position is not swapped properly");
		//click on menu option
		userBoardsPage.getMenuButton().click();
		//click on close board option
		webDriverUtils.clickableElement(driver, userBoardsPage.getCloseBoardButton());
		userBoardsPage.getCloseBoardButton().click();
		//click on close button
		webDriverUtils.clickableElement(driver, userBoardsPage.getCloseButton());
		userBoardsPage.getCloseButton().click();
		//click on permanently delete button
		webDriverUtils.clickableElement(driver, userBoardsPage.getPermanetlyDeleteBoardButton());
		userBoardsPage.getPermanetlyDeleteBoardButton().click();
		//click on delete button
		webDriverUtils.clickableElement(driver, userBoardsPage.getDeleteButton());
		userBoardsPage.getDeleteButton().click();
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 7, 1));
		//click on profile icon menu
		boardsPage.getAccountButton().click();
		webDriverUtils.clickableElement(driver, boardsPage.getLogoutButton());
		//click on logout button
		boardsPage.getLogoutButton().click();
		//verify logout page using title
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 9, 1));
		//verify logout page using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 8, 1)), "logout page is not displayed");
		Reporter.log("logout page is displayed");
		//click on  final logout button
		TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().click();
		//verify homepage using title
		webDriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("trello", 1, 1));
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		//verify homepage using url
		//verify using url
		Assert.assertTrue(webDriverUtils.getCurrentUrl(driver).contains(excelUtils.readStringData("trello", 0, 1)),"Homepage is not displayed");
		Reporter.log("Homepage is displayed");
		softAssert.assertAll();
	}
}
