package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPageObjects {
	@FindBy(xpath = "//h2[contains(text(),'Your Order History')]")
    public WebElement orderHistoryBreadCrumb;
	
	@FindBy(id = "orderOptionMain")
    public WebElement orderOptions;
	
	@FindBy(xpath = "//span[contains(text(),'Quote,Order,Invoice')]")
    public WebElement documentTypeDropDown;
	
	@FindBy(xpath = "//label[contains(text(),'Order')]")
    public WebElement orderDropdown;
	
	@FindBy(xpath = "//label[contains(text(),'Invoice')]")
    public WebElement invoiceDropdown;
	
	@FindBy(xpath = "//span[contains(text(),'All selected')]")
    public WebElement statusDropDown;
	
	@FindBy(xpath = "//label[contains(text(),'ALL')]")
    public WebElement allStatus;
	
	@FindBy(xpath = "//label[contains(text(),'OPEN')]")
    public WebElement openStatus;
	
	@FindBy(id = "buttonFilterDefault")
    public WebElement applyFilter;
	
	@FindBy(xpath = "//a[contains(@class,'dotsoption')]")
    public WebElement dotsOption;
	
	@FindBy(xpath = "(//a[@id= 'childId'])[1]")
    public WebElement placeOrder;
}
