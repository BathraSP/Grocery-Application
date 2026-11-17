package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	HomePage home ;
	@Test(priority = 1, description = "user is trying to login with valid credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(0, 0, "LoginData");
		String passwordvalue = ExcelUtilities.getStringData(0, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue);
		home = lp.clickSignin();
		// Assertion
		boolean dashboardvalue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardvalue, Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "user is trying to login with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidUsernameandInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(1, 0, "LoginData");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue).clickSignin();
		// AssertEquals
		String actual = lp.verifyLogintextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.VALIDANDINVALIDERROR);

	}

	@Test(priority = 3, description = "user is trying to login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameandValidPassword() throws IOException {
		String usernamevalue = ExcelUtilities.getStringData(2, 0, "LoginData");
		String passwordvalue = ExcelUtilities.getStringData(2, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue).clickSignin();
		String actual = lp.verifyLogintextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDANDVALIDERROR);

	}

	@Test(priority = 4, description = "user is trying to login with invalid credentials", groups = { "smoke" }, dataProvider = "LoginData")
	public void verifyUserLoginWithInvalidCredentials(String usernamevalue, String passwordvalue) throws IOException {
		//String usernamevalue = ExcelUtilities.getStringData(3, 0, "LoginData");
	//	String passwordvalue = ExcelUtilities.getStringData(3, 1, "LoginData");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameonUsernameField(usernamevalue).enterPasswordonPasswordField(passwordvalue).clickSignin();
		String actual = lp.verifyLogintextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALS	);

	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Admin", "admin22" }, new Object[] { "Admi", "ad22" }, };
	}

}
