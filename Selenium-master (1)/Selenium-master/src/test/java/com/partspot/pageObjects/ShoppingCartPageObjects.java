package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageObjects {
	@FindBy(xpath = "(//div[contains(@class,'cart_grid_helper_text')])[1]")
    public WebElement partNumber;
	
	@FindBy(xpath = "(//a[@href = \"javascript:void(0)\"])[2]")
	public WebElement gerberPartInCart;
	
	@FindBy(xpath = "(//div[contains(@class,'cart_grid_helper_text')])[2]")
	public WebElement legacyPartNumber;
	
	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	public WebElement emptyCart;
	
	@FindBy(xpath = "//a[contains(text(),'Empty Cart')]")
	public WebElement emptyCartPopUp;
	
	@FindBy(xpath = "//button[contains(text(),'Secure checkout')]")
	public WebElement secureCheckout;
	
	@FindBy(xpath = "//button[contains(text(),'Create Quote')]")
	public WebElement requestForQuote;
	
	@FindBy(id = "checkoutContinueGuestButton")
	public WebElement continueGuestButton;
}
