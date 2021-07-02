package com.partspot.flows;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.partspot.pageObjects.BomPageObjects;
import com.partspot.pageObjects.CheckOutPageObjects;
import com.partspot.pageObjects.ConfirmationPageObjects;
import com.partspot.pageObjects.CreateQuotePageObjects;
import com.partspot.pageObjects.CreditCardPageObjects;
import com.partspot.pageObjects.FavoritesPageObjects;
import com.partspot.pageObjects.ForgotPasswordPageObjects;
import com.partspot.pageObjects.FullItemDetailsPageObjects;
import com.partspot.pageObjects.GuestHomePageObjects;
import com.partspot.pageObjects.HomePageObjects;
import com.partspot.pageObjects.LoginPageObjects;
import com.partspot.pageObjects.OrderConfirmationPageObjects;
import com.partspot.pageObjects.OrderHistoryPageObjects;
import com.partspot.pageObjects.ProductFamilyPageObjects;
import com.partspot.pageObjects.PromotionsPageObjects;
import com.partspot.pageObjects.QuickOrderPageObjects;
import com.partspot.pageObjects.QuoteConfirmationPageObjects;
import com.partspot.pageObjects.RegistrationPageObjects;
import com.partspot.pageObjects.ShopForPartsPageObjects;
import com.partspot.pageObjects.ShoppingCartPageObjects;
import com.partspot.utils.DeviceHelper;
import com.partspot.utils.DeviceInterface;
import com.partspot.utils.Messages;
import com.partspot.utils.WebMessages;

public class WebFlow implements DeviceInterface {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    RegistrationPageObjects registrationPageObjects;
    GuestHomePageObjects guestHomePageObjects;
    HomePageObjects homePageObjects;
    LoginPageObjects loginPageObjects;
    ConfirmationPageObjects confirmationPageObjects;
    ForgotPasswordPageObjects forgotPasswordPageObjects;
    QuickOrderPageObjects quickOrderPageObjects;
    ShoppingCartPageObjects shoppingCartPageObjects;
    ShopForPartsPageObjects shopForPartsPageObjects;
    PromotionsPageObjects promotionsPageObjects;
    ProductFamilyPageObjects productFamilyPageObjects;
    BomPageObjects bomPageObjects;
    FavoritesPageObjects favoritesPageObjects;
    OrderHistoryPageObjects orderHistoryPageObjects;
    CheckOutPageObjects checkOutPageObjects;
    OrderConfirmationPageObjects orderConfirmationPageObjects;
    CreateQuotePageObjects createQuotePageObjects;
    QuoteConfirmationPageObjects quoteConfirmationPageObjects;
    CreditCardPageObjects creditCardPageObjects;
    FullItemDetailsPageObjects fullItemDetailsPageObjects;

