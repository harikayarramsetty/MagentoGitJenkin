package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationPage {

	private By createAnAccountLocator = By.xpath("//span[contains(text(),'Create')]");
	private By firstNameLocator = By.id("firstname");
	private By lastNameLocator = By.id("lastname");
	private By emailLocator = By.name("email");
	private By countryLocator = By.id("country");
	private By companyLocator = By.name("company_type");
	private By roleLocator = By.name("individual_role");
	private By passwordLocator = By.name("password");
	private By confirmPasswordLocator = By.name("password_confirmation");
	// private By robotCheckBoxLocator=
	// By.xpath("//div[@role='presentation']");
	private By tAndcLocator = By.id("agree_terms");
	private By submitButtonLocator = By.xpath("//button[@type='submit']");
	
	private WebDriver driver;
	
	public AccountCreationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	

	public void waitForCreateAnAccountPresence() {
		WebDriverWait wait = new WebDriverWait(driver, 50); // WebDriverWait is a constructor and we are passing
															// parameters.
		wait.until(ExpectedConditions.presenceOfElementLocated(createAnAccountLocator)); // condition statement for
																							// explicit wait
	}

	public String getCurrentTitle() {
		String actualTitle = driver.getTitle(); // get the title of the page
		return actualTitle; // print the title

	}

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameLocator).clear();
		driver.findElement(firstNameLocator).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameLocator).clear();
		driver.findElement(lastNameLocator).sendKeys(lastName);
	}

	public void enterEmailID(String email) {
		driver.findElement(emailLocator).clear();
		driver.findElement(emailLocator).sendKeys(email);
	}

	public void selectCountry(String country) {
		Select selectCountry = new Select(driver.findElement(countryLocator));
		selectCountry.selectByVisibleText(country);
	}

	public void selectCompany(String primary) {

		Select selectPrimary = new Select(driver.findElement(companyLocator));
		selectPrimary.selectByValue(primary);
	}

	public void selectRole(String role) {

		Select selectRole = new Select(driver.findElement(roleLocator));
		selectRole.selectByVisibleText(role);
	}

	public void enterPassword(String password)

	{

		driver.findElement(passwordLocator).clear();
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void confirmPassword(String cPassword) {
		driver.findElement(confirmPasswordLocator).clear();
		driver.findElement(confirmPasswordLocator).sendKeys(cPassword);
	}

	/*
	 * public void selectIAmNotRobotOption() {
	 * driver.findElement(robotCheckBoxLocator).click();
	 * 
	 * }
	 */
	public void termsAndCondition() {
		if (!driver.findElement(tAndcLocator).isSelected()) {
			driver.findElement(tAndcLocator).click();
		}
	}

	public void clickOnSubmit() {
		driver.findElement(submitButtonLocator).click();
	}

}
