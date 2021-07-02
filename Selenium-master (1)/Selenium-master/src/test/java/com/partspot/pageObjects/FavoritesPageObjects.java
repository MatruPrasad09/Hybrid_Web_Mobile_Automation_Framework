package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPageObjects {
	@FindBy(xpath = "(//h6[contains(@class,'cart_grid_helper_text')])[2]")
    public WebElement partNumber;
    
	@FindBy(xpath = "//i[contains(@class,'remove-favorite-item')]")
    public WebElement removeFavoritePart;
}
