package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.QuickOrderPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class QuickOrderPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    QuickOrderPageObjects quickOrderPageObjects;

    public QuickOrderPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        quickOrderPageObjects = new QuickOrderPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, quickOrderPageObjects);
    }

	public QuickOrderPage selectLegacyPartNumber() {
		runnerInfo.selectLegacyPartNumber();
		return new QuickOrderPage(webDriver, runnerInfo);
	}

	public QuickOrderPage selectOrganization() {
		runnerInfo.selectOrganization();
		return new QuickOrderPage(webDriver, runnerInfo);
	}
	
	public QuickOrderPage selectOrganizationForRevFire() {
		runnerInfo.selectOrganizationForRevFire();
		return new QuickOrderPage(webDriver, runnerInfo);
	}

	public QuickOrderPage enterPartNumber(String partNumber) {
		runnerInfo.enterPartNumber(partNumber);
		return new QuickOrderPage(webDriver, runnerInfo);
	}

	public ShoppingCartPage clickAddToCart() {
		runnerInfo.clickAddToCart();
		return new ShoppingCartPage(webDriver, runnerInfo);
		
	}
}
