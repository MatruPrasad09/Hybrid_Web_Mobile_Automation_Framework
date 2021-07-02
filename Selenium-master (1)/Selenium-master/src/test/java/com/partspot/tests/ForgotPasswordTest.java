package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.ForgotPasswordDetails;
import com.partspot.pageActions.ConfirmationPage;
import com.partspot.pageActions.ForgotPasswordPage;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class ForgotPasswordTest {

	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage;
	HomePage homePage;
	ConfirmationPage confirmationPage;
	ForgotPasswordPage forgotPasswordPage;
	
	@Test(dataProvider = "getForgotPasswordDetails", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
	public void forgotPasswordWithValidAndInvalidEmailId(ForgotPasswordDetails forgotPasswordDetails)
		throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().clickForgotPassword().enterEmail(forgotPasswordDetails.getEmailId());
		softAssert.assertTrue(confirmationPage.validateForgotPassword(), "Forgot Password Validation Failed");
		
		getLandingPage().loadUrl().clickLogin().clickForgotPassword().enterEmail(forgotPasswordDetails.getInvalidEmailId());
		softAssert.assertTrue(confirmationPage.validateForgotPassword(), "Forgot Password Validation Failed");

	}

	@Test(dataProvider = "getForgotPasswordDetails", groups = { "Regression" }, dataProviderClass = TestData.class)
	public void forgotPasswordBlankAndInvalidEmailId(ForgotPasswordDetails forgotPasswordDetails) throws InterruptedException {

		System.setProperty("environment", "PROD");

		getLandingPage().loadUrl().clickLogin().clickForgotPassword().clickSubmitWithoutEmailId();
		softAssert.assertTrue(forgotPasswordPage.validateBlankPasswordErrorMsg(),
				"Forgot Password Validation with Blank EmailId Failed");
		
		getLandingPage().loadUrl().clickLogin().clickForgotPassword().enterEmail(forgotPasswordDetails.getInvalidFormatEmailId());
		softAssert.assertTrue(forgotPasswordPage.validateInvalidEmailFormatErrorMsg(), "Forgot Password Validation Failed");

	}
	
	GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		confirmationPage = new ConfirmationPage(driverSession, runnerInfo);
		forgotPasswordPage = new ForgotPasswordPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	}
}
