package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FullItemDetailsPageObjects {
	
	@FindBy(xpath = "(//a[@href = 'shop-parts'])[2]")
    public WebElement fullItemBreadCrumb;
}



