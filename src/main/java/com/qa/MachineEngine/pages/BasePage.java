package com.qa.MachineEngine.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends GenericPage{
	
	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@SuppressWarnings("deprecation")
	public void hoverMouseAndClick(String hoverLocator, String clickLocator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector(hoverLocator));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath(clickLocator))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	

}
