package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Thanks for submitting your information!')]")
    public WebElement registrationConfirmationMessage;

    @FindBy(xpath = "//p[contains(text(),'We have received your information and are reviewing it')]")
    public WebElement confirmationMessage;
    
    @FindBy(xpath = "//p[contains(text(),'sent a message to')]")
    public WebElement forgotPasswordConfirmationMessage;

}

