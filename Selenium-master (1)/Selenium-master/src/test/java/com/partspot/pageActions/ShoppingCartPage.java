package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.ShoppingCartPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class ShoppingCartPage {
    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    ShoppingCartPageObjects shoppingCartPageObjects;

    public ShoppingCartPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        shoppingCartPageObjects = new ShoppingCartPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, shoppingCartPageObjects);
    }

	public boolean validatePartNumberInCartPage(String partNo) {
		return runnerInfo.validatePartNumberInCartPage(partNo);
	}
	
	public boolean validateLegacyPartNumberInCartPage(String legacyPartNo) {
		return runnerInfo.validateLegacyPartNumberInCartPage(legacyPartNo);
	}

	public void deleteCartItems() {
		runnerInfo.deleteCartItems();
		
	}

	public CheckOutPage clickSecureCheckout() {
		runnerInfo.clickSecureCheckout();
		return new CheckOutPage(webDriver, runnerInfo);
		
	}
	
	public ShoppingCartPage clickSecureCheckoutGuest() {
		runnerInfo.clickSecureCheckout();
		return new ShoppingCartPage(webDriver, runnerInfo);
		
	}
	
	public CreateQuotePage clickRequestForQuote() {
		runnerInfo.clickRequestForQuote();
		return new CreateQuotePage(webDriver, runnerInfo);
	}

	public ShoppingCartPage clickRequestForQuoteGuest() {
		runnerInfo.clickRequestForQuote();
		return new ShoppingCartPage(webDriver, runnerInfo);
	}

	public CheckOutPage clickContinueAsGuestBtn() {
		runnerInfo.clickContinueAsGuestBtn();
		return new CheckOutPage(webDriver, runnerInfo);
	}
	
	public CreateQuotePage clickContinueAsGuestBtnQuote() {
		runnerInfo.clickContinueAsGuestBtn();
		return new CreateQuotePage(webDriver, runnerInfo);
	}
	
	public FullItemDetailsPage clickAPart() {
		runnerInfo.clickAPart();
		return new FullItemDetailsPage(webDriver, runnerInfo);
		
	}

}
