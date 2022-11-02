package tests;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CookieHandling extends BaseTest{
	
	@Test(priority=1)
	public void addCookie() {
		
		driver.manage().addCookie(new Cookie("MyCookie", "My cookie value"));
	
	}
	@Test(priority=2)
	public void getCookieNamed() {
		
		Cookie cookie = driver.manage().getCookieNamed("PHPSESSID");
		System.out.println(cookie);
	}
	
	@Test(priority=3)
	public void getAllCookies() {
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies);
	}
	
	@Test(priority=4)
	public void deleteCookieNamed() {
		
		driver.manage().deleteCookieNamed("MyCookie");
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println("After delete :" +allCookies);
		
	}
	
	@Test(priority=5)
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println("After delete all:" +allCookies);
	}

}
