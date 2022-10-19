package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {
	
	@Parameters({"user", "pass"})
	@Test (groups = "LoginFunctionality")
	public void loginTest(String username, String parola) {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, parola);

		assertTrue(loginPage.loginSucessMessageIsDisplayed());

		loginPage.logoutFromApp();
		
	}
	@Parameters({"invalidUser", "invalidPass"})
	@Test(priority =2, groups = "LoginFunctionality")
	public void invalidLoginTest(String user, String pass) {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(user, pass);
		assertTrue(loginPage.loginErrorMessageIsDisplayed());

	}

}
