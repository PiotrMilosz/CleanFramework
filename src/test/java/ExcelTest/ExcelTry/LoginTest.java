package ExcelTest.ExcelTry;


import org.testng.Assert;
import org.testng.annotations.Test;

import excelUtilis.ExcelUtil;

public class LoginTest extends BaseTest {
	
	@Test(priority=1,description ="Open Page")
	public void openPage() {
		mPage.openPage();
		Assert.assertTrue(mPage.isLogoDisplayed(), "Login was not displayed");
	}
	
	@Test(priority=2,description = "Login to service")
	public void loginToService() {
		mPage.logIn(ExcelUtil.getRowData(1));
		Assert.assertTrue(mPage.isLogedIn(), "User was not loged In, there is no Log out button on main page");
	}
	

}
