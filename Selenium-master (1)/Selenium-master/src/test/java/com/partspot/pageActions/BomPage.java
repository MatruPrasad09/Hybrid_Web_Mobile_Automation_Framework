package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.BomPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class BomPage {

	 WebDriver webDriver;
	    DeviceHelper deviceHelper;
	    DeviceInterface runnerInfo;
	    BomPageObjects bomPageObjects;

	    public BomPage ( WebDriver driver, DeviceInterface runnerInfo ) {
	        this.webDriver = driver;
	        deviceHelper = new DeviceHelper(driver);
	        bomPageObjects = new BomPageObjects();

	        this.runnerInfo = runnerInfo;

	        PageFactory.initElements(driver, this);
	        PageFactory.initElements(driver, bomPageObjects);
	    }
	    
	public boolean validateBomPage() {
		return runnerInfo.validateBomPage();
	}

}
