package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.partspot.entities.LoginDetails;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.ShopForPartsPage;
import com.partspot.pageActions.ShoppingCartPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class FullItemDetailsTest {
	HomePage homePage;
	
	ShopForPartsPage shopForPartsPage;
	ShoppingCartPage shoppingCartPage;
	
	@Test(dataProvider = "getLoginDetails", groups = { "Regression" }, dataProviderClass = TestData.class)
	public void validateFullItemDetailsPageNavigation(LoginDetails loginDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(loginDetails.getValidEmailId(), loginDetails.getValidPassword());
		Assert.assertTrue(homePage.clickShopForParts().selectPartAndAddToCart2().clickAPart().validateFullItemsDetailsPage());	
		homePage.clickCartIcon().deleteCartItems();

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		shopForPartsPage = new ShopForPartsPage(driverSession, runnerInfo);
		shoppingCartPage = new ShoppingCartPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
