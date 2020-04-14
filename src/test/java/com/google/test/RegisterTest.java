package com.google.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.base.BaseClass;
import com.google.pages.AccountCreationPage;
import com.google.pages.HomePage;
import com.google.pages.LoginPage;

public class RegisterTest extends BaseClass	 {

	//dataprovider for registrationTest from excel
	
	@Test
	public void registrationTest(String firstName,String lastName,String emailId,String company)
	{
		//Homepage
		HomePage home =new HomePage(driver);
		home.clickOnMyAccountIcon();
		//LoginPage
		LoginPage.clickOnRegisterButton(driver);
		//AccountCreationPage
		String ExpectedTitle="Create New Customer Account";
		
		AccountCreationPage register = new AccountCreationPage(driver);
		
		register.waitForCreateAnAccountPresence();
		String actualTitle=register.getCurrentTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle, "Assertion on resistrationTest");
		
		register.enterFirstName(firstName);
		register.enterLastName(lastName);
		register.enterEmailID("test@gmail.com");
		register.selectCompany("development");
		register.selectRole("Business/sales/marketing/merchandising");
		register.selectCountry("India");
		register.enterPassword("Welcome@123");
		register.confirmPassword("Welcome@123");
		//AccountCreationPage.selectIAmNotRobotOption();
		register.termsAndCondition();
		register.clickOnSubmit();
	
		
				
		//Assertion 
		
	}

}
