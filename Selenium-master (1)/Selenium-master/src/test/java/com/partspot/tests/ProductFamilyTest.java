package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.LoginDetails;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.pageActions.ProductFamilyPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class ProductFamilyTest {

	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	ProductFamilyPage productFamilyPage;
	
	@Test(dataProvider = "getLoginDetails", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void validateProductFamilyPage(LoginDetails loginDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(loginDetails.getValidEmailId(), loginDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");
		
		Assert.assertTrue(homePage.clickProductFamily().validateProductFamilyPage(), "Product Family Page Validation Failed");
		Assert.assertTrue(productFamilyPage.clickPartNumber().validateBomPage(), "BOM Page Validation Failed");	

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		productFamilyPage = new ProductFamilyPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
