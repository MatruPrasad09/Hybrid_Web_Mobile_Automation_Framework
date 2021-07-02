package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardPageObjects {
	
	@FindBy(xpath = "//a[contains(text(),'Add New Credit')]")
    public WebElement addNewCard;
	
	@FindBy(id = "c-ct")
    public WebElement cardType;
	
	@FindBy(id = "c-cardnumber")
    public WebElement cardNumber;
	
	@FindBy(id = "c-cardname")
    public WebElement nameOnCard;
	
	@FindBy(id = "c-exmth")
    public WebElement selectMonth;
	
	@FindBy(id = "c-exyr")
    public WebElement selectYear;
	
	@FindBy(id = "choose-address")
    public WebElement selectAddress;
	
	@FindBy(id = "c-cvv")
    public WebElement cvv;
	
	@FindBy(xpath = "//button[contains(text(),'Pay')]")
    public WebElement pay;
	
	
	
}
