package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage{ 
	public WebDriver driver; 
	public ManageDeliveryBoyPage(WebDriver driver) { 
	this.driver = driver;  
	PageFactory.initElements(driver, this);  }

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement rednew;  
	@FindBy(xpath = "//input[@id='name']") WebElement name; 
	@FindBy(xpath = "//input[@id='email']") WebElement email; 
	@FindBy(xpath = "//input[@id='phone']") WebElement phonenumber; 
	@FindBy(xpath = "//textarea[@id='address']") WebElement address; 
	@FindBy(xpath = "//input[@id='username']") WebElement delusername; 
	@FindBy(xpath = "//input[@id='password']") WebElement delpassword; 
	@FindBy(xpath = "//button[@name='create']") WebElement save; 
	@FindBy(xpath = "//h4[text()='List Delivery Boy']") WebElement listdelivery;

	
	
	
	public ManageDeliveryBoyPage clickNew( ) { 
		rednew.click();
		return this;
	}
	public ManageDeliveryBoyPage enterUsername(String namevalue) 
	{ 
		name.sendKeys(namevalue);
		return this;
	} 
	public ManageDeliveryBoyPage enterEmail(String emailvalue) 
	{ 
		email.sendKeys(emailvalue);
		return this;
	} 
	public ManageDeliveryBoyPage enterPhoneNumber(String phonevalue) 
	{ 
		phonenumber.sendKeys(phonevalue);
		return this;
	} 
	public ManageDeliveryBoyPage enterAddress(String addressvalue) 
	{ 
		address.sendKeys(addressvalue);
		return this;
	} 
	public ManageDeliveryBoyPage enterDelUsername (String delusernamevalue) 
	{ 
		delusername.sendKeys(delusernamevalue);
		return this;
	} 
	public ManageDeliveryBoyPage enterDelpassword(String delpasswordvalue) 
	{ 
		delpassword.sendKeys(delpasswordvalue);
		return this;
	} 
	public ManageDeliveryBoyPage clickSaveButton()
	{
		Actions ac = new Actions(driver);
	    ac.click(save).perform();
	    return this;
	}
	public String verifylistdeliveryboxisdisplayed() 
	{ 
		return listdelivery.getText();
	}
}
