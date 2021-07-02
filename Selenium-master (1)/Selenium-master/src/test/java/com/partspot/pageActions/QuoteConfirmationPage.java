package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.QuoteConfirmationPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class QuoteConfirmationPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    QuoteConfirmationPageObjects quoteConfirmationPageObjects;

    public QuoteConfirmationPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        quoteConfirmationPageObjects = new QuoteConfirmationPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, quoteConfirmationPageObjects);
    }

	public boolean validateQuoteCreation() {
		return runnerInfo.validateQuoteCreation();
	}
}
