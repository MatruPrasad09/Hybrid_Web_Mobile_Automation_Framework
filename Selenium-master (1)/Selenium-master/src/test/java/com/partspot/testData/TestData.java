package com.partspot.testData;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.DataProvider;

import com.partspot.entities.CreditCardDetails;
import com.partspot.entities.ForgotPasswordDetails;
import com.partspot.entities.LoginDetails;
import com.partspot.entities.PartDetails;
import com.partspot.entities.RegistrationDetails;
import com.partspot.utils.DeviceHelper;

public class TestData {

	static DeviceHelper deviceHelper;
	
    @DataProvider
    public static Object[][] getRegistrationDetails () throws InterruptedException {
		LocalTime localTime = LocalTime.now();
		String time = DateTimeFormatter.ofPattern("HH_mm_ss").format(localTime);
		String email = time + "@yopmail.com";
        return new Object[][]{
                {new RegistrationDetails("Automation", "user", email, "P@ssw0rd", "2015550123", "TF", "Test Street", "oak creek", "USA", "Wisconsin", "53154")},};
    }
    
    @DataProvider
    public static Object[] getForgotPasswordDetails () throws InterruptedException {
        return new Object[] 
                { 
                	new ForgotPasswordDetails("forgotpassword@yopmail.com", "invalidemailid@forgotpassword.com", "ddyuhaudhsuhi")};
    }
    
   
    
    @DataProvider
    public static Object[][] getLoginDetails () throws InterruptedException {
    	String implementation = System.getProperty("IMPLEMENTATION");
    	System.out.println(implementation);
    	switch (implementation.toLowerCase()) {
        case "gensuite_qa":
        	return new Object[][]{{new LoginDetails("autouser@yopmail.com", "p@ssw0rd", "hjdhj@jdcsf.com", "jdduidjie")}};
		
		case "gensuite_uat":
			return new Object[][]{{new LoginDetails("autouser@yopmail.com", "p@ssw0rd", "hjdhj@jdcsf.com", "jdduidjie")}};
		
		case "revfire_qa":
        	return new Object[][]{{new LoginDetails("autouser@yopmail.com", "p@ssw0rd", "hjdhj@jdcsf.com", "jdduidjie")}} ;
		
		case "revfire_uat":
			return new Object[][]{{new LoginDetails("autouser@yopmail.com", "p@ssw0rd", "hjdhj@jdcsf.com", "jdduidjie")}} ;
		
		case "rev_qa":
			return new Object[][]{{new LoginDetails("auto@user1.com", "passw0rd", "hjdhj@jdcsf.com", "jdduidjie")}} ;	
		
		case "rev_uat":
			return new Object[][]{{new LoginDetails("auto@user1.com", "passw0rd", "hjdhj@jdcsf.com", "jdduidjie")}} ;
		
		case "gerber_qa":
			return new Object[][]{{new LoginDetails("autouser123@yopmail.com", "P@ssw0rd", "hjdhj@jdcsf.com", "jdduidjie")}} ;
		
		case "gerber_uat":
			return new Object[][]{{new LoginDetails("autouser123@yopmail.com", "P@ssw0rd", "hjdhj@jdcsf.com", "jdduidjie")}} ;
		
}
		return null;
    }
    
    @DataProvider
    public static Object[][] getPartNumber () throws InterruptedException {
    	String implementation = System.getProperty("IMPLEMENTATION");
    	switch (implementation.toLowerCase()) {
        case "gensuite_qa":
        	return new Object[][]{{new PartDetails("autouser@yopmail.com", "p@ssw0rd", "730012", "H776")}};
		
        case "gensuite_uat":
        	return new Object[][]{{new PartDetails("autouser@yopmail.com", "p@ssw0rd", "730012", "H79A8600")}};
		
        case "revfire_qa":
        	return new Object[][]{{new PartDetails("autouser11@yopmail.com", "p@ssw0rd", "552532", "")}} ;
		
        case "revfire_uat":
        	return new Object[][]{{new PartDetails("autouser11@yopmail.com", "p@ssw0rd", "552532", "")}} ;
		
        case "rev_qa":
        	return new Object[][]{{new PartDetails("auto@user1.com", "passw0rd", "10342981", "PLUG-KACCF")}} ;
        	
        case "rev_uat":
        	return new Object[][]{{new PartDetails("auto@user1.com", "passw0rd", "10342981", "PLUG-KACCF")}} ;
        
		case "gerber_qa":
			return new Object[][]{{new PartDetails("autouser123@yopmail.com", "P@ssw0rd", "F-0611", "#10-32 X 1/2 BH-CAP SCREW")}} ;
		
		case "gerber_uat":
			return new Object[][]{{new PartDetails("autouser123@yopmail.com", "P@ssw0rd", "F-0611", "#10-32 X 1/2 BH-CAP SCREW")}} ;
		
		}
		return null;
    }
    
    @DataProvider
    public static Object[] getCreditCardDetails () {
    	String implementation = System.getProperty("IMPLEMENTATION");
    	switch (implementation.toLowerCase()) {
        case "gensuite_qa":
        	return new Object[]
    			{ new CreditCardDetails("autouser@yopmail.com", "p@ssw0rd", "730012", "H776","TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};
        	
    	case "revfire_qa":
    		return new Object[]
        		{ new CreditCardDetails("autouser11@yopmail.com", "p@ssw0rd", "552532", "00000025","TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};	
        
    	case "revfire_uat":
    		return new Object[]
        		{ new CreditCardDetails("autouser11@yopmail.com", "p@ssw0rd", "552532", "00000025","TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};
    	
    	case "rev_qa":
    		return new Object[]
        		{ new CreditCardDetails("auto@user1.com", "passw0rd", "10342981", "PLUG-KACCF", "TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};

    	case "rev_uat":
    		return new Object[]
        		{ new CreditCardDetails("auto@user1.com", "passw0rd", "10342981", "PLUG-KACCF","TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};	
		
    	case "gerber_qa":
    		return new Object[]
        		{ new CreditCardDetails("autouser123@yopmail.com", "P@ssw0rd", "F-0611", "#10-32 X 1/2 BH-CAP SCREW","TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};
    		 		
    	case "gerber_uat":
    		return new Object[]
        		{ new CreditCardDetails("autouser123@yopmail.com", "P@ssw0rd","F-0611", "#10-32 X 1/2 BH-CAP SCREW","TESTPO","Test Address","oak creek","53154","USA","Wisconsin","AMEX", "371449635398431", "TestAuto", "Oct", "2024", "2222", "Same as Ship To")};
    	
    	}return null;
    }}

    	
