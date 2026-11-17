package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base { 
	HomePage hp; 
	@Test(description = "user is trying to logged out")
public void verifyWhetherUserisAbletoSuccessfullyLoggedOff( ) throws IOException 
{ 
	String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData"); 
	String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
	
	LoginPage lp = new LoginPage(driver);
	lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue);
	hp = lp.clickSignin();
	
	 
	lp =hp.clickLogoffButton();  
	hp.clickMoreInfoButton();
	
	String actual = hp.verifyLogintextIsDisplayed(); 
	String expected = "7rmart supermarket"; 
	Assert.assertEquals(actual ,  expected, Constant.LOGGEDOFF);
	
}
}
 