package com.partspot.entities;

public class CreditCardDetails {

	String cardType;
	String cardNumber;
	String nameOnCard;
	String month;
	String year;
	String cvv;
	String address;
	String validEmailId;
	String validPassword;
	String partNumber;
	String legacyPartNumber;
	String poNumber;
	String guestAddress;
	String city;
	String zipCode;
	String country;
	String state;

	public CreditCardDetails (String validEmailId, String validPassword, String partNumber, String legacyPartNumber, 
	String poNumber, String guestAddress, String city, String zipCode, String country, String state, String cardType, 
	String cardNumber, String nameOnCard, String month, String year, String cvv, String address) {
		
		this.validEmailId = validEmailId;
        this.validPassword = validPassword;
        this.partNumber = partNumber;
        this.legacyPartNumber = legacyPartNumber;
		this.cardType = cardType;
	    this.cardNumber = cardNumber;
	    this.nameOnCard = nameOnCard;
	    this.month = month;
	    this.year = year;
	    this.cvv = cvv;
	    this.address = address;
	    this.poNumber = poNumber;
	    this.guestAddress = guestAddress;
	    this.city = city;
	    this.zipCode = zipCode;
	    this.country = country;
	    this.state = state;
	   	    
	 }
	
	 public String getPartNumber () {
	        return partNumber;
	 }

	 public void setPartNumber ( String partNumber ) {
	        this.partNumber = partNumber;
	 }
	    
	 public String getLegacyPartNumber () {
	        return legacyPartNumber;
	 }

	 public void setLegacyPartNumber ( String legacyPartNumber ) {
	        this.legacyPartNumber = legacyPartNumber;
	 }
	    
	 public String getValidEmailId () {
	        return validEmailId;
	 }

	 public void setValidEmailId ( String validEmailId ) {
	        this.validEmailId = validEmailId;
	 }
	    
	 public String getValidPassword () {
	        return validPassword;
	 }

	 public void setValidPassword ( String validPassword ) {
	        this.validPassword = validPassword;
	 }
	 
	 public String getPoNumber() {
		 return poNumber;
	 }

	 public void setPoNumber ( String poNumber ) {
		 this.poNumber = poNumber;
	 }
	 
	 public String getGuestAddress() {
		 return guestAddress;
	 }

	 public void setGuestAddress ( String guestAddress ) {
		 this.guestAddress = guestAddress;
	 }
	 
	 public String getCity() {
		 return city;
	 }

	 public void setCity ( String city ) {
		 this.city = city;
	 }
	 
	 public String getZipCode() {
		 return zipCode;
	 }

	 public void setZipCode ( String zipCode ) {
		 this.zipCode = zipCode;
	 }
	 
	 public String getCountry() {
		 return country;
	 }

	 public void setCountry ( String country ) {
		 this.country = country;
	 }
	 
	 public String getState() {
		 return state;
	 }

	 public void setState ( String state ) {
		 this.state = state;
	 }
	 
	
	 public String getCardType() {
		 return cardType;
	 }

	 public void setCardType ( String cardType ) {
		 this.cardType = cardType;
	 }
	
	 public String getCardNumber() {
	    return cardNumber;
	 }

	 public void setCardNumber ( String cardNumber ) {
	    this.cardNumber = cardNumber;
	 }
	 
	 public String getNameOnCard() {
		return nameOnCard;
	 }

	 public void setNameOnCard ( String nameOnCard ) {
		this.nameOnCard = nameOnCard;
	 }
	 
	 public String getMonth() {
	        return month;
	 }

	 public void setMonth ( String month ) {
	        this.month = month;
	 }
	 
	 public String getYear() {
	        return year;
	 }

	 public void setYear ( String year ) {
	        this.year = year;
	 }
	 
	 public String getCvv() {
	        return cvv;
	 }

	 public void setCvv ( String cvv ) {
	        this.cvv = cvv;
	 }
	 
	 public String getAddress() {
	        return address;
	 }

	 public void setAddress ( String address ) {
	        this.address = address;
	 }
	    
	
	
	
}