    public WebFlow ( WebDriver driver ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        registrationPageObjects = new RegistrationPageObjects();
        homePageObjects = new HomePageObjects();
        loginPageObjects = new LoginPageObjects();
        confirmationPageObjects = new ConfirmationPageObjects();
        forgotPasswordPageObjects = new ForgotPasswordPageObjects();
        guestHomePageObjects = new GuestHomePageObjects();
        quickOrderPageObjects = new QuickOrderPageObjects();
        shoppingCartPageObjects = new ShoppingCartPageObjects();
        shopForPartsPageObjects = new ShopForPartsPageObjects();
        promotionsPageObjects = new PromotionsPageObjects();
        productFamilyPageObjects = new ProductFamilyPageObjects();
        bomPageObjects = new BomPageObjects();
        favoritesPageObjects = new FavoritesPageObjects();
        orderHistoryPageObjects = new OrderHistoryPageObjects();
        checkOutPageObjects = new CheckOutPageObjects();
        orderConfirmationPageObjects = new OrderConfirmationPageObjects();
        createQuotePageObjects = new CreateQuotePageObjects();
        quoteConfirmationPageObjects = new QuoteConfirmationPageObjects();
        creditCardPageObjects = new CreditCardPageObjects();
        fullItemDetailsPageObjects = new FullItemDetailsPageObjects();
        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, registrationPageObjects);
        PageFactory.initElements(driver, homePageObjects);
        PageFactory.initElements(driver, loginPageObjects);
        PageFactory.initElements(driver, confirmationPageObjects);
        PageFactory.initElements(driver, forgotPasswordPageObjects);
        PageFactory.initElements(driver, guestHomePageObjects);
        PageFactory.initElements(driver, shoppingCartPageObjects);
        PageFactory.initElements(driver, quickOrderPageObjects);
        PageFactory.initElements(driver, shopForPartsPageObjects);
        PageFactory.initElements(driver, promotionsPageObjects);
        PageFactory.initElements(driver, productFamilyPageObjects);
        PageFactory.initElements(driver, bomPageObjects);
        PageFactory.initElements(driver, favoritesPageObjects);
        PageFactory.initElements(driver, orderHistoryPageObjects);
        PageFactory.initElements(driver, checkOutPageObjects);
        PageFactory.initElements(driver, orderConfirmationPageObjects);
        PageFactory.initElements(driver, createQuotePageObjects);
        PageFactory.initElements(driver, quoteConfirmationPageObjects);
        PageFactory.initElements(driver, creditCardPageObjects);
        PageFactory.initElements(driver, fullItemDetailsPageObjects);
    }

    @Override
    public Messages getMessages () {
        return new WebMessages();
    }


    @Override
    public void enterRegistrationDetails ( String firstName, String lastName, String email, String password, String phone, String companyName, String streetAddress, String city, String country, String state, String zipCode ) throws InterruptedException {
    	deviceHelper.waitForPageToLoad(registrationPageObjects.firstName);
    	registrationPageObjects.firstName.sendKeys(firstName);
    	registrationPageObjects.lastName.sendKeys(lastName);
    	registrationPageObjects.email.sendKeys(email);
    	registrationPageObjects.password.sendKeys(password);
    	registrationPageObjects.phone.sendKeys(phone);
    	registrationPageObjects.companyName.sendKeys(companyName);
    	registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.selectBrand.click();
    	registrationPageObjects.street.sendKeys(streetAddress);
    	registrationPageObjects.city.sendKeys(city);
    	registrationPageObjects.country.sendKeys(country);
    	registrationPageObjects.state.sendKeys(state);
    	registrationPageObjects.zipCode.sendKeys(zipCode);
    	((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", registrationPageObjects.termsAndCondition);
    	registrationPageObjects.submitRegistration.click();
    	if(System.getProperty("IMPLEMENTATION").equals("GERBER")) 
    		deviceHelper.waitForElementToAppear(registrationPageObjects.submitAsIsGerber);
    		registrationPageObjects.submitAsIsGerber.click();
    	
    		

    }

	@Override
	public boolean validateErrorMsgForFirstName() {
		deviceHelper.waitForElementToAppear(registrationPageObjects.submitRegistration);
		registrationPageObjects.submitRegistration.click();
		deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
		
	}

	@Override
	public boolean validateErrorMsgForLastName(String firstName) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.submitRegistration.click();
		deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}

	@Override
	public boolean validateErrorMsgForEmail(String firstName, String lastName) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.submitRegistration.click();
		deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}

	@Override
	public boolean validateErrorMsgForPassword(String firstName, String lastName, String email) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.submitRegistration.click();
		deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}

	@Override
	public boolean validateErrorMsgForPhone(String firstName, String lastName, String email, String password) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.submitRegistration.click();
		deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}

	@Override
	public boolean validateErrorMsgForCompanyName(String firstName, String lastName, String email, String password,
			String phone) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.submitRegistration.click();
		deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}
	
	@Override
	public boolean validateErrorMsgForBrand(String firstName, String lastName, String email, String password,
			String phone, String companyName, String address) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.companyName.sendKeys(companyName);
		registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.submitRegistration.click();
    	deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}

	@Override
	public boolean validateErrorMsgForStreet(String firstName, String lastName, String email, String password,
			String phone, String companyName) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.companyName.sendKeys(companyName);
		registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.selectBrand.click();
    	registrationPageObjects.submitRegistration.click();
    	deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}
	
	@Override
	public boolean validateErrorMsgForCity(String firstName, String lastName, String email, String password,
			String phone, String companyName, String streetAddress) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.companyName.sendKeys(companyName);
		registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.selectBrand.click();
    	registrationPageObjects.street.sendKeys(streetAddress);
    	registrationPageObjects.submitRegistration.click();
    	deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}
	
	@Override
	public boolean validateErrorMsgForCountry(String firstName, String lastName, String email, String password, String phone,
			String companyName, String streetAddress, String city) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.companyName.sendKeys(companyName);
		registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.selectBrand.click();
    	registrationPageObjects.street.sendKeys(streetAddress);
    	registrationPageObjects.city.sendKeys(city);
    	registrationPageObjects.submitRegistration.click();
    	deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}
	
	@Override
	public boolean validateErrorMsgForState(String firstName, String lastName, String email, String password,
			String phone, String companyName, String streetAddress, String city, String country) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.companyName.sendKeys(companyName);
		registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.selectBrand.click();
    	registrationPageObjects.street.sendKeys(streetAddress);
    	registrationPageObjects.city.sendKeys(city);
    	registrationPageObjects.country.sendKeys(country);
    	registrationPageObjects.submitRegistration.click();
    	deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
			
	}
	
	@Override
	public boolean validateErrorMsgForZipCode(String firstName, String lastName, String email, String password,
			String phone, String companyName, String streetAddress, String city, String country, String state) {
		registrationPageObjects.firstName.sendKeys(firstName);
		registrationPageObjects.lastName.sendKeys(lastName);
		registrationPageObjects.email.sendKeys(email);
		registrationPageObjects.password.sendKeys(password);
		registrationPageObjects.phone.sendKeys(phone);
		registrationPageObjects.companyName.sendKeys(companyName);
		registrationPageObjects.brandDropDown.click();
    	registrationPageObjects.selectBrand.click();
    	registrationPageObjects.street.sendKeys(streetAddress);
    	registrationPageObjects.city.sendKeys(city);
    	registrationPageObjects.country.sendKeys(country);
    	registrationPageObjects.state.sendKeys(state);
    	registrationPageObjects.submitRegistration.click();
    	deviceHelper.waitForElementToAppear(registrationPageObjects.mandatoryFieldErrorMsg);
		return registrationPageObjects.mandatoryFieldErrorMsg.isDisplayed();
		
	}
	

	@Override
	public void clickRegister() {
		guestHomePageObjects.register.click();
	}

	@Override
	public void clickLogin() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", guestHomePageObjects.login);
		
	}

	@Override
	public void clickForgotPassword() {
		deviceHelper.waitForElementToAppear(loginPageObjects.forgotPassword);
		loginPageObjects.forgotPassword.click();
		
	}

	@Override
	public boolean validateForgotPassword() {
		deviceHelper.waitForElementToAppear(confirmationPageObjects.forgotPasswordConfirmationMessage);
    	return confirmationPageObjects.forgotPasswordConfirmationMessage.isDisplayed();
		
	}

	@Override
	public boolean verifyRegistration() {
		deviceHelper.waitForElementToAppear(confirmationPageObjects.registrationConfirmationMessage);
    	return confirmationPageObjects.registrationConfirmationMessage.isDisplayed() && confirmationPageObjects.confirmationMessage.isDisplayed();
		
	}

	@Override
	public void enterEmailId(String emailId) {
		forgotPasswordPageObjects.emailId.sendKeys(emailId);
		forgotPasswordPageObjects.forgotPasswordSubmit.click();
	}

	@Override
	public void clickSubmitWithoutEmailId() {
		forgotPasswordPageObjects.forgotPasswordSubmit.click();
		
	}

	@Override
	public boolean validateBlankPasswordErrorMsg() {
		deviceHelper.waitForElementToAppear(forgotPasswordPageObjects.blankEmailIdFieldErrorMsg);
		return forgotPasswordPageObjects.blankEmailIdFieldErrorMsg.isDisplayed();
	}

	@Override
	public void enterValidLoginCredentials(String validEmailId, String validPassword) {
			deviceHelper.waitForElementToAppear(loginPageObjects.username);
			loginPageObjects.username.sendKeys(validEmailId);
			loginPageObjects.password.sendKeys(validPassword);
			loginPageObjects.submit.click();
		
	}

	@Override
	public boolean validateLogin() {
		deviceHelper.waitForElementToAppear(homePageObjects.home);
		return homePageObjects.home.isDisplayed();
	}

	@Override
	public boolean validateInvalidLogin() {
		return loginPageObjects.loginFailMsg.isDisplayed();
	}

	@Override
	public void enterLoginCredentialsWithoutPassword(String validEmailId) {
		loginPageObjects.username.sendKeys(validEmailId);
		loginPageObjects.submit.click();
		
	}

	@Override
	public void enterLoginCredentialsWithoutUsername(String validPassword) {
		loginPageObjects.password.sendKeys(validPassword);
		loginPageObjects.submit.click();
		
	}

	@Override
	public boolean verifyMandatoryField() {
		return loginPageObjects.mandatoryFieldErrorMsg.isDisplayed();
	}

	@Override
	public boolean validateInvalidEmailFormatErrorMsg() {
		deviceHelper.waitForElementToAppear(forgotPasswordPageObjects.invalidFormatEmailIdFieldErrorMsg);
		return forgotPasswordPageObjects.invalidFormatEmailIdFieldErrorMsg.isDisplayed();
	}

	@Override
	public void clickQuickOrder() {
		homePageObjects.quickOrder.click();
		
	}

	@Override
	public void selectLegacyPartNumber() {
		if(System.getProperty("IMPLEMENTATION").equals("GENSUITE")) 
		deviceHelper.waitForElementToAppear(quickOrderPageObjects.selectLegacyPart);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", quickOrderPageObjects.selectLegacyPart);
		
	}

	@Override
	public void selectOrganization() {
		if(System.getProperty("IMPLEMENTATION").contains("GENSUITE") || System.getProperty("IMPLEMENTATION").contains("GERBER")) {
		Select selectShippingMethodDrpDwn = new Select(quickOrderPageObjects.selectOrganizationDropDown);
		selectShippingMethodDrpDwn.selectByIndex(1);
		}
	}
	
	@Override
	public void selectOrganizationForRevFire() {
		if(System.getProperty("IMPLEMENTATION").equals("REV_UAT")) {
			Select selectShippingMethodDrpDwn = new Select(quickOrderPageObjects.selectOrganizationDropDown);
			selectShippingMethodDrpDwn.selectByIndex(1);
		}
	}

	@Override
	public void enterPartNumber(String partNumber) {
		quickOrderPageObjects.partNotextBox.sendKeys(partNumber);
		quickOrderPageObjects.enterQuantity.sendKeys("1");
		
	}

	@Override
	public void clickAddToCart() {
		quickOrderPageObjects.clickAddToCart.click();
		
	}

	@Override
	public boolean validatePartNumberInCartPage(String partNo) {
		deviceHelper.waitForElementToAppear(shoppingCartPageObjects.partNumber);
		String partNoInCart = shoppingCartPageObjects.partNumber.getText();
		return shoppingCartPageObjects.partNumber.isDisplayed() && partNoInCart.contains(partNo);
	}

	@Override
	public boolean validateLegacyPartNumberInCartPage(String legacyPartNo) {
		deviceHelper.waitForElementToAppear(shoppingCartPageObjects.legacyPartNumber);
		String legacyPartNoInCart = shoppingCartPageObjects.legacyPartNumber.getText();
		return shoppingCartPageObjects.legacyPartNumber.isDisplayed() && legacyPartNoInCart.contains(legacyPartNo);
	}

	@Override
	public void deleteCartItems() {
		shoppingCartPageObjects.emptyCart.click();
		deviceHelper.waitForElementToAppear(shoppingCartPageObjects.emptyCartPopUp);
		shoppingCartPageObjects.emptyCartPopUp.click();
		
	}

	@Override
	public void clickShopForParts() {
		homePageObjects.shopForParts.click();
		
	}

	@Override
	public String selectPartAndAddToCart() {
		if(System.getProperty("IMPLEMENTATION").contains("GERBER")) {
			shopForPartsPageObjects.selectFirstCatalogGerber.click();
		}else {
		shopForPartsPageObjects.selectFirstCatalog.click();}
		deviceHelper.waitForElementToAppear(shopForPartsPageObjects.selectFirstAddToCart);
		String shopForPartsPartNumber = shopForPartsPageObjects.firstPartNumber.getText();
		shopForPartsPageObjects.selectFirstAddToCart.click();
		return shopForPartsPartNumber;
		
	}

	@Override
	public boolean validateCartNotificationForPart() {
		return true;
	}

	@Override
	public void clickCartIcon() {
		deviceHelper.waitForElementToAppear(shopForPartsPageObjects.cartIcon);
		shopForPartsPageObjects.cartIcon.click();
		
	}

	@Override
	public void enterPartInGlobalSearchAndAddToCart(String partNumber) {
		deviceHelper.waitForElementToAppear(homePageObjects.searchTextBox);
		homePageObjects.searchTextBox.sendKeys(partNumber);
		homePageObjects.searchSubmit.click();
		deviceHelper.waitForElementToAppear(homePageObjects.addToCart);
		homePageObjects.addToCart.click();
		
	}

	@Override
	public void selectPromotions() {
		deviceHelper.waitForElementToAppear(homePageObjects.firstPromotion);
		homePageObjects.firstPromotion.click();
		
	}

	@Override
	public String clickAddToCartForAPart() {
		deviceHelper.waitForElementToAppear(promotionsPageObjects.addToCart);
		String partNumber = promotionsPageObjects.firstPartNumber.getText();
		promotionsPageObjects.addToCart.click();
		return partNumber;
	}

	@Override
	public void clickProductFamily() {
		deviceHelper.waitForElementToAppear(homePageObjects.productFamily);
		homePageObjects.productFamily.click();
		
	}

	@Override
	public void clickPartNumber() {
		deviceHelper.waitForElementToAppear(productFamilyPageObjects.firstPartNumber);
		productFamilyPageObjects.firstPartNumber.click();
		
	}

	@Override
	public boolean validateProductFamilyPage() {
		//Commenting as we cannot rely on Search Filter because it is a configurable field - 30.01.2019 
		//deviceHelper.waitForElementToAppear(productFamilyPageObjects.searchFilter);
		deviceHelper.waitForElementToAppear(productFamilyPageObjects.partSearchBar);
		return productFamilyPageObjects.partSearchBar.isDisplayed() || productFamilyPageObjects.breadCrumb.isDisplayed();
	}

	@Override
	public boolean validateBomPage() {
		deviceHelper.waitForElementToAppear(bomPageObjects.catalogBOM);
		return bomPageObjects.catalogBOM.isDisplayed() || bomPageObjects.fullItemsMediaContainer.isDisplayed()
				|| bomPageObjects.machineCatalogTree.isDisplayed();
	}

	@Override
	public String selectPartAndAddToFavorites() {
		if(System.getProperty("IMPLEMENTATION").contains("GERBER")) {
			shopForPartsPageObjects.selectFirstCatalogGerber.click();
		}else {
		shopForPartsPageObjects.selectFirstCatalog.click();}
		deviceHelper.waitForElementToAppear(shopForPartsPageObjects.selectFirstAddToCart);
		String shopForPartsPartNumber = shopForPartsPageObjects.firstPartNumber.getText();
		shopForPartsPageObjects.selectFirstFavoriteIcon.click();
		return shopForPartsPartNumber;
	}

	@Override
	public void clickFavoritesPartIcon() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deviceHelper.waitForElementToAppear(homePageObjects.userDropDown);
		homePageObjects.userDropDown.click();
		deviceHelper.waitForElementToAppear(homePageObjects.favoriteParts);
		homePageObjects.favoriteParts.click();
		
	}

	@Override
	public boolean validatePartNumberInFavoritesPage(String partNumberFromShopForParts) {
		deviceHelper.waitForElementToAppear(favoritesPageObjects.partNumber);
		String partNoInFavorites = favoritesPageObjects.partNumber.getText();
		return favoritesPageObjects.partNumber.isDisplayed() && partNoInFavorites.contains(partNumberFromShopForParts);
	}

	@Override
	public void clickOrders() {
		deviceHelper.waitForElementToAppear(homePageObjects.orders);
		homePageObjects.orders.click();
		if(System.getProperty("IMPLEMENTATION").contains("GENSUITE")) {
			homePageObjects.selectBrand.click();
		}else if(System.getProperty("IMPLEMENTATION").contains("GERBER")) {
			homePageObjects.selectBrandGerber.click();
		}
	}

	@Override
	public boolean validateOrderHistoryPageLaunch() {
		deviceHelper.waitForElementToAppear(orderHistoryPageObjects.orderOptions);
		return orderHistoryPageObjects.orderHistoryBreadCrumb.isDisplayed() || orderHistoryPageObjects.orderOptions.isDisplayed();
	}

	@Override
	public void clickSecureCheckout() {
		deviceHelper.waitForElementToAppear(shoppingCartPageObjects.secureCheckout);
		shoppingCartPageObjects.secureCheckout.click();
		
	}

	@Override
	public void fillInCheckoutDetailsAndClickPlaceOrder() {
		deviceHelper.waitForElementToAppear(checkOutPageObjects.checkoutPageBreadcrumb);
		checkOutPageObjects.poNumber.sendKeys("TestAuto");
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillShippingInfo);
		checkOutPageObjects.fillShippingInfo.click();
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillPaymentMethod);
		checkOutPageObjects.fillPaymentMethod.click();
		checkOutPageObjects.placeOrder.click();
		
	}
	
	@Override
	public void fillInGuestCheckoutDetailsAndClickPlaceOrder(String nameOnCard, String poNumber, String email, String guestAddress, 
			String city, String zipCode, String country, String state) {
		deviceHelper.waitForElementToAppear(checkOutPageObjects.checkoutPageBreadcrumb);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.customerName);
		checkOutPageObjects.customerName.sendKeys(nameOnCard);
		checkOutPageObjects.poNumber.sendKeys(poNumber);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.contactEmail);
		checkOutPageObjects.contactEmail.sendKeys(email);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillShippingInfo);
		checkOutPageObjects.fillShippingInfo.click();
		deviceHelper.waitForElementToAppear(checkOutPageObjects.addressName);
		checkOutPageObjects.addressName.sendKeys(guestAddress);
		checkOutPageObjects.addressLine1.sendKeys(guestAddress);
		checkOutPageObjects.city.sendKeys(city);
		checkOutPageObjects.zipCode.sendKeys(zipCode);
		DeviceHelper.selectDropdownByText(checkOutPageObjects.selectCountry, country);
		DeviceHelper.selectDropdownByText(checkOutPageObjects.selectState, state);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillPaymentMethod);
		checkOutPageObjects.fillPaymentMethod.click();
		deviceHelper.waitForElementToAppear(checkOutPageObjects.continueToCardDetailsBtn);
		checkOutPageObjects.continueToCardDetailsBtn.click();
		
	}
	
	@Override
	public void fillInCreditCardDetailsAndClickPay(String cardType, String cardNumber, String nameOnCard, String month,
			String year, String cvv, String address) {
		if(!System.getProperty("IMPLEMENTATION").contains("GERBER")) {
		deviceHelper.waitForElementToAppear(creditCardPageObjects.addNewCard);
		creditCardPageObjects.addNewCard.click();}
		
		deviceHelper.WaitForFrameAndSwitchToIt("IFrame");
		deviceHelper.waitForElementToAppear(creditCardPageObjects.cardType);
		DeviceHelper.selectDropdownByText(creditCardPageObjects.cardType, cardType);
		creditCardPageObjects.cardNumber.sendKeys(cardNumber);
		creditCardPageObjects.nameOnCard.sendKeys(nameOnCard);
		DeviceHelper.selectDropdownByText(creditCardPageObjects.selectMonth, month);
		DeviceHelper.selectDropdownByText(creditCardPageObjects.selectYear, year);
		creditCardPageObjects.cvv.sendKeys(cvv);
		deviceHelper.switchToDefaultPage();
		if(!System.getProperty("IMPLEMENTATION").contains("GERBER")) {
		deviceHelper.waitForElementToAppear(creditCardPageObjects.selectAddress);
		DeviceHelper.selectDropdownByText(creditCardPageObjects.selectAddress, address);
		}
		deviceHelper.waitForElementToAppear(creditCardPageObjects.pay);
		creditCardPageObjects.pay.click();
		
	}
	

	@Override
	public boolean validateOrderCreation() {
		deviceHelper.waitForElementToAppear(orderConfirmationPageObjects.orderConfirmSummary);
		return orderConfirmationPageObjects.orderConfirmSummary.isDisplayed() 
				|| orderConfirmationPageObjects.orderSummaryContainer.isDisplayed();
	}

	@Override
	public void clickRequestForQuote() {
		deviceHelper.waitForElementToAppear(shoppingCartPageObjects.requestForQuote);
		shoppingCartPageObjects.requestForQuote.click();
		
	}
	

	@Override
	public void fillInRequestForQuoteDetailsAndClickCreateQuote() {
		deviceHelper.waitForElementToAppear(createQuotePageObjects.createQuotePageBreadcrumb);
		
		deviceHelper.waitForElementToAppear(createQuotePageObjects.fillShippingInfo);
		createQuotePageObjects.fillShippingInfo.click();
		deviceHelper.waitForElementToAppear(createQuotePageObjects.fillPaymentMethod);
		createQuotePageObjects.fillPaymentMethod.click();
		
		createQuotePageObjects.createQuote.click();
		
	}

	@Override
	public boolean validateQuoteCreation() {
		deviceHelper.waitForElementToAppear(quoteConfirmationPageObjects.orderConfirmSummary);
		return quoteConfirmationPageObjects.orderConfirmSummary.isDisplayed() 
				|| quoteConfirmationPageObjects.orderSummaryContainer.isDisplayed();
	}

	@Override
	public void selectQuoteAndClickPlaceOrder() {
		deviceHelper.waitForElementToAppear(orderHistoryPageObjects.orderOptions);
		
		orderHistoryPageObjects.documentTypeDropDown.click();
		orderHistoryPageObjects.orderDropdown.click();
		orderHistoryPageObjects.invoiceDropdown.click();
		orderHistoryPageObjects.statusDropDown.click();
		orderHistoryPageObjects.allStatus.click();
		orderHistoryPageObjects.openStatus.click();
		orderHistoryPageObjects.applyFilter.click();
		orderHistoryPageObjects.dotsOption.click();
		orderHistoryPageObjects.placeOrder.click();		
		
	}

	@Override
	public void removeFavoritesPart() {
		favoritesPageObjects.removeFavoritePart.click();
		
	}

	@Override
	public void clickContinueAsGuestBtn() {
		shoppingCartPageObjects.continueGuestButton.click();
		
	}

	@Override
	public boolean validateGuestHomePage() {
		deviceHelper.waitForElementToAppear(guestHomePageObjects.login);
		return guestHomePageObjects.login.isDisplayed() && guestHomePageObjects.register.isDisplayed();
	}

	@Override
	public void fillInGuestDetailsAndClickCreateQuote (String nameOnCard, String email, String guestAddress, 
			String city, String zipCode, String country, String state) {
		
		deviceHelper.waitForElementToAppear(checkOutPageObjects.customerName);
		checkOutPageObjects.customerName.sendKeys(nameOnCard);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.contactEmail);
		checkOutPageObjects.contactEmail.sendKeys(email);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillShippingInfo);
		if(System.getProperty("IMPLEMENTATION").contains("GERBER")|| System.getProperty("IMPLEMENTATION").contains("MILACRON")) {
			checkOutPageObjects.phoneNumber.sendKeys("(201) 545-5566");}
		checkOutPageObjects.fillShippingInfo.click();
		deviceHelper.waitForElementToAppear(checkOutPageObjects.addressName);
		checkOutPageObjects.addressName.sendKeys(guestAddress);
		checkOutPageObjects.addressLine1.sendKeys(guestAddress);
		checkOutPageObjects.city.sendKeys(city);
		checkOutPageObjects.zipCode.sendKeys(zipCode);
		DeviceHelper.selectDropdownByText(checkOutPageObjects.selectCountry, country);
		DeviceHelper.selectDropdownByText(checkOutPageObjects.selectState, state);
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillPaymentMethod);
		checkOutPageObjects.fillPaymentMethod.click();
		createQuotePageObjects.billToAddressName.sendKeys(guestAddress);	
		createQuotePageObjects.billToAddressLine1.sendKeys(guestAddress);
		createQuotePageObjects.billToAddressCity.sendKeys(city);
		createQuotePageObjects.billToAddressZipCode.sendKeys(zipCode);
		DeviceHelper.selectDropdownByText(createQuotePageObjects.billToAddressCountry, country);
		DeviceHelper.selectDropdownByText(createQuotePageObjects.billToAddressState, state);	
		deviceHelper.waitForElementToAppear(createQuotePageObjects.createQuote);
		createQuotePageObjects.createQuote.click();
			
	}

	@Override
	public void handleCookie() {
		if(System.getProperty("IMPLEMENTATION").contains("GERBER")|| System.getProperty("IMPLEMENTATION").contains("MILACRON")) {
			deviceHelper.waitForElementToAppear(guestHomePageObjects.cookieOkBtn);
			guestHomePageObjects.cookieOkBtn.click();	
		}
		
	}	
	
		@Override
	public void clickAPart() {
		deviceHelper.waitForElementToAppear(shoppingCartPageObjects.partNumber);
		if(System.getProperty("IMPLEMENTATION").contains("GERBER")) {
			shoppingCartPageObjects.gerberPartInCart.click();
		}else {
		shoppingCartPageObjects.partNumber.click();
		}
	}

	@Override
	public void selectPartAndAddToCart2() {
		if(System.getProperty("IMPLEMENTATION").contains("GERBER") || System.getProperty("IMPLEMENTATION").contains("GENSUITE")) {
			deviceHelper.waitForElementToAppear(shopForPartsPageObjects.selectBrandShopforPart);
			shopForPartsPageObjects.selectBrandShopforPart.click();}
		deviceHelper.waitForElementToAppear(shopForPartsPageObjects.selectFirstAddToCart);
		shopForPartsPageObjects.selectFirstAddToCart.click();
		deviceHelper.waitForElementToAppear(shopForPartsPageObjects.cartIcon);
		shopForPartsPageObjects.cartIcon.click();
		
		
	}

	@Override
	public boolean validateFullItemsDetailsPage() {
		return fullItemDetailsPageObjects.fullItemBreadCrumb.isDisplayed();
		
	}

	@Override
	public void fillInCheckoutDetailsWithCreditCardOptionAndClickContinueToCardDetails() {
		deviceHelper.waitForElementToAppear(checkOutPageObjects.checkoutPageBreadcrumb);
		checkOutPageObjects.poNumber.sendKeys("TestAuto");
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillShippingInfo);
		checkOutPageObjects.fillShippingInfo.click();
		deviceHelper.waitForElementToAppear(checkOutPageObjects.fillPaymentMethod);
		checkOutPageObjects.fillPaymentMethod.click();
		checkOutPageObjects.paymentTypeDropDown.click();
		checkOutPageObjects.selectCC.click();
		checkOutPageObjects.continueToCardDetails.click();
		
	}

	
}
