package com.qa.MachineEngine.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.MachineEngine.pages.HomePage;
import com.qa.MachineEngine.pages.RepertoireManagementPage;

public class VerificationTest extends BasicTest{
	
	@Test
	public void verifyListOfProductsSupportedByRepertoireManagementModule() throws InterruptedException{
		
		//comment
		genericPage.getInstance(HomePage.class).hoverOverModulesDropdown();
		Assert.assertEquals(true, genericPage.getInstance(RepertoireManagementPage.class).verifyRepertoireManagementPageIsLoaded());
		
		genericPage.getInstance(RepertoireManagementPage.class).scrollIntoViewOfProductsSupportedOption();
		Assert.assertEquals(true,genericPage.getInstance(RepertoireManagementPage.class).verifyProductsSupportedIsDisplayed());
		
		genericPage.getInstance(RepertoireManagementPage.class).clikOnButtonProductsSupportedButton();
		Assert.assertEquals(true,genericPage.getInstance(RepertoireManagementPage.class).verifyItemsInTheList());
	}

}
