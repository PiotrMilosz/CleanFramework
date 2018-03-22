package ExcelTest.ExcelTry;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import properties.GetProperties;
import excelUtilis.ExcelUtil;

public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);

	}

	// WebElements
	@FindBy(id = "header_logo")
	WebElement logo;
	@FindBy(className = "login")
	WebElement signInBtn;
	@FindBy(id="email")
	WebElement loginFld;
	@FindBy(id="passwd")
	WebElement passwordFld;
	@FindBy(id="SubmitLogin")
	WebElement submitBtn;
	@FindBy(className="logout")
	WebElement logoutBtn;

	// Open target page
	public void openPage() {
	
		String url = GetProperties.getUrl();
		driver.get(url);
		waitForPageLoad();
		Log.info("Opening page " + url);
	}

	// Verification if Page is displayed
	public boolean isLogoDisplayed() {
		
		boolean isLogoDisplayed = false;
		isLogoDisplayed = isElementOnPage(logo);
		if (isLogoDisplayed = true) {
			Log.info("User is on Page");
		} else {
			Log.info("User is not on Page");
		}
		return isLogoDisplayed;
	}
	//Method to login the page
	public void logIn(XSSFRow row) {
		signInBtn.click();
		Log.info("Zaloguj was clicked");
		loginFld.sendKeys(row.getCell(1).toString());
		passwordFld.sendKeys("janusz666");
		submitBtn.click();
		
	}
	//Veryfication if user is loged in
	public boolean isLogedIn() {
		boolean isLogedIn = false;
		isLogedIn=isElementOnPage(logoutBtn);
		if(isLogedIn=true) {
			Log.info("User is Loged In");
		}else {
			Log.error("User is not loged In");
		}
		return isLogedIn;
	}
		
	}
	

