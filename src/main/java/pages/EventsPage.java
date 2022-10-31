package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class EventsPage extends SeleniumWrappers{

	public EventsPage(WebDriver driver) {
		super(driver);
	}

	public By festivalOfOldFilmsLink = By.linkText("Festival of Old Films");
	
	
	
}
