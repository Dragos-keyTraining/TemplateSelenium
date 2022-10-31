package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class ContactPage extends SeleniumWrappers{

	public ContactPage(WebDriver driver) {
		super(driver);
	}
	

	public By zoomIn = By.cssSelector("button[title='Zoom in']");
	public By iframe = By.tagName("iframe");
	
	
	public void zoomMap(By locator) {
		
		driver.switchTo().frame(getElement(iframe));
		click(locator);
	}
	

}
