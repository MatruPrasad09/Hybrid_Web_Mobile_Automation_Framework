package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFamilyPageObjects {
	
	@FindBy(id = "searchFilterstxt")
    public WebElement searchFilter;
	
	@FindBy(id = "keyword")
    public WebElement partSearchBar;
	
	@FindBy(xpath = "//li[contains(@class,'breadcrumb-item active')]")
    public WebElement breadCrumb;
	
	@FindBy(xpath = "(//img[contains(@ng-click,'viewMachine')])[1]")
    public WebElement firstPartNumber;
}
