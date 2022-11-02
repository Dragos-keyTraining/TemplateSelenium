package tests;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class CookiesLogin extends BaseTest{
	
	Set<Cookie> cookies;
	
	@Parameters({"user", "pass"})
	@Test(priority=1)
	public void loginTest(String username, String parola) throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, parola);

		assertTrue(loginPage.loginSucessMessageIsDisplayed());
		Thread.sleep(3000);
		
		cookies = driver.manage().getCookies();
		System.out.println(cookies);
	}
	
	@Test(priority=2)
	public void cookiesLogin() throws InterruptedException {
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		
		for(Cookie cook : cookies) {
			
			driver.manage().addCookie(cook);
		}
		
		Thread.sleep(3000);
		navMenu.navigateTo(navMenu.shopLink);

	}
	

}
