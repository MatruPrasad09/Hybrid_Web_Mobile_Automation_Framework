package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.LoginPageObjects;
import com.partspot.pageObjects.OrderConfirmationPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class OrderConfirmationPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LoginPageObjects loginPageObjects;
    OrderConfirmationPageObjects orderConfirmationPageObjects;

    public OrderConfirmationPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        orderConfirmationPageObjects = new OrderConfirmationPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, orderConfirmationPageObjects);
    }
    
	public boolean validateOrderCreation() {
		return runnerInfo.validateOrderCreation();
	}

}
