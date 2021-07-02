package com.partspot.flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partspot.pageObjects.RegistrationPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.Messages;
import com.partspot.utils.MobileMessages;

public class MobileFlow implements DeviceInterface {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    RegistrationPageObjects registrationPageObjects;

    public MobileFlow ( WebDriver driver ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        registrationPageObjects = new RegistrationPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, registrationPageObjects);
    }

    @Override
    public Messages getMessages () {
        return new MobileMessages();
    }

    @Override
    public void enterRegistrationDetails ( String firstName, String lastName, String email, String password, String phone, String companyName, String streetAddress, String city, String country, String state, String zipCode ) throws InterruptedException {
    	registrationPageObjects.m_firstName.sendKeys(firstName);
    	registrationPageObjects.m_lastName.sendKeys(lastName);
    	registrationPageObjects.m_email.sendKeys(email);
    	registrationPageObjects.m_password.sendKeys(password);
    	registrationPageObjects.m_phone.sendKeys(phone);
    	registrationPageObjects.m_companyName.sendKeys(companyName);
    
    }

	@Override
	public boolean validateErrorMsgForFirstName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForLastName(String firstName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForEmail(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForPassword(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForPhone(String firstName, String lastName, String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForCompanyName(String firstName, String lastName, String email, String password,
			String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForStreet(String firstName, String lastName, String email, String password,
			String phone, String companyName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForBrand(String firstName, String lastName, String email, String password,
			String phone, String companyName, String address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickRegister() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickForgotPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateForgotPassword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyRegistration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enterEmailId(String emailId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickSubmitWithoutEmailId() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void enterValidLoginCredentials(String validEmailId, String validPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateInvalidLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enterLoginCredentialsWithoutPassword(String validEmailId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterLoginCredentialsWithoutUsername(String validPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyMandatoryField() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateBlankPasswordErrorMsg() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateInvalidEmailFormatErrorMsg() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickQuickOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOrganization() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterPartNumber(String partNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickAddToCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validatePartNumberInCartPage(String partNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void selectLegacyPartNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOrganizationForRevFire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateLegacyPartNumberInCartPage(String legacyPartNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteCartItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickShopForParts() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean validateCartNotificationForPart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String selectPartAndAddToCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickCartIcon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterPartInGlobalSearchAndAddToCart(String partNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectPromotions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String clickAddToCartForAPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickProductFamily() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickPartNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateProductFamilyPage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateBomPage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String selectPartAndAddToFavorites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickFavoritesPartIcon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validatePartNumberInFavoritesPage(String partNumberFromShopForParts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickOrders() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateOrderHistoryPageLaunch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickSecureCheckout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillInCheckoutDetailsAndClickPlaceOrder() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void fillInGuestCheckoutDetailsAndClickPlaceOrder(String nameOnCard, String poNumber, String email,
			String guestAddress, String city, String zipCode, String country, String state) {
		// TODO Auto-generated method stub 
		
	}
	

	@Override
	public boolean validateOrderCreation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickRequestForQuote() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillInRequestForQuoteDetailsAndClickCreateQuote() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateQuoteCreation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void selectQuoteAndClickPlaceOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFavoritesPart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillInCreditCardDetailsAndClickPay(String cardType, String cardNumber, String nameOnCard, String month,
			String year, String cvv, String address) {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickContinueAsGuestBtn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateGuestHomePage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fillInGuestDetailsAndClickCreateQuote(String nameOnCard, String email,
			String guestAddress, String city, String zipCode, String country, String state) {
		
	}
	public void clickAPart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectPartAndAddToCart2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCookie() {
		
	}
	
	public boolean validateFullItemsDetailsPage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fillInCheckoutDetailsWithCreditCardOptionAndClickContinueToCardDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateErrorMsgForCity(String firstName, String lastName, String email, String password,
			String phone, String companyName, String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForCountry(String firstName, String lastName, String email, String password,
			String phone, String companyName, String streetAddress, String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForState(String firstName, String lastName, String email, String password,
			String phone, String companyName, String streetAddress, String city, String country) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateErrorMsgForZipCode(String firstName, String lastName, String email, String password,
			String phone, String companyName, String streetAddress, String city, String country, String state) {
		// TODO Auto-generated method stub
		return false;
	}
}
