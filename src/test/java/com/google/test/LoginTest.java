package com.google.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.base.BaseClass;
import com.google.pages.DashboardPage;
import com.google.pages.HomePage;
import com.google.pages.LoginPage;
import com.google.utils.ExcelUtils;

public class LoginTest extends BaseClass {
	
	@DataProvider
	public String[][] invalidCredentialTestData() throws IOException
	{
		String[][] main = ExcelUtils.getSheetIntoMultiDimStringArray("src/test/resources/TestData/MagentoData.xlsx", "InvalidCredentialTest");
		return main;
	}
	

	@Test(priority = 2,dataProvider = "invalidCredentialTestData")
	public void invalidCredentialTest(String username,String password,String expectedText) 
	{
		HomePage home =new HomePage(driver);
		home.clickOnMyAccountIcon();

		LoginPage.enterUsername(driver, username);

		LoginPage.enterPassword(driver, password);

		LoginPage.clickOnLogin(driver);

		//String expectedText = "Invalid login or password.";

		String actualText = LoginPage.getErrorMessage(driver);

		Assert.assertEquals(actualText, expectedText, "Assertion on invalidCredentialTest");

	}

	
	//dataprovider for validCredentialTest --> hardcode 
//	(priority = 1,dependsOnMethods = {"invalidCredentialTest"},invocationCount = 2)
	@Test()
	public void validCredentialTest() {

		// homepage
		HomePage home =new HomePage(driver);
		home.clickOnMyAccountIcon();

		// loginpage
		LoginPage.enterUsername(driver, "balaji0017@gmail.com");
		LoginPage.enterPassword(driver, "welcome@1234");
		LoginPage.clickOnLogin(driver);

		// dashboardpage
		DashboardPage.waitForLogoutPresence(driver);
		String actualTitle = DashboardPage.getCurrentTitle(driver);

		// assert title
		String expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle, "Assertion on validCredentialTest");

		//logout
		DashboardPage.clickOnLogOut(driver);

	}
}
