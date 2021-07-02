package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPageObjects {
	@FindBy(xpath = "//li[contains(text(),'Checkout')]")
    public WebElement checkoutPageBreadcrumb;
	
	@FindBy(id = "poNumber")
    public WebElement poNumber;
	
	@FindBy(id = "customerDetailsForm")
    public WebElement fillShippingInfo;
	
	@FindBy(id = "js-fill-paymnetinfo-btn")
    public WebElement fillPaymentMethod;	
	
	@FindBy(id = "salesCodeSelect")
    public WebElement paymentTypeDropDown;
	
	@FindBy(xpath = "//option[contains(text(), 'Credit Card')]")
	public WebElement selectCC;
	
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
    public WebElement placeOrder;
	
	@FindBy(id = "js-checkout-creditcardbtn")
    public WebElement continueToCardDetails;
	
	@FindBy(id = "customerNameSelect")
	public WebElement customerName;
	
	@FindBy(id = "refNum")
	public WebElement referenceNumber;
	
	@FindBy(id = "contactEmailInput")
	public WebElement contactEmail;
	
	@FindBy(id = "shipToAddressName")
	public WebElement addressName;
	
	@FindBy(id = "shipToAddressLine1")
	public WebElement addressLine1;
	
	@FindBy(id = "shipToAddressCity")
	public WebElement city;
	
	@FindBy(id = "shipToAddressZipCode")
	public WebElement zipCode;
	
	@FindBy(id = "shipToAddressCountry")
	public WebElement selectCountry;
	
	@FindBy(id = "stateSelect")
	public WebElement selectState;

	@FindBy(id = "salesCodeSelect")
	public WebElement selectPaymentMethod;
	
	@FindBy(id = "js-checkout-creditcardbtn")
	public WebElement continueToCardDetailsBtn;
	
	@FindBy(id= "phone")
	public WebElement phoneNumber;
	
	
}
