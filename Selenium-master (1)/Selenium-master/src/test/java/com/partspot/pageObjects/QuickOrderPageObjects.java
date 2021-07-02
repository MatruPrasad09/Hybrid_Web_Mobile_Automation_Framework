package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickOrderPageObjects {
	@FindBy(id = "rev_radio")
    public WebElement selectRevPart;
	
	@FindBy(xpath = "//label[@for='legacy_radio']")
    public WebElement selectLegacyPart;
	
	@FindBy(id = "organizationSelection")
    public WebElement selectOrganizationDropDown;
	
	@FindBy(id = "part_0")
    public WebElement partNotextBox;
	
	@FindBy(id = "qty_0")
    public WebElement enterQuantity;
	
//	@FindBy(xpath = "//button[contains(@class,'add-to-cart')]")
//  public WebElement clickAddToCart;
	
	@FindBy(id = "quickOrderFormBtn")
    public WebElement clickAddToCart;
	
	
}
