package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.LoginPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class LoginPage {

	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LoginPageObjects loginPageObjects;

    public LoginPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        loginPageObjects = new LoginPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, loginPageObjects);
    }

	public ForgotPasswordPage clickForgotPassword() {
		runnerInfo.clickForgotPassword();
		return new ForgotPasswordPage(webDriver, runnerInfo);
	}

	public void enterLoginCredentials(String emailId, String password) {
		runnerInfo.enterValidLoginCredentials(emailId, password);
		
	}

	public boolean validateInvalidLogin() {
		return runnerInfo.validateInvalidLogin();
	}

	public void enterLoginCredentialsWithoutPassword(String validEmailId) {
		runnerInfo.enterLoginCredentialsWithoutPassword(validEmailId);
		
	}

	public void enterLoginCredentialsWithoutUsername(String validPassword) {
		runnerInfo.enterLoginCredentialsWithoutUsername(validPassword);
		
	}

	public boolean verifyMandatoryField() {
		return runnerInfo.verifyMandatoryField();
	}
}
