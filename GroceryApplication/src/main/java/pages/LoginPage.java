package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wu = new WaitUtility();
		public LoginPage(WebDriver driver) { 
		this.driver = driver;  
		PageFactory.initElements(driver, this);
		}  
		@FindBy(xpath = "//input[@name='username']") WebElement username;   
		@FindBy(xpath = "//input[@name='password']")WebElement password; 
		@FindBy(xpath ="//button[@class='btn btn-dark btn-block']")WebElement signin; 
		@FindBy(xpath = "//p[text() ='Dashboard']") WebElement dashboard; 
		@FindBy(xpath = "//b[text() = '7rmart supermarket']") WebElement loginpagetext;
		

		public LoginPage enterUsernameonUsernameField(String usernamevalue) 
		{ 
			username.sendKeys(usernamevalue);
			return this;
		} 
		public LoginPage enterPasswordonPasswordField(String passwordvalue) 
		{ 
			password.sendKeys(passwordvalue);
			return this;
		}
		public HomePage clickSignin() 
		{
			wu.waitUntilElementBeClickable(driver, signin);
			 signin.click();
			 return new HomePage(driver);
		}
		public boolean verifyWhetherDashboardIsDisplayed() 
		{ 
			return dashboard.isDisplayed();
		} 
		public String verifyLogintextIsDisplayed() 
		{ 
			return loginpagetext.getText();
		}
}
