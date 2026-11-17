package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage  {  
	public WebDriver driver; 
	PageUtility pu = new PageUtility();
	public AdminUsersPage(WebDriver driver) { 
	this.driver = driver;  
	PageFactory.initElements(driver, this);  
	}
	
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;  
@FindBy(xpath = "//input[@id='username']") WebElement newusernamevalue; 
@FindBy(xpath = "//input[@id='password']") WebElement newpasswordvalue; 
@FindBy(xpath = "//select[@id='user_type']") WebElement usertype;  
@FindBy(xpath = "//button[@name='Create']") WebElement save;  
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertmsg; 
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement bluesearch; 
@FindBy(xpath = "//input[@id='un']") WebElement adminusername; 
@FindBy(xpath = "//select[@id='ut']") WebElement adminusertype; 
@FindBy(xpath = "//button[@name='Search']") WebElement redsearch;
@FindBy(xpath ="//center[text()='.........RESULT NOT FOUND.......']") WebElement searchadmin;

public AdminUsersPage clickNewButton() 
{
		newbutton.click();
		return this;
}
public AdminUsersPage enterUserNameOnUsernameField(String newusername) 
{ 
	newusernamevalue.sendKeys(newusername);
	return this;
} 
public AdminUsersPage enterPassWordOnPasswordField( String newpassword) 
{ 
	newpasswordvalue.sendKeys(newpassword);
	return this;
} 
public AdminUsersPage enterUserType() 
{ 
	pu.selectDropdownWithVisibleText(usertype, "Admin");
	return this;
	
} 
public AdminUsersPage clickSave()   
{ 
	save.click();
	return this;
}
public String verifyAdminTextIsDisplayed() 
{ 
	return alertmsg.getText();
} 
public AdminUsersPage clickBlueSearch() 
{ 
	bluesearch.click();
	return this;
} 
public AdminUsersPage enterAdminUsername(String searchusername) 
{ 
	adminusername.sendKeys(searchusername);
	return this;
} 
public AdminUsersPage enterAdminUsertype() 
{ 
	pu.selectDropdownWithIndex(adminusername, "2");
	return this;
	
} 
public AdminUsersPage clickRedSearch( ) 
{ 
	redsearch.click();
	return this;
} 
public String verifySearchAdminIsDisplayed() 
{ 
	return searchadmin.getText();
}
}