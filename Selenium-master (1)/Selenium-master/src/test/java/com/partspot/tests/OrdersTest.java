package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.CreditCardDetails;
import com.partspot.entities.PartDetails;
import com.partspot.pageActions.CheckOutPage;
import com.partspot.pageActions.CreditCardPage;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.pageActions.OrderConfirmationPage;
import com.partspot.pageActions.ShopForPartsPage;
import com.partspot.pageActions.ShoppingCartPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class OrdersTest {
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	ShopForPartsPage shopForPartsPage;
	CheckOutPage checkOutPage;
	CreditCardPage creditCardPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateOrderCreation(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().handleCookie().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		homePage.clickShopForParts().selectPartAndAddToCart();
		homePage.clickCartIcon().clickSecureCheckout().fillInCheckoutDetailsAndClickPlaceOrder();
		
		Assert.assertTrue(orderConfirmationPage.validateOrderCreation(), "Order Creation Failed");

	}
	
//	@Test(dataProvider = "getCreditCardDetails", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
//	public void validateGuestOrderCreation(CreditCardDetails creditCardDetails)
//			throws InterruptedException {
//
//		System.setProperty("environment", "PROD");
//
//		getLandingPage().loadUrl().handleCookie();
//		
//		homePage.clickShopForParts().selectPartAndAddToCart();
//		homePage.clickCartIcon().clickSecureCheckoutGuest().clickContinueAsGuestBtn()
//		.fillInGuestCheckoutDetailsAndClickPlaceOrder(creditCardDetails.getNameOnCard(), creditCardDetails.getPoNumber(), creditCardDetails.getValidEmailId(), creditCardDetails.getGuestAddress(), 
//				creditCardDetails.getCity(), creditCardDetails.getZipCode(), creditCardDetails.getCountry(), creditCardDetails.getState())
//		.fillInCreditCardDetailsAndClickPay(creditCardDetails.getCardType(), creditCardDetails.getCardNumber(), creditCardDetails.getNameOnCard(), creditCardDetails.getMonth(), creditCardDetails.getYear(), creditCardDetails.getCvv(), creditCardDetails.getAddress());
//		
//		Assert.assertTrue(orderConfirmationPage.validateOrderCreation(), "Order Creation Failed");
//
//	}
	
		
	@Test(dataProvider = "getCreditCardDetails", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateOrderCreationCreditCard(CreditCardDetails creditCardDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().handleCookie().clickLogin().enterLoginCredentials(creditCardDetails.getValidEmailId(), creditCardDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		homePage.clickShopForParts().selectPartAndAddToCart();
		homePage.clickCartIcon().clickSecureCheckout().fillInCheckoutDetailsWithCreditCardOptionAndClickContinueToCardDetails().fillInCreditCardDetailsAndClickPay(creditCardDetails.getCardType(), creditCardDetails.getCardNumber(), creditCardDetails.getNameOnCard(), creditCardDetails.getMonth(), creditCardDetails.getYear(), creditCardDetails.getCvv(), creditCardDetails.getAddress());
		
		Assert.assertTrue(orderConfirmationPage.validateOrderCreation(), "Order Creation Failed");

	}
	
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		shopForPartsPage = new ShopForPartsPage(driverSession, runnerInfo);
		shoppingCartPage = new ShoppingCartPage(driverSession, runnerInfo);
		checkOutPage = new CheckOutPage(driverSession, runnerInfo);
		orderConfirmationPage = new OrderConfirmationPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}

}
