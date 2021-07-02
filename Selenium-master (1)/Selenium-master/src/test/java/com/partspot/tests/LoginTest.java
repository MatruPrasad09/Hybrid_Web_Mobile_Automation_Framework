package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.LoginDetails;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class LoginTest {
	
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(dataProvider = "getLoginDetails", groups = { "Regression" }, dataProviderClass = TestData.class)
	public void loginWithValidCredentials(LoginDetails loginDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(loginDetails.getValidEmailId(), loginDetails.getValidPassword());
		Assert.assertTrue(homePage.validateLogin(), "Login Validation Failed");

	}
	
	@Test(dataProvider = "getLoginDetails", groups = { "Regression" }, dataProviderClass = TestData.class)
	public void loginWithInvalidCredentials(LoginDetails loginDetails)
			throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().enterLoginCredentials(loginDetails.getInvalidEmailId(), loginDetails.getInvalidPassword());
		softAssert.assertTrue(loginPage.validateInvalidLogin(), "Login with Invalid credentials failed");
		
		getLandingPage().loadUrl().clickLogin().enterLoginCredentialsWithoutPassword(loginDetails.getValidEmailId());
		softAssert.assertTrue(loginPage.verifyMandatoryField(), "Login without Password failed");
		
		getLandingPage().loadUrl().clickLogin().enterLoginCredentialsWithoutUsername(loginDetails.getValidPassword());
		softAssert.assertTrue(loginPage.verifyMandatoryField(), "Login without Username failed");

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
