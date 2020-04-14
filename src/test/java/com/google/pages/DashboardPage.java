package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private static By logoutLocator=By.partialLinkText("Out");
	
	
	public static void waitForLogoutPresence(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
	}
	
	public static String getCurrentTitle(WebDriver driver)
	{
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public static void clickOnLogOut(WebDriver driver)
	{
		driver.findElement(logoutLocator).click();
	}
}
