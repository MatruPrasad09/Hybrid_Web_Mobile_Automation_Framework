package com.partspot.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.RegistrationPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;

public class RegistrationPage {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    RegistrationPageObjects registrationPageObjects;

    public RegistrationPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        registrationPageObjects = new RegistrationPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, registrationPageObjects);
    }

    public RegistrationPage enterRegistrationDetails ( String firstName, String lastName, String email, String password, String phone, String companyName, String streetAddress, String city, String country, String state, String zipCode ) throws InterruptedException {
        runnerInfo.enterRegistrationDetails(firstName, lastName, email, password, phone, companyName, streetAddress, city, country, state, zipCode);
        return this;
    }

	public boolean verifyFirstName() {
		return runnerInfo.validateErrorMsgForFirstName();
	}

	public boolean verifyLastName(String firstName) {
		return runnerInfo.validateErrorMsgForLastName(firstName);
	}

	public boolean verifyEmail(String firstName, String lastName) {
		return runnerInfo.validateErrorMsgForEmail(firstName, lastName);
	}

	public boolean verifyPassword(String firstName, String lastName, String email) {
		return runnerInfo.validateErrorMsgForPassword(firstName, lastName, email);
	}

	public boolean verifyPhone(String firstName, String lastName, String email, String password) {
		return runnerInfo.validateErrorMsgForPhone(firstName, lastName, email, password);
	}

	public boolean verifyCompanyName(String firstName, String lastName, String email, String password, String phone) {
		return runnerInfo.validateErrorMsgForCompanyName(firstName, lastName, email, password, phone);
	}
	
	public boolean verifyBrandSelection(String firstName, String lastName, String email, String password, String phone,
			String companyName, String address) {
		return runnerInfo.validateErrorMsgForBrand(firstName, lastName, email, password, phone, companyName, address);
	}

	public boolean verifyStreet(String firstName, String lastName, String email, String password, String phone,
			String companyName) {
		return runnerInfo.validateErrorMsgForStreet(firstName, lastName, email, password, phone, companyName);
	}
	
	public boolean verifyCity(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress) {
		return runnerInfo.validateErrorMsgForCity(firstName, lastName, email, password, phone, companyName, streetAddress);
	}
	
	public boolean verifyCountry(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city) {
		return runnerInfo.validateErrorMsgForCountry(firstName, lastName, email, password, phone, companyName, streetAddress, city);
	}
	
	public boolean verifyState(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city, String country) {
		return runnerInfo.validateErrorMsgForState(firstName, lastName, email, password, phone, companyName, streetAddress, city, country);
	}

	public boolean verifyZipCode(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city, String country, String state) {
		return runnerInfo.validateErrorMsgForZipCode(firstName, lastName, email, password, phone, companyName, streetAddress, city, country, state);
	}
	

	
	

	
    
    

}
