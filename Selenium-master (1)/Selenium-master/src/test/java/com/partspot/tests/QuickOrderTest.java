package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.PartDetails;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.pageActions.QuickOrderPage;
import com.partspot.pageActions.ShoppingCartPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class QuickOrderTest {
	
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	QuickOrderPage quickOrderPage;
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateQuickOrderForAPart(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		homePage.clickQuickOrder().selectOrganization().enterPartNumber(partDetails.getPartNumber()).clickAddToCart();
		Assert.assertTrue(shoppingCartPage.validatePartNumberInCartPage(partDetails.getPartNumber()), "Navigation from Quick Order to Shopping Cart failed");	
		shoppingCartPage.deleteCartItems();

	}
	
// Commenting this TEST for now to run it for Gerber.(28-01-2018) Will revert the changes soon.
//	@Test(dataProvider = "getPartNumber", groups = { "Regression" }, dataProviderClass = TestData.class)
//	public void validateQuickOrderForLegacyPart(PartDetails partDetails)
//			throws InterruptedException {
//
//		System.setProperty("environment", "PROD");
//
//		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
//		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
//		
//		homePage.clickQuickOrder().selectLegacyPartNumber().selectOrganizationForRevFire().enterPartNumber(partDetails.getLegacyPartNumber()).clickAddToCart();
//		Assert.assertTrue(shoppingCartPage.validateLegacyPartNumberInCartPage(partDetails.getLegacyPartNumber()), "Navigation from Quick Order to Shopping Cart failed");		
//		shoppingCartPage.deleteCartItems();
//		
//	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		quickOrderPage = new QuickOrderPage(driverSession, runnerInfo);
		shoppingCartPage = new ShoppingCartPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
