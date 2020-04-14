package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private By myAccountLocator = By.xpath("//i[@class='fa fa-user']");

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnMyAccountIcon() {
		driver.findElement(myAccountLocator).click();
	}
}
