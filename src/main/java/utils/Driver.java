package utils;

import java.lang.StackWalker.Option;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	//avem nevoie doar pentru rulare paralela
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(getChromeOptions()));
			
	
			
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//set window size
			//driver.get().manage().window().setSize(new Dimension(800, 600));
			long chromeId = Thread.currentThread().getId();
			System.out.println("Chrome --> Thread id = " + chromeId);
			return driver.get();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver(getFirefoxOptions()));
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long firefoxID = Thread.currentThread().getId();
			System.out.println("Firefox --> Thread id = " + firefoxID);
			return driver.get();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long edgeID = Thread.currentThread().getId();
			System.out.println("Edge --> Thread id = " + edgeID);
			return driver.get();
		}
			
		
		return driver.get();
		
	}
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--disable-infobars");
		chromeOption.addArguments("--disable-gpu");
		chromeOption.addArguments("--disable-dev-shm-usage");
		chromeOption.addArguments("--no-sandbox");
		chromeOption.addArguments("--disable-extensions");
		//chromeOption.addArguments("--headless");
		chromeOption.addArguments("--window-size=1580, 1280");
		
		return chromeOption;
	}
	
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions firefoxOptions =  new FirefoxOptions();
		firefoxOptions.addArguments("--disable-gpu");
		firefoxOptions.addArguments("--disable-extensions");
	//	firefoxOptions.addArguments("--headless");
		//firefoxOptions.addArguments("--window-size=1580, 1280");	
	//	firefoxOptions.addArguments("-width=1580");
	//	firefoxOptions.addArguments("-height=1280");

		return firefoxOptions;
		
		
	}
	
}
