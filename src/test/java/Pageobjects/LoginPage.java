package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
	    ldriver = rdriver;
	    PageFactory.initElements(ldriver, this);
	}
@FindBy(id="Email")
WebElement txtemail;
@FindBy(id="Password")
WebElement txtpass;
@FindBy(css=("button[type='submit']"))
WebElement btnlogin;
@FindBy(xpath="//a[normalize-space()='Logout']")
WebElement btnlogout;

public void setuserName(String uname) {
	txtemail.clear();
	txtemail.sendKeys(uname);
}
public void setpassword(String pwd) {
	txtpass.clear();

	txtpass.sendKeys(pwd);
}
public void clicklogin() throws InterruptedException {
	Thread.sleep(5000);
	btnlogin.click();
}
public void clicklogout()
{
	btnlogout.click();
}
}
