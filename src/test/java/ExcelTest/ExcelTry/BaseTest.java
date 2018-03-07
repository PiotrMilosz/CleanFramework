package ExcelTest.ExcelTry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.DriverGenerator;

public class BaseTest {

	protected WebDriver driver;
	protected final Logger Log = LoggerFactory.getLogger(getClass());
	
	public WebDriver gimiDriver() {
        return driver;
    }
	
	@BeforeClass
	public void initialiseDriver() {
	//Initialise Driver
	driver = DriverGenerator.getDriver();
	Log.info("Driver initialised");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	public void quitDriver() {
		//Quit driver after tests
		driver.quit();
		Log.info("Driver terminated");
				
	}
}
