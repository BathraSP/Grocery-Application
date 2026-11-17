package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {  
	public WebDriver driver; 
	public HomePage(WebDriver driver) { 
	this.driver = driver;  
	PageFactory.initElements(driver, this); 
	}
	
    @FindBy(xpath ="//a[@data-toggle='dropdown']") WebElement admin; 
	@FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']") WebElement logoff;  
	@FindBy(xpath = "//b[text() = '7rmart supermarket']") WebElement loginpagetext;   
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']") WebElement delmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement categorymoreinfo;
	
	
	public HomePage clickAdminButton()  
	{ 
		admin.click();
		return this;
	}
	public LoginPage clickLogoffButton( ) 
	{
		 logoff.click();
		 return new LoginPage(driver);
	} 
	public String verifyLogintextIsDisplayed() 
	{ 
		return loginpagetext.getText();
	}
	public AdminUsersPage clickMoreInfoButton() 
	{ 
		moreinfo.click();
		return new AdminUsersPage(driver);
	} 
	public ManageDeliveryBoyPage clickelMoreInfo() 
	{ 
		delmoreinfo.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public AddCategoryPage clickCategoryInfo()
	{
		categorymoreinfo.click();
		return new AddCategoryPage(driver);
	}
}