package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromotionsPageObjects {

	@FindBy(xpath = "(//button[contains(@class,'add-to-cart')])[1]")
    public WebElement addToCart;
    		
    @FindBy(xpath = "(//h6[contains(@class,'cart_grid_helper_text')])[1]")
    public WebElement firstPartNumber;

}
