package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.HomePageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class HomePage {
	
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    HomePageObjects homePageObjects;

    public HomePage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        homePageObjects = new HomePageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, homePageObjects);
    }

	public boolean validateLogin() {
		return runnerInfo.validateLogin();
	}

	public QuickOrderPage clickQuickOrder() {
		runnerInfo.clickQuickOrder();
		return new QuickOrderPage(webDriver, runnerInfo);
		
	}

	public ShopForPartsPage clickShopForParts() {
		runnerInfo.clickShopForParts();
		return new ShopForPartsPage(webDriver, runnerInfo);
	}

	public boolean validateCartNotificationForPart() {
		return runnerInfo.validateCartNotificationForPart();
	}

	public void enterPartInGlobalSearchAndAddToCart(String partNumber) {
		runnerInfo.enterPartInGlobalSearchAndAddToCart(partNumber);
		
	}

	public PromotionsPage selectPromotions() {
		runnerInfo.selectPromotions();
		return new PromotionsPage(webDriver, runnerInfo);
	}
	
	public ShoppingCartPage clickCartIcon() {
		 runnerInfo.clickCartIcon();
		 return new ShoppingCartPage(webDriver, runnerInfo);
	}

	public ProductFamilyPage clickProductFamily() {
		runnerInfo.clickProductFamily();
		return new ProductFamilyPage(webDriver, runnerInfo);
	}

	public void clickFavoritesPartIcon() {
		 runnerInfo.clickFavoritesPartIcon();
		
	}

	public OrderHistoryPage clickOrders() {
		runnerInfo.clickOrders();
		return new OrderHistoryPage(webDriver, runnerInfo);
	}

}
