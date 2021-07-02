package com.partspot.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.partspot.entities.RegistrationDetails;
import com.partspot.pageActions.ConfirmationPage;
import com.partspot.pageActions.GuestHomePage;
import com.partspot.pageActions.HomePage;
import com.partspot.pageActions.LoginPage;
import com.partspot.testData.TestData;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.TestRunnerInfo;

public class RegistrationTest {

	SoftAssert softAssert = new SoftAssert();
	GuestHomePage guestHomePage;
	LoginPage loginPage;
	HomePage homePage;
	ConfirmationPage confirmationPage;

    @Test(dataProvider = "getRegistrationDetails", groups = {"Regression"}, dataProviderClass = TestData.class)
    public void registrationValidations ( RegistrationDetails registrationDetails ) throws InterruptedException {{

        System.setProperty("environment", "PROD");

        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyFirstName(), "First Name Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyLastName(registrationDetails.getFirstName()), "Last Name Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyEmail(registrationDetails.getFirstName(), registrationDetails.getLastName()), "Email Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyPassword(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail()), "Password Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyPhone(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword()), "Phone Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyCompanyName(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone()), "Company Name Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyBrandSelection(registrationDetails.getFirstName(), registrationDetails.getLastName()
         		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone(), registrationDetails.getCompanyName(),
          		registrationDetails.getStreetAddress()), "Brand Selection Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyStreet(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone(), registrationDetails.getCompanyName()), "Street Address Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyCity(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone(), registrationDetails.getCompanyName(), registrationDetails.getStreetAddress()), "City Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyCountry(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone(), registrationDetails.getCompanyName(), registrationDetails.getStreetAddress(), registrationDetails.getCity()), "Country Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyState(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone(), registrationDetails.getCompanyName(), registrationDetails.getStreetAddress(), registrationDetails.getCity(), registrationDetails.getCountry()), "State Validation Failed");
        softAssert.assertTrue(getLandingPage().loadUrl().clickRegister().verifyZipCode(registrationDetails.getFirstName(), registrationDetails.getLastName()
          		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
          		registrationDetails.getPhone(), registrationDetails.getCompanyName(), registrationDetails.getStreetAddress(), registrationDetails.getCity(), registrationDetails.getCountry(), registrationDetails.getState()), "ZipCode Validation Failed");
    
    	}
    }
    
    @Test(dataProvider = "getRegistrationDetails", groups = { "Regression" , "Smoke" }, dataProviderClass = TestData.class)
    public void userRegistration ( RegistrationDetails registrationDetails ) throws InterruptedException {

        System.setProperty("environment", "PROD");

        getLandingPage().loadUrl().clickRegister().enterRegistrationDetails(registrationDetails.getFirstName(), registrationDetails.getLastName()
                		, registrationDetails.getEmail(), registrationDetails.getPassword(), 
                		registrationDetails.getPhone(), registrationDetails.getCompanyName(),
                		registrationDetails.getStreetAddress(), registrationDetails.getCity(), registrationDetails.getCountry(), registrationDetails.getState(), registrationDetails.getZipCode());

        Assert.assertTrue(confirmationPage.verifyRegistration(), "Registration Failed");
        
    	}
    GuestHomePage getLandingPage() {
		WebDriver driverSession = new TestRunnerInfo().getDriverSession();
		DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
		homePage = new HomePage(driverSession, runnerInfo);
		loginPage = new LoginPage(driverSession, runnerInfo);
		confirmationPage = new ConfirmationPage(driverSession, runnerInfo);
		return new GuestHomePage(driverSession, runnerInfo);
	  }
    }
