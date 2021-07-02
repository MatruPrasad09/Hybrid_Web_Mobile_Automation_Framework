package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuestHomePageObjects {

	@FindBy(linkText = "Register")
    public WebElement register;
	
	@FindBy(linkText = "Login")
    public WebElement login;
	
	@FindBy(id = "CybotCookiebotDialogBodyLevelButtonAccept")
	public WebElement cookieOkBtn;
}
