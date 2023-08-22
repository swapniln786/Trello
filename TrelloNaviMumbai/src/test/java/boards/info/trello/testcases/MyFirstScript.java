package boards.info.trello.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.info.trello.genericutility.BaseClass;
import com.info.trello.genericutility.WebDriverUtility;
import com.info.trello.pomrepository.TrelloBoardsPage;
import com.info.trello.pomrepository.TrelloHomePage;
import com.info.trello.pomrepository.TrelloLoginPage;
import com.info.trello.pomrepository.TrelloLoginToContinue;
import com.info.trello.pomrepository.TrelloLogoutPage;
import com.info.trello.pomrepository.TrelloUserBoardsPage;

public class MyFirstScript extends BaseClass{
	@Test
	public void loginLogoutTrello() throws InterruptedException, IOException {
		webDriverUtils.implicitWait(driver);
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		TrelloLoginPage loginPage=new TrelloLoginPage(driver);
		loginPage.getUsernameTextfield().sendKeys(fileUtils.readCommonData("username"));
		loginPage.getContinueButton().click();
		TrelloLoginToContinue loginToContinue=new TrelloLoginToContinue(driver);
		webDriverUtils.clickableElement(driver, loginToContinue.getPasswordTextfield());
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		loginToContinue.getLoginButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getAccountButton().click();
		boardsPage.getLogoutButton().click();
	}
	@Test
	public void loginCreateBoardDeleteBoardLogout() throws IOException, InterruptedException {
		webDriverUtils.implicitWait(driver);
		TrelloHomePage homepage=new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		TrelloLoginPage loginPage=new TrelloLoginPage(driver);
		loginPage.getUsernameTextfield().sendKeys(fileUtils.readCommonData("username"));
		loginPage.getContinueButton().click();
		TrelloLoginToContinue loginToContinue=new TrelloLoginToContinue(driver);
		webDriverUtils.clickableElement(driver, loginToContinue.getPasswordTextfield());
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		loginToContinue.getLoginButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getCreateNewBoard().click();
		boardsPage.getBoardTitle().sendKeys("Camle");
		webDriverUtils.clickableElement(driver, boardsPage.getCreateBoardFinalButton());
		boardsPage.getCreateBoardFinalButton().click();
		TrelloUserBoardsPage userBoardPage = new TrelloUserBoardsPage(driver);
		userBoardPage.getMenuButton().click();
		userBoardPage.getCloseBoardButton().click();
		userBoardPage.getCloseButton().click();
		Thread.sleep(2000);
		userBoardPage.getPermanetlyDeleteBoardButton().click();
		Thread.sleep(2000);
		boardsPage.getAccountButton().click();
		boardsPage.getLogoutButton().click();
		TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().click();
		Thread.sleep(2000);
	}
	@Test
	public void verifyHomepageUrl() throws EncryptedDocumentException, IOException {
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 0, 1));
		Reporter.log("Homepage Url is verified");
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 1, 1));
		Reporter.log("Homepage Title is verified");
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webDriverUtils.getCurrentUrl(driver), excelUtils.readStringData("trello", 2, 1));
		Reporter.log("Loginpage Url is verified");
		Assert.assertEquals(webDriverUtils.getTitle(driver), excelUtils.readStringData("trello", 3, 1));
		Reporter.log("Loginpage Title is verified");
	}
}
