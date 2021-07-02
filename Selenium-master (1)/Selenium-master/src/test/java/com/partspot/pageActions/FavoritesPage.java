package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.FavoritesPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class FavoritesPage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    FavoritesPageObjects favoritesPageObjects;

    public FavoritesPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        favoritesPageObjects = new FavoritesPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, favoritesPageObjects);
    }

	public boolean validatePartNumberInFavoritesPage(String partNumberFromShopForParts) {
		return runnerInfo.validatePartNumberInFavoritesPage(partNumberFromShopForParts);
	}

	public void removeFavoritesPart() {
		runnerInfo.removeFavoritesPart();
		
	}
}
