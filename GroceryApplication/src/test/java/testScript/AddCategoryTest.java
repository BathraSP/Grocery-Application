package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AddCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AddCategoryTest extends Base {
	HomePage hp;
	AddCategoryPage ac;
@Test(description = "user is able to add new category")

public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException { 
	String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData"); 
	String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
	
LoginPage lp = new LoginPage(driver); 
lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue).clickSignin(); 
ac = hp.clickCategoryInfo();
 

ac.clickNewCategory().enterCategoryName().enterSelectCategory().selectimage() .clickSave();

//assert equals
String actual =  ac.verifyAlertIsDisplayed();
String expected = "×\n"
		+"Alert!\n"
		+ "Category Created Successfully"; 
Assert.assertEquals(actual, expected, Constant.ADDNEWCATEGORY);
}
@Test(description = "user is able to able to search a category")
public void VerifyWhetherUserIsAbleToSearchaCategory() throws IOException 
{ 
	String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData"); 
	String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
	LoginPage lp = new LoginPage(driver);

lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue).clickSignin(); 
ac =hp.clickCategoryInfo();
 
AddCategoryPage ac = new AddCategoryPage(driver); 
ac.clickBlueSearch().enterCategory().clickRedSearch();
//assert equals
String actual = ac.verifyResultNotFoundIsDisplayed();
String expected = ".........RESULT NOT FOUND......."; 
Assert.assertEquals(actual, expected, Constant.SEARCHCATEGORY);
}
}
