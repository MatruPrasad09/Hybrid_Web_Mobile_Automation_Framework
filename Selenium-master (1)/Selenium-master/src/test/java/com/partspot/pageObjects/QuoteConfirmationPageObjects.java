package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteConfirmationPageObjects {
	@FindBy(xpath = "//div[contains(@class,'orderConfirmSummary')]")
	public WebElement orderConfirmSummary;
	
	@FindBy(id = "orderSummaryContainer")
	public WebElement orderSummaryContainer;
}
