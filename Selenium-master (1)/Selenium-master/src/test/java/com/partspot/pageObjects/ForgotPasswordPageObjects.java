package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPageObjects {
	
	@FindBy(id = "email_forgot")
    public WebElement emailId;
	
	@FindBy(id = "forgot-password-submit")
    public WebElement forgotPasswordSubmit;
	
	@FindBy(xpath = "//li[contains(text(),'This value is required.')]")
    public WebElement blankEmailIdFieldErrorMsg;
	
	@FindBy(xpath = "//li[contains(text(),'This value should be a valid email.')]")
    public WebElement invalidFormatEmailIdFieldErrorMsg;
}
