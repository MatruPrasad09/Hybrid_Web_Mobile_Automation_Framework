package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.CheckOutPageObjects;
import com.partspot.pageObjects.CreditCardPageObjects;
import com.partspot.pageObjects.LoginPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class CheckOutPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LoginPageObjects loginPageObjects;
    CheckOutPageObjects checkOutPageObjects;
    CreditCardPageObjects creditCardPageObjects;
    CreditCardPage creditCardPage;

    public CheckOutPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        checkOutPageObjects = new CheckOutPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, checkOutPageObjects);
    }

	public void fillInCheckoutDetailsAndClickPlaceOrder() {
		runnerInfo.fillInCheckoutDetailsAndClickPlaceOrder();
		
	}
	
	public CreditCardPage fillInGuestCheckoutDetailsAndClickPlaceOrder(String nameOnCard, String poNumber, String email,String guestAddress, 
			String city, String zipCode, String country, String state) {
		runnerInfo.fillInGuestCheckoutDetailsAndClickPlaceOrder(nameOnCard, poNumber, email, guestAddress, city, zipCode, country, state );
		return new CreditCardPage(webDriver, runnerInfo);
	}
	
	public CreditCardPage fillInCheckoutDetailsWithCreditCardOptionAndClickContinueToCardDetails() {
		runnerInfo.fillInCheckoutDetailsWithCreditCardOptionAndClickContinueToCardDetails();
		return new CreditCardPage(webDriver, runnerInfo);
	}
}
