package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.LoginPageObjects;
import com.partspot.pageObjects.OrderHistoryPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class OrderHistoryPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LoginPageObjects loginPageObjects;
    OrderHistoryPageObjects orderHistoryPageObjects;

    public OrderHistoryPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        orderHistoryPageObjects = new OrderHistoryPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, orderHistoryPageObjects);
    }

	public boolean validateOrderHistoryPageLaunch() {
		return runnerInfo.validateOrderHistoryPageLaunch();
	}

	public void selectQuoteAndClickPlaceOrder() {
		runnerInfo.selectQuoteAndClickPlaceOrder();
		
	}
}
