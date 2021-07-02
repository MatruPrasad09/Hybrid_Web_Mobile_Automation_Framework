package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.ConfirmationPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class ConfirmationPage {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    ConfirmationPageObjects confirmationPageObjects;

    public ConfirmationPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        confirmationPageObjects = new ConfirmationPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, confirmationPageObjects);
    }

    public Boolean verifyRegistration () {
    	return runnerInfo.verifyRegistration();
    	
    }

	public boolean validateForgotPassword() {
		return runnerInfo.validateForgotPassword();
	}
}
