package utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

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
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			TakesScreenshot poza = (TakesScreenshot)driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			
			try {
				Files.copy(picture, new File("screenshots/"+result.getName() + ".png"));
				Log.info("Saved picture in 'screenshots/' "+result.getName() + ".png");
				
			}catch (Exception e) {
				Log.error("Could not save picture!");
				Log.error(e.getMessage());
				
			}
			
		}
		
	}
	

}
