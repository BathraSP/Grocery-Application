package constant;

public class Constant {
	public static final String CONFIGFILE = System.getProperty("user.dir")+ "\\src\\main\\resources\\Config.property";
	 public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryTest.xlsx";
	 public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	 public static final String VALIDANDINVALIDERROR = "user is able to login with correct username and invalid password";
	 public static final String INVALIDANDVALIDERROR = "user is able to login with invalid username and valid password";
	 public static final String INVALIDCREDENTIALS = "user is able to login with invalid credentials";
	 public static final String LOGGEDOFF = "user is unable to logout";
	 public static final String ADDNEWADMIN = "user is unable to see to admin list";
	 public static final String SEARCHNEWADMIN = "result found";
	 public static final String ADDNEWDELIVERYBOY = "user cannot see deliveryboy list";
	 public static final String ADDNEWCATEGORY = "user is unable to create categoty list";
	 public static final String SEARCHCATEGORY = "result found";
}
