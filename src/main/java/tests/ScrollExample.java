package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{
	
	//@Test
	public void jsExecutorScroll() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//JavaScript executor scroll
		jse.executeScript("window.scrollBy(0, 2000)");
		Thread.sleep(3000);
		
		//Actions class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
		Thread.sleep(3000);

	}
//	@Test
	public void scrollToElement() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);

		WebElement signUpButton =  driver.findElement(By.cssSelector("input[value='Sign up']"));
		
		//Javascript executor scroll to Element
		//jse.executeScript("arguments[0].scrollIntoView();", signUpButton);
		Thread.sleep(3000);
		
		//Actions class move to element
		action.moveToElement(signUpButton).perform();
		Thread.sleep(3000);

	}
	
	//@Test
	public void scrollTopAndDown() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		//scroll top
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
	
	}
	
	@Test
	public void jsFunctionCall() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		System.out.println(driver.getTitle());
		
		jse.executeScript("window.schimbTitlu = function(){ document.title = 'Alt Titlu!'};"
				+ "window.schimbTitlu.call()");
		
		System.out.println(driver.getTitle());
		
	}
	

}
