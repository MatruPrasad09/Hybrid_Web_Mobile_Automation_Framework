package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.PartDetails;
import com.partspot.pageActions.CheckOutPage;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.pageActions.OrderConfirmationPage;
import com.partspot.pageActions.OrderHistoryPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class QuoteToOrderTest {
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	CheckOutPage checkOutPage;
	OrderConfirmationPage orderConfirmationPage;
	OrderHistoryPage orderHistoryPage;
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateQuoteCreation(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().handleCookie().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		homePage.clickOrders().selectQuoteAndClickPlaceOrder();
		checkOutPage.fillInCheckoutDetailsAndClickPlaceOrder();
		
		Assert.assertTrue(orderConfirmationPage.validateOrderCreation(), "Order Creation Failed");

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		orderHistoryPage = new OrderHistoryPage(driverSession, runnerInfo);
		checkOutPage = new CheckOutPage(driverSession, runnerInfo);
		orderConfirmationPage = new OrderConfirmationPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
