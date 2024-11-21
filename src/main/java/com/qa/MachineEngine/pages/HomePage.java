package com.qa.MachineEngine.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	String moduleDDxpath = ".navbar-item .navbar-link";
	String RepertoireManagementModuleDDxpath = "//a[text()='Repertoire Management Module']";
	
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void hoverOverModulesDropdown(){
		hoverMouseAndClick(moduleDDxpath, RepertoireManagementModuleDDxpath);
	}

}
