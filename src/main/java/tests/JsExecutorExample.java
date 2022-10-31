package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class JsExecutorExample extends BaseTest{
	
	//@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.emag.ro/'")  ;//Object...arga
		
		driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
		
		driver.navigate().forward();
		jse.executeScript("window.history.forward(-1)");
		
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//4
		driver.navigate().to(driver.getCurrentUrl());

		/*
		jse.executeScript("window.history.go(0)");
		jse.executeScript("document.getElement..");
		jse.executeScript("arguments[0]", null);
		*/
		
	}
	
	@Test
	public void example2() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu =  new NavMenuPage(driver);
		
	/*	//alternativa pentru click
		jse.executeScript("arguments[0].click()", menu.getElement(menu.searchIcon));
		//alternativa pentru sendKeys
		jse.executeScript("arguments[0].value='cooking'", menu.getElement(menu.searchField));
		//alternativa pentru click
		jse.executeScript("arguments[0].click()", menu.getElement(menu.searchIcon));
		
		jse.executeScript("arguments[0].click();"
				+ "arguments[1].value='cooking';"
				+ "arguments[0].click();", 
				menu.getElement(menu.searchIcon),
				menu.getElement(menu.searchField));
		
		*/
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value = 'cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");

		//alternativa pentru isDisplayed()
		//jse.executeScript(document.getElementsByClassName('post_title')[0].checkVisibility() )
		
		Thread.sleep(3000);
		
		//alternativa pentru getText()
		String bookTitle = jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
		System.out.println(bookTitle);
		
		//alternativa pentru get page title
		String pageTitle = jse.executeScript("return document.title").toString();
		System.out.println(pageTitle);
		
		//alternativa pentru getCurrentUrl
		String pageUrl = jse.executeScript("return document.URL").toString();
		System.out.println(pageUrl);
		
		//alternativa pentru isSelected
		//jse.executeScript("document.getElementById('rememberme').checked "); //intoarce boolean
		
		//alternativa pentru hover (moveToElement din clasa Actions)
		String javaScriptHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover', true);"
				+ "arguments[0].dispatchEvent(obiect);";
		
		jse.executeScript(javaScriptHover, menu.getElement(menu.blogLink));
		Thread.sleep(3000);
		jse.executeScript(javaScriptHover, menu.getElement(menu.aboutLink));

		
	}


}
