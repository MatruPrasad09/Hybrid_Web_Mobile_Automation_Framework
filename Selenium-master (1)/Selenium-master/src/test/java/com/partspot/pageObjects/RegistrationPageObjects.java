package com.partspot.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageObjects {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "firstName")
    public WebElement m_firstName;
    
    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "lastName")
    public WebElement m_lastName;
    
    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "email")
    public WebElement m_email;
    
    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "password")
    public WebElement m_password;
    
    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "phone")
    public WebElement m_phone;

    @FindBy(id = "company")
    public WebElement companyName;

    @FindBy(id = "company")
    public WebElement m_companyName;
    
    @FindBy(id = "street")
    public WebElement street;
    
    @FindBy(id = "city")
    public WebElement city;
    
    @FindBy(id = "country")
    public WebElement country;
    
    @FindBy(id = "state")
    public WebElement state;
   
    @FindBy(id = "zipCode")
    public WebElement zipCode;
    
//    @FindBy(id = "address")
//    public WebElement address;
//
//    @FindBy(id = "address")
//    public WebElement m_address;
    
    @FindBy(id = "tnc-checkbox")
    public WebElement termsAndCondition;
    
    @FindBy(id = "organizationIdDiv")
    public WebElement brandDropDown;
    		
    @FindBy(xpath = "(//li[contains(@class,'checkbox')])[1]")
    public WebElement selectBrand;

    @FindBy(xpath = "//button[contains(text(),'Submit registration')]")
    public WebElement submitRegistration;
    
    @FindBy(id = "submitAsIs")
    public WebElement submitAsIsGerber;
    
    @FindBy (id = "instantApproval")
    public WebElement instantApprovalGerber;
    
    
    @FindBy(xpath = "//li[contains(text(),'This value is required.')]")
    public WebElement mandatoryFieldErrorMsg;
}
