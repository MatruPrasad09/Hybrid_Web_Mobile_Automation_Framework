package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopForPartsPageObjects {
	@FindBy(xpath = "(//a[contains(@class,'productCatalogClick')])[1]")
    public WebElement selectFirstCatalog;
	
	@FindBy(xpath = "(//div[@class='productCatalogClick ng-binding'])[1]")
    public WebElement selectFirstCatalogGerber;
		
	@FindBy(xpath = "(//button[contains(@class,'add-to-cart')])[1]")
	public WebElement selectFirstAddToCart;

	@FindBy(xpath = "(//h6[contains(@ng-if,'superseededItem')])[1]")
	public WebElement firstPartNumber;
	
	@FindBy(xpath = "(//i[contains(@class,'shopping-cart')])[2]")
	public WebElement cartIcon;
	
	@FindBy(xpath = "(//a[contains(@title,'Favorites')])[1]")
	public WebElement selectFirstFavoriteIcon;
	
	@FindBy(xpath = "(//div[@class='productCatalogClick ng-binding'])[1]")
	public WebElement selectBrandShopforPart;
}
