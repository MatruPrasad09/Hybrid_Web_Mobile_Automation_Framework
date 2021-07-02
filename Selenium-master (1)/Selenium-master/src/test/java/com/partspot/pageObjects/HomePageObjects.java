package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {

	@FindBy(xpath = "//span[contains(text(),'Home')]")
    public WebElement home;
	
	@FindBy(xpath = "//span[contains(text(),'Quick Order')]")
    public WebElement quickOrder;

	@FindBy(xpath = "//span[contains(text(),'Shop for Parts')]")
	public WebElement shopForParts;

	@FindBy(xpath = "(//input[contains(@placeholder,'Search for')])[1]")
	public WebElement searchTextBox;
	
	@FindBy(xpath = "(//button[contains(@class,'search-submit')])[1]")
	public WebElement searchSubmit;
	
	@FindBy(xpath = "//button[contains(@class,'add-to-cart')]")
	public WebElement addToCart;

	@FindBy(xpath = "(//div[contains(@class,'card-body')])[1]")
	public WebElement firstPromotion;
	
	@FindBy(id = "navvehicle")
	public WebElement productFamily;
	
	@FindBy(xpath = "//i[contains(@class,'fa fa-chevron-down')]")
	public WebElement userDropDown;
	
	@FindBy(xpath = "//a[contains(@href,'favorite-parts')]")
	public WebElement favoriteParts;
	
	@FindBy(id = "navorder")
	public WebElement orders;
	
	@FindBy(xpath = "(//a[contains(@href,'getOrderHistory?organizationId')])[2]")
	public WebElement selectBrand;
	
	@FindBy(xpath = "//h6[contains(text(),'Gerber Apparel, Furniture, Industrial')]")
	public WebElement selectBrandGerber;
	
}
