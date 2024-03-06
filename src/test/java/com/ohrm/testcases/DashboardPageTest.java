package com.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;

public class DashboardPageTest {

	DashboardPage dp;
	LoginPage lp;

	@BeforeMethod
	public void browserSetup() {
		lp = new LoginPage();
		lp.initialization();
	}

	@Test
	public void validateTimeWorkSectionTest() {
		dp = lp.login();
		Assert.assertTrue(dp.getTimeWorkSection());
	}
	
	@Test
	public void myActionSectionTest() {
		dp = lp.login();
		Assert.assertTrue(dp.getMyActionSection());
	}

	// write TC for remaining 6 sections

	@AfterMethod
	public void closeBrowser() {
		dp.tearDown();
	}
}
