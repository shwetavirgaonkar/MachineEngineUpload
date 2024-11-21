package com.qa.MachineEngine.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepertoireManagementPage  extends BasePage{
	
	String productsSupportedTextxpath = "//span[text()='Products Supported']";
	String productsSupportedButtonxpath = "//a/span[text()='Products Supported']";
	List <String> productNamesExpected = Arrays.asList("Musical Works", "Agreements", "IP Information (Creators and Publishers)", "Products");
	List <String> productNamesActual = new ArrayList<String>();;

	public RepertoireManagementPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyRepertoireManagementPageIsLoaded(){
		String actualPageTitle = getPageTitle();
		if(actualPageTitle.contains("Repertoire Management Module")) {
			return true;
		}
		return false;
	}
	
	public boolean verifyProductsSupportedIsDisplayed() {
		return driver.findElement(By.xpath(productsSupportedTextxpath)).isDisplayed();
	}
	
	public void scrollIntoViewOfProductsSupportedOption() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(productsSupportedButtonxpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	
	public void clikOnButtonProductsSupportedButton() {
		driver.findElement(By.xpath(productsSupportedButtonxpath)).click();;
	}
	
	public boolean verifyItemsInTheList() {
		List<WebElement> totalProductsList = driver.findElements(By.xpath("//*[contains(text(), 'There are several types of Product Supported:')]/following::div[1]//li"));
        int totalProducts = totalProductsList.size();
        for(int i=0;i<totalProducts;i++){
        	productNamesActual.add(totalProductsList.get(i).findElement(By.xpath("span")).getText());
        }
        boolean isListIdentical = true;
        int totalNumberOfProductsExpected = productNamesExpected.size();
        for(int i=1;i<=totalNumberOfProductsExpected;i++){
        	if(!productNamesActual.contains(productNamesExpected.get(i))){
        		isListIdentical = false;
        		break;
        	}
        }
        return isListIdentical;
	}

}
