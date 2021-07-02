package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.ProductFamilyPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class ProductFamilyPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    ProductFamilyPageObjects productFamilyPageObjects;

    public ProductFamilyPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        productFamilyPageObjects = new ProductFamilyPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, productFamilyPageObjects);
    }

	public BomPage clickPartNumber() {
		runnerInfo.clickPartNumber();
		return new BomPage(webDriver, runnerInfo);
	}

	public boolean validateProductFamilyPage() {
		return runnerInfo.validateProductFamilyPage();
	}
}
