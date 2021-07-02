package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

	@FindBy(linkText = "Forgot password?")
    public WebElement forgotPassword;
	
	@FindBy(id = "userName")
    public WebElement username;
	
	@FindBy(id = "passwordLogin")
    public WebElement password;
	
	@FindBy(id = "loginUser")
    public WebElement submit;
	
	@FindBy(xpath = "//p[contains(text(),'Invalid username or password')]")
    public WebElement loginFailMsg;
	
    @FindBy(xpath = "//li[contains(text(),'This value is required.')]")
    public WebElement mandatoryFieldErrorMsg;
}
