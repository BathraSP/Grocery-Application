 package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base { 
	HomePage hp; 
	AdminUsersPage adm;
	@Test(description = "user is able to add new admin user")
	
public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException 
{ 
		String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData"); 
		String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
		
	LoginPage lp = new LoginPage(driver); 
	lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue);  
	hp = lp.clickSignin(); 
	adm = hp.clickMoreInfoButton(); 
	
	RandomDataUtility rdu = new RandomDataUtility();
	String newusername = rdu.generateRandomUsername();
	String newpassword = rdu.generateRandomPassword();
	
	AdminUsersPage adm = new AdminUsersPage(driver); 
	adm.clickNewButton().enterUserNameOnUsernameField(newusername).enterPassWordOnPasswordField(newpassword).enterUserType().clickSave();  
	
	//assert Equals 
	String actual = adm.verifyAdminTextIsDisplayed(); 
	String expected = "×\n"
			+"Alert!\n"
			+ "User Created Successfully"; 
	Assert.assertEquals(actual, expected, Constant.ADDNEWADMIN);
	
}  
	@Test(description = "user is able to search the newly added admin user")
public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException 
{  
		String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData"); 
		String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
	LoginPage lp = new LoginPage(driver);
	lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue);
	hp= lp.clickSignin(); 
	adm =hp.clickMoreInfoButton();   
	
	String searchusername = ExcelUtilities.getStringData(0, 0, "AdminSearch") ;
	
	adm.clickBlueSearch().enterAdminUsername(searchusername).enterAdminUsertype().clickRedSearch();
	//assert equals 
	String actual = adm.verifySearchAdminIsDisplayed(); 
	String expected = ".........RESULT NOT FOUND......."; 
	Assert.assertEquals(actual,  expected, Constant.SEARCHNEWADMIN );
}
}
