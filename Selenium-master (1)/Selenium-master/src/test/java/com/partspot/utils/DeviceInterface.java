package com.partspot.utils;

public interface DeviceInterface {
    Messages getMessages ();

    void enterRegistrationDetails ( String firstName, String lastName, String email, String password, String phone, String companyName, String streetAddress, String city, String country, String state, String zipCode ) throws InterruptedException;

	boolean validateErrorMsgForFirstName();

	boolean validateErrorMsgForLastName(String firstName);

	boolean validateErrorMsgForEmail(String firstName, String lastName);

	boolean validateErrorMsgForPassword(String firstName, String lastName, String email);

	boolean validateErrorMsgForPhone(String firstName, String lastName, String email, String password);

	boolean validateErrorMsgForCompanyName(String firstName, String lastName, String email, String password,
			String phone);
	
	boolean validateErrorMsgForBrand(String firstName, String lastName, String email, String password, String phone,
			String companyName, String address);

	boolean validateErrorMsgForStreet(String firstName, String lastName, String email, String password,
			String phone, String companyName);
	
	boolean validateErrorMsgForCity(String firstName, String lastName, String email, String password, String phone,
			String companyName, String city);
	
	boolean validateErrorMsgForCountry(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city);
	
	boolean validateErrorMsgForState(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city, String country);
	
	boolean validateErrorMsgForZipCode(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city, String country, String state);
	

	void clickRegister();

	void clickLogin();

	void clickForgotPassword();

	boolean validateForgotPassword();

	boolean verifyRegistration();

	void enterEmailId(String emailId);

	void clickSubmitWithoutEmailId();

	boolean validateBlankPasswordErrorMsg();

	void enterValidLoginCredentials(String validEmailId, String validPassword);

	boolean validateLogin();

	boolean validateInvalidLogin();

	void enterLoginCredentialsWithoutPassword(String validEmailId);

	void enterLoginCredentialsWithoutUsername(String validPassword);

	boolean verifyMandatoryField();

	boolean validateInvalidEmailFormatErrorMsg();

	void clickQuickOrder();

	void selectLegacyPartNumber();

	void selectOrganization();
	
	void selectOrganizationForRevFire();

	void enterPartNumber(String partNumber);

	void clickAddToCart();

	boolean validatePartNumberInCartPage(String partNo);

	boolean validateLegacyPartNumberInCartPage(String legacyPartNo);

	void deleteCartItems();

	void clickShopForParts();

	String selectPartAndAddToCart();

	boolean validateCartNotificationForPart();

	void clickCartIcon();

	void enterPartInGlobalSearchAndAddToCart(String partNumber);

	void selectPromotions();

	String clickAddToCartForAPart();

	void clickProductFamily();

	void clickPartNumber();

	boolean validateProductFamilyPage();

	boolean validateBomPage();

	String selectPartAndAddToFavorites();

	void clickFavoritesPartIcon();

	boolean validatePartNumberInFavoritesPage(String partNumberFromShopForParts);

	void clickOrders();

	boolean validateOrderHistoryPageLaunch();

	void clickSecureCheckout();

	void fillInCheckoutDetailsAndClickPlaceOrder();
	
	void fillInGuestCheckoutDetailsAndClickPlaceOrder(String nameOnCard, String poNumber, String email,
			String guestAddress, String city, String zipCode, String country, String state);
	
	void fillInCreditCardDetailsAndClickPay(String cardType, String cardNumber, String nameOnCard, String month,
			String year, String cvv, String address);

	boolean validateOrderCreation();

	void clickRequestForQuote();

	void fillInRequestForQuoteDetailsAndClickCreateQuote();

	boolean validateQuoteCreation();

	void selectQuoteAndClickPlaceOrder();

	void removeFavoritesPart();

	void clickContinueAsGuestBtn();

	boolean validateGuestHomePage();

	void fillInGuestDetailsAndClickCreateQuote(String nameOnCard, String email, String guestAddress,
			String city, String zipCode, String country, String state);

	void handleCookie();
	
	void clickAPart();

	void selectPartAndAddToCart2();

	boolean validateFullItemsDetailsPage();

	void fillInCheckoutDetailsWithCreditCardOptionAndClickContinueToCardDetails();





	

}
