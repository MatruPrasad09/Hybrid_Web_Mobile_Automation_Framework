package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.CreditCardDetails;
import com.partspot.entities.PartDetails;
import com.partspot.pageActions.CreateQuotePage;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.pageActions.QuoteConfirmationPage;
import com.partspot.pageActions.ShopForPartsPage;
import com.partspot.pageActions.ShoppingCartPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class QuoteTest {
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	GuestHomePage guesthomepage;
	ShoppingCartPage shoppingCartPage;
	ShopForPartsPage shopForPartsPage;
	CreateQuotePage createQuotePage;
	QuoteConfirmationPage quoteConfirmationPage;
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateQuoteCreation(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().handleCookie().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		homePage.clickShopForParts().selectPartAndAddToCart();
		homePage.clickCartIcon().clickRequestForQuote().fillInRequestForQuoteDetailsAndClickCreateQuote();
		
		Assert.assertTrue(quoteConfirmationPage.validateQuoteCreation(), "Quote Creation Failed");

	}
	
//	@Test(dataProvider = "getCreditCardDetails", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
//	public void validateGuestQuoteCreation(CreditCardDetails creditCardDetails)
//			throws InterruptedException {
//
//		System.setProperty("environment", "PROD");
//
//		getLandingPage().loadUrl().handleCookie();
//		
//		Assert.assertTrue(guesthomepage.validateGuestHomePage(), "Guest Homepage Validation Failed");
//		
//		homePage.clickShopForParts().selectPartAndAddToCart();
//		homePage.clickCartIcon().clickRequestForQuoteGuest().clickContinueAsGuestBtnQuote().fillInGuestDetailsAndClickCreateQuote(creditCardDetails.getNameOnCard(), creditCardDetails.getValidEmailId(), creditCardDetails.getGuestAddress(), 
//				creditCardDetails.getCity(), creditCardDetails.getZipCode(), creditCardDetails.getCountry(), creditCardDetails.getState());
//		
//		Assert.assertTrue(quoteConfirmationPage.validateQuoteCreation(), "Quote Creation Failed");
//
//	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		guesthomepage = new GuestHomePage(driverSession, runnerInfo);
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		shopForPartsPage = new ShopForPartsPage(driverSession, runnerInfo);
		shoppingCartPage = new ShoppingCartPage(driverSession, runnerInfo);
		createQuotePage = new CreateQuotePage(driverSession, runnerInfo);
		quoteConfirmationPage = new QuoteConfirmationPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}

}
