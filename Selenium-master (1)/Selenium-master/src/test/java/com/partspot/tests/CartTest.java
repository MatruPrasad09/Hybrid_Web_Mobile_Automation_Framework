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
import com.partspot.pageActions.ShopForPartsPage;
import com.partspot.pageActions.ShoppingCartPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class CartTest {
	
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	QuickOrderPage quickOrderPage;
	ShopForPartsPage shopForPartsPage;
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateCartItemFromShopForParts(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		String partNumberFromShopForParts = homePage.clickShopForParts().selectPartAndAddToCart();
		Assert.assertTrue(homePage.validateCartNotificationForPart(), "Cart Notification failed");
		homePage.clickCartIcon();
		Assert.assertTrue(shoppingCartPage.validatePartNumberInCartPage(partNumberFromShopForParts), "Shopping Cart Validation from Shop For Parts Failed");	
		shoppingCartPage.deleteCartItems();

	}
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" }, dataProviderClass = TestData.class)
	public void validateCartItemFromGlobalSearch(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		homePage.enterPartInGlobalSearchAndAddToCart(partDetails.getPartNumber());
		Assert.assertTrue(homePage.validateCartNotificationForPart(), "Cart Notification failed");
		homePage.clickCartIcon();
		Assert.assertTrue(shoppingCartPage.validatePartNumberInCartPage(partDetails.getPartNumber()), "Shopping Cart Validation from Global Search Failed");	
		shoppingCartPage.deleteCartItems();

	}
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" }, dataProviderClass = TestData.class)
	public void validateCartItemFromPromotions(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		String partNumberFromPromotions = homePage.selectPromotions().clickAddToCartForAPart();
		Assert.assertTrue(homePage.validateCartNotificationForPart(), "Cart Notification failed");
		homePage.clickCartIcon();
		Assert.assertTrue(shoppingCartPage.validatePartNumberInCartPage(partNumberFromPromotions), "Shopping Cart Validation from Global Search Failed");	
		shoppingCartPage.deleteCartItems();

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		quickOrderPage = new QuickOrderPage(driverSession, runnerInfo);
		shopForPartsPage = new ShopForPartsPage(driverSession, runnerInfo);
		shoppingCartPage = new ShoppingCartPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
