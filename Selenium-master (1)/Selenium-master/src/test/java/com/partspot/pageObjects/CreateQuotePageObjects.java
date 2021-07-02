package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateQuotePageObjects {
	
	@FindBy(xpath = "//li[contains(text(),'Create Quote')]")
    public WebElement createQuotePageBreadcrumb;
	
	@FindBy(id = "customerDetailsForm")
    public WebElement fillShippingInfo;
	
	@FindBy(id = "js-fill-paymnetinfo-btn")
    public WebElement fillPaymentMethod;
	
	@FindBy(id = "billToAddressName")
	public WebElement billToAddressName;
	
	@FindBy(id = "billToAddressLine1")
	public WebElement billToAddressLine1;
	
	@FindBy(id = "billToAddressCity")
	public WebElement billToAddressCity;
	
	@FindBy(id = "billToAddressZipCode")
	public WebElement billToAddressZipCode;
	
	@FindBy(id = "billToAddressCountry")
	public WebElement billToAddressCountry;
	
	@FindBy(id = "billToStateSelect")
	public WebElement billToAddressState;
		
	@FindBy(xpath = "//button[contains(text(),'Create Quote')]")
    public WebElement createQuote;
}
