package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.ShopForPartsPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class ShopForPartsPage {

	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    ShopForPartsPageObjects shopForPartsPageObjects;
    
	public ShopForPartsPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        shopForPartsPageObjects = new ShopForPartsPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, shopForPartsPageObjects);
    }

	public String selectPartAndAddToCart() {
		return runnerInfo.selectPartAndAddToCart();
		
	}

	public String selectPartAndAddToFavorites() {
		return runnerInfo.selectPartAndAddToFavorites();
	}
	
		public ShoppingCartPage selectPartAndAddToCart2() {
		runnerInfo.selectPartAndAddToCart2();
		return new ShoppingCartPage(webDriver,runnerInfo);
	}
}
