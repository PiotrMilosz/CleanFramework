package ExcelTest.ExcelTry;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.Test;

import excelUtilis.ExcelUtil;
import properties.GetProperties;

public class LoginTest extends BaseTest {
	
	@Test(priority=1,description ="Open Page")
	public void openPage() {
		mPage.openPage(GetProperties.getUrl());
		Assert.assertTrue(mPage.isLogoDisplayed(), "Login was not displayed");
		ExcelUtil.getRowData(1);
	
	}
	
	@Test(priority=2,description = "Login to service")
	public void loginToService(XSSFRow row) {
	
	
		mPage.logIn(row.getCell(1).toString());
		Assert.assertTrue(mPage.isLogedIn(), "User was not loged In, there is no Log out button on main page");
	}
	

}
