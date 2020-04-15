package com.google.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.utils.PropUtils;

public class BaseClass {
	protected WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(@Optional("ff") String browserName) throws IOException
	{
		if (browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "driver/IEdriverserver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = PropUtils.getValue("src/test/resources/TestData/data.properties", "url");
		
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
