package com.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;
import com.ohrm.utility.ExcelReaderUtility;

public class LoginPageTest {

	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserSetup() {
		lp = new LoginPage();
		lp.initialization();
	}

	@Test
	public void validateTitleTest() {
		String expTitle = "OrangeHRM";
		String actTitle = lp.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	// TC2: validate login
	@Test
	public void validateLoginTest() {
		dp = lp.login();
		Assert.assertTrue(dp.getDashboardLabel());
		lp.captureScreenshot("Login TC");
	}

	// write one tc for data provider
	@Test(dataProvider = "getLoginData")
	public void validateLoginMultipleData(String username, String password) {
		dp = lp.login(username, password);
		Assert.assertTrue(dp.getDashboardLabel());
	}

	@DataProvider
	public Object[][] getLoginData() {
		String path = "./src/test/resources/TestData/TestData.xlsx";
		String sheetName = "userdata";
		return ExcelReaderUtility.getData(path, sheetName);
	}

	// write a TC to validate that
	// when clicked on forgotpassword link
	// Reset Password page is open

	@AfterMethod
	public void closeBrowser() {
		lp.tearDown();
	}
}
