package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest extends Driver {

	public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	public void setup(String browser) {
		
		driver = initDriver(browser);
		driver.get("https://keybooks.ro/");
		
	}
	
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}
	

}
