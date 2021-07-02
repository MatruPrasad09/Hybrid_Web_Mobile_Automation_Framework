package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.ForgotPasswordPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class ForgotPasswordPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    ForgotPasswordPageObjects forgotPasswordPageObjects;

    public ForgotPasswordPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        forgotPasswordPageObjects = new ForgotPasswordPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, forgotPasswordPageObjects);
    }

	public void enterEmail(String emailId) {
		runnerInfo.enterEmailId(emailId);
		
	}

	public void clickSubmitWithoutEmailId() {
		runnerInfo.clickSubmitWithoutEmailId();
		
	}

	public boolean validateBlankPasswordErrorMsg() {
		return runnerInfo.validateBlankPasswordErrorMsg();
	}

	public boolean validateInvalidEmailFormatErrorMsg() {
		return runnerInfo.validateInvalidEmailFormatErrorMsg();
	}
}
