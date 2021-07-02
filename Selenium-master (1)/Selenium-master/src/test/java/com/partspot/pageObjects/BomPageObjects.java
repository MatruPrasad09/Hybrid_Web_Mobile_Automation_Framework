package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BomPageObjects {
	@FindBy(id = "treemachine-catalog")
    public WebElement machineCatalogTree;
	
	@FindBy(id = "fullitemsMediaContainer")
    public WebElement fullItemsMediaContainer;
	
	@FindBy(id = "catalogBOM")
    public WebElement catalogBOM;
}
