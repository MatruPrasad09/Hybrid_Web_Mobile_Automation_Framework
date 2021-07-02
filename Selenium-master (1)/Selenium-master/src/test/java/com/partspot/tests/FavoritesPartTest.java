package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.PartDetails;
import com.partspot.pageActions.FavoritesPage;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.pageActions.ShopForPartsPage;
import com.partspot.pageActions.ShoppingCartPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class FavoritesPartTest {
	
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
	ShopForPartsPage shopForPartsPage;
	FavoritesPage favoritesPage;
	
	@Test(dataProvider = "getPartNumber", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateFavoriteItemFromShopForParts(PartDetails partDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(partDetails.getValidEmailId(), partDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		String partNumberFromShopForParts = homePage.clickShopForParts().selectPartAndAddToFavorites();
		homePage.clickFavoritesPartIcon();
		Assert.assertTrue(favoritesPage.validatePartNumberInFavoritesPage(partNumberFromShopForParts), "Favorites Part Validation from Shop For Parts Failed");
		favoritesPage.removeFavoritesPart();

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		shopForPartsPage = new ShopForPartsPage(driverSession, runnerInfo);
		shoppingCartPage = new ShoppingCartPage(driverSession, runnerInfo);
		favoritesPage = new FavoritesPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
