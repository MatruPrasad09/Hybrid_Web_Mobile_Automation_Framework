package com.partspot.entities;

public class PartDetails {
	String partNumber;
	String validEmailId;
	String validPassword;
	String legacyPartNumber;
	
    public PartDetails (String validEmailId, String validPassword, String partNumber, String legacyPartNumber) {
    	this.validEmailId = validEmailId;
        this.validPassword = validPassword;
        this.partNumber = partNumber;
        this.legacyPartNumber = legacyPartNumber;
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
}
