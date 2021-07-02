package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.GuestHomePageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.URLGetter;

public class GuestHomePage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    GuestHomePageObjects guesthomePageObjects;

    public GuestHomePage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        guesthomePageObjects = new GuestHomePageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, guesthomePageObjects);
    }
	
    public GuestHomePage loadUrl () {

        URLGetter urlGetter = new URLGetter();

         String url = urlGetter.getURLs(System.getProperty("IMPLEMENTATION"));
         webDriver.get(url);

        return this;
    }
    
    public GuestHomePage handleCookie() {
    	runnerInfo.handleCookie();
		return new GuestHomePage(webDriver, runnerInfo);
    }

	public RegistrationPage clickRegister() {
		runnerInfo.clickRegister();
		return new RegistrationPage(webDriver, runnerInfo);
	}

	public LoginPage clickLogin() {
		runnerInfo.clickLogin();
		return new LoginPage(webDriver, runnerInfo);
	}
	
	public boolean validateGuestHomePage() {
		return runnerInfo.validateGuestHomePage();
	}

	
}
