package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.FullItemDetailsPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class FullItemDetailsPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    FullItemDetailsPageObjects fullItemDetailsPageObjects;

    public FullItemDetailsPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        fullItemDetailsPageObjects = new FullItemDetailsPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, fullItemDetailsPageObjects);
    }

	public boolean validateFullItemsDetailsPage() {
		return runnerInfo.validateFullItemsDetailsPage();
		
	}
}
