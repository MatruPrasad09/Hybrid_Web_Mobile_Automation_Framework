package com.partspot.entities;

public class ForgotPasswordDetails {
	String validEmailId;
	String invalidEmailId;
	String invalidFormatEmailId;

    public ForgotPasswordDetails ( String validEmailId, String invalidEmailId, String invalidFormatEmailId) {
        this.validEmailId = validEmailId;
        this.invalidEmailId = invalidEmailId;
        this.invalidFormatEmailId = invalidFormatEmailId;
    }

    public String getEmailId () {
        return validEmailId;
    }

    public void setEmailId ( String validEmailId ) {
        this.validEmailId = validEmailId;
    }
    
    public String getInvalidEmailId () {
        return invalidEmailId;
    }

    public void setInvalidEmailId ( String invalidEmailId ) {
        this.invalidEmailId = invalidEmailId;
    }
    
    public String getInvalidFormatEmailId () {
        return invalidFormatEmailId;
    }

    public void setInvalidFormatEmailId ( String invalidFormatEmailId ) {
        this.invalidFormatEmailId = invalidFormatEmailId;
    }

}
