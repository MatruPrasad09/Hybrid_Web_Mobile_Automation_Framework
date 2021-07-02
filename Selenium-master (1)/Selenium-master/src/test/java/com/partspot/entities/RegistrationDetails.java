package com.partspot.entities;

public class RegistrationDetails {

    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    String companyName;
    String streetaddress;
    String city;
    String country;
    String state;
    String zipCode;

    public RegistrationDetails ( String firstName, String lastName, String email, String password, String phone, String companyName, String streetaddress, String city, String country, String state, String zipCode ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.companyName = companyName;
        this.streetaddress = streetaddress;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }
    
    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }
    
    public String getPhone () {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }
    
    public String getCompanyName () {
        return companyName;
    }

    public void setCompanyName ( String companyName ) {
        this.companyName = companyName;
    }
    
    public void setStreetAddress ( String streetaddress ) {
        this.streetaddress = streetaddress;
    }
    
    public String getStreetAddress () {
        return streetaddress;
    }
    
    public void setCity ( String city ) {
        this.city = city;
    }
    
    public String getCity () {
        return city;
    }
    
    public void setCountry ( String country ) {
        this.country = country;
    }
    
    public String getCountry () {
        return country;
    }
    
    public void setState ( String state ) {
        this.state = state;
    }
    
    public String getState () {
        return state;
    }
    
    public void setZipCode ( String zipCode ) {
        this.zipCode = zipCode;
    }
    
    public String getZipCode () {
        return zipCode;
    }
    

}
