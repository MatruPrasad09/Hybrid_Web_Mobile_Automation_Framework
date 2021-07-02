package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.CreditCardPageObjects;
import com.partspot.pageObjects.LoginPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class CreditCardPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LoginPageObjects loginPageObjects;
    CreditCardPageObjects creditCardPageObjects;

    public CreditCardPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        creditCardPageObjects = new CreditCardPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, creditCardPageObjects);
    }
    
    public void fillInCreditCardDetailsAndClickPay(String cardType, String cardNumber, String nameOnCard, String month,
			String year, String cvv, String address) {
		runnerInfo.fillInCreditCardDetailsAndClickPay(cardType, cardNumber, nameOnCard, month, year, cvv, address);
		
	}

}
