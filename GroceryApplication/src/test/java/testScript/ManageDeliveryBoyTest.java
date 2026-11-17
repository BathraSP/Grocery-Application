package testScript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;


public class ManageDeliveryBoyTest extends Base {
	ManageDeliveryBoyPage md;
	HomePage hp;
	
@Test(description = "user is able to add new deliveryboy list")

public void verifyWhetherUserIsAbleToAddNewDeliveryBoYList () throws IOException
{ 
	String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData"); 
	String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
	
LoginPage lp = new LoginPage(driver); 
lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue).clickSignin(); 
md =hp.clickelMoreInfo(); 
 
RandomDataUtility rdu = new RandomDataUtility(); 
String namevalue = rdu.generateFullName(); 
String emailvalue = rdu.generateRandomEmailId(); 
String phonevalue = rdu.generateRandomphoneNumber(); 
String addressvalue = rdu.generateRandomAddress(); 
String delusernamevalue = rdu.generateRandomUsername();  
String delpasswordvalue = rdu.generateRandomPassword();

ManageDeliveryBoyPage md = new ManageDeliveryBoyPage(driver); 
md.clickNew().enterUsername(namevalue).enterEmail(emailvalue).enterPhoneNumber(phonevalue).enterAddress(addressvalue).enterDelUsername(delusernamevalue).enterDelpassword(delpasswordvalue); 


md.clickSaveButton(); 

 
//assert equals
String actual = md.verifylistdeliveryboxisdisplayed();
String expected = "List Delivery Boy";
Assert.assertEquals(actual,  expected, Constant.ADDNEWDELIVERYBOY);
}
}
