package com.qa.MachineEngine.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.MachineEngine.pages.GenericPage;

public class BasicTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public GenericPage genericPage;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/svirgaon/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, null);
		driver.manage().window().fullscreen();
		driver.get("https://www.matchingengine.com/");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// create the object of page class: Instantiate Page Class
		genericPage = new GenericPage(driver, wait);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
