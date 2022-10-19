package utils;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {
	
	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Custom sendKeys method/ Wraps selenium default SendKeys and enhace it
	 * with clear() method before sending the text.
	 * @param locator --> used inside method to create an WebElement object
	 * @param value --> String value
	 */
	public void sendKeys(By locator, String value) {
		WebElement element =  driver.findElement(locator);
		try {
			
			element.clear();
			element.sendKeys(value);
			
		}catch(Exception e) {
			
			System.out.println("Something went wrong!");
		}
		
	}
	
	public void click(By locator) {
		WebElement element =  driver.findElement(locator);

		try {
			waitForElementToBeClickable(element);
			element.click();
			
		}catch(NoSuchElementException e) {
			
			System.out.println("Something went wrong!");
		}catch (StaleElementReferenceException e) {
			
			WebElement element2 =  driver.findElement(locator);
			element2.click();
		}
		
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void dragAndDrop(By locator, int x, int y) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element,x, y).perform();
		
		//action.clickAndHold(element).moveByOffset(300, 0).release().build().perform();
		//action.sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		//action.moveByOffset(600, 300);
		//action.click();
	
	}
	
	public void hoverElement(By locator) {	
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
	}
	
	public String readUrl() {
		
		return driver.getCurrentUrl();
	}
	

}
