package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.CreateQuotePageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class CreateQuotePage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    CreateQuotePageObjects createQuotePageObjects;

    public CreateQuotePage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        createQuotePageObjects = new CreateQuotePageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, createQuotePageObjects);
    }

	public void fillInRequestForQuoteDetailsAndClickCreateQuote() {
		runnerInfo.fillInRequestForQuoteDetailsAndClickCreateQuote();
		
	}

	public void fillInGuestDetailsAndClickCreateQuote(String nameOnCard, String email,String guestAddress, 
			String city, String zipCode, String country, String state) {
		runnerInfo.fillInGuestDetailsAndClickCreateQuote(nameOnCard, email, guestAddress, city, zipCode, country, state);
		
	}
}
