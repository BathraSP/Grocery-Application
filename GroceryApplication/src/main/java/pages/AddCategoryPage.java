package pages;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {
	public WebDriver driver; 
	public AddCategoryPage(WebDriver driver) { 
	this.driver = driver;  
	PageFactory.initElements(driver, this);  }
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newcategory; 
@FindBy(xpath = "//input[@id='category']") WebElement entercategory; 
@FindBy(xpath = "//li[@id='10-selectable']") WebElement selectcategory; 
@FindBy(xpath = "//input[@name='main_img']") WebElement imagecategory; 
@FindBy(xpath = "//button[@name='create']") WebElement savebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newassert;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement bluesearch;
@FindBy(xpath = "//input[@name='un']") WebElement category; 
@FindBy(xpath = "//button[@name='Search']") WebElement redsearch;
@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")WebElement notfound;

	




public AddCategoryPage clickNewCategory()  
{ 
	newcategory.click();
	return this;
}
public AddCategoryPage enterCategoryName() 
{ 
	entercategory.sendKeys("Veggies");
	return this;
}
public AddCategoryPage enterSelectCategory() 
{ 
	selectcategory.click();
	return this;
}
public AddCategoryPage selectimage() 
{ 
	imagecategory.sendKeys("C:\\Users\\Bhadhra\\Downloads\\download.jfif");
	return this;
}
public AddCategoryPage clickSave() 
{ 
	Actions ac = new Actions(driver); 
	ac.click(savebutton).perform();
	return this;
	
}
public String verifyAlertIsDisplayed() 
{ 
	return newassert.getText();
}
public AddCategoryPage clickBlueSearch( )
{
	bluesearch.click();
	return this;
}
public AddCategoryPage enterCategory() 
{ 
	category.sendKeys("abc");
	return this;
}
public AddCategoryPage clickRedSearch()
{
    redsearch.click();
    return this;
	
}
public String verifyResultNotFoundIsDisplayed()
{
	return notfound.getText();
}
}
