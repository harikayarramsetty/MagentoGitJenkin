package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static By emailLocator = By.xpath("//input[@title='Email']");
	private static By passLocator = By.name("login[password]");
	private static By loginLocator = By.id("send2");
	private static By errorLocator = By.xpath("//div[contains(text(),'Invalid')]");
	private static By registerLocator = By.xpath("//span[contains(text(),'Register')]");
	
	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(emailLocator).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(passLocator).sendKeys(password);
	}

	public static void clickOnLogin(WebDriver driver) {
		driver.findElement(loginLocator).click();
	}

	public static String getErrorMessage(WebDriver driver) {
		WebElement errorEle = driver.findElement(errorLocator);
		String actualErrorText = errorEle.getText();

		return actualErrorText;
	}

	public static void clickOnRegisterButton(WebDriver driver) {
		driver.findElement(registerLocator).click();	
	}
}