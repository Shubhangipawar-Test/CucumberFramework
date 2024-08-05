package StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Pageobjects.Addcustomerpage;
import Pageobjects.LoginPage;
import Pageobjects.SearchByEmail;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public Addcustomerpage addcust;
	public SearchByEmail Search;
	
	public static String randomestring() {
		String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
				return(generatedstring1);
				
	}

}
