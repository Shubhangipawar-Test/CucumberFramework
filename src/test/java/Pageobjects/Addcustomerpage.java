package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Addcustomerpage {
	WebDriver driver;
	public Addcustomerpage(WebDriver driver) {
		this.driver=driver;
		}
	By customerdrpdwn=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By Customerbutton=By.xpath("//li[@class='nav-item has-treeview menu-is-opening menu-open']//li[1]//a[1]");
	By AddCustomer=By.xpath("//a[normalize-space()='Add new']");
	By Email=By.id("Email");
	
	By password=By.id("Password");
	By firstname=By.id("FirstName");
	By lastname=By.id("LastName");
	By fgender=By.id("Gender_Female");
	By mgender=By.id("Gender_Male");
	
    By comapany=By.id("Company");
    By newsletter=By.xpath("//span[@aria-expanded='true']//input[@role='searchbox']");
    By customerroles=By.xpath("//span[@aria-expanded='true']//input[@role='searchbox']");
    By Ritem=By.xpath("//li[@title='Registered']");
    By Gitem=By.xpath("//li[@title='Guests']");
    By vendor=By.xpath("//select[@id='VendorId']");
    
    By Dob=By.xpath("//input[@id='DateOfBirth']");
    By Admincontent=By.xpath("//textarea[@id='AdminComment']");
    By buttonsave=By.xpath("//button[@name='save']");
	
   //Action Method
    public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");

	}
    public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)");

	}
   
    public void clickonCustomerMenu() {
    	driver.findElement(customerdrpdwn).click();
    }
    public void clickoncustomerbutton() {
    	driver.findElement(Customerbutton).click();
    }
    public void clickonaddcustomer() {
    	driver.findElement(AddCustomer).click();
    }
    public void setEmail(String email) {
    	driver.findElement(Email).sendKeys(email);
    }
    public void setPassword(String string) {
    	driver.findElement(password).sendKeys(string);   
    }
    public void setcustomerroles(String role) throws InterruptedException {
    	//if(!role.equals("vendor"))
    	driver.findElement(customerroles).click();
    	WebElement listitem = null ;
    	Thread.sleep(5000);
    	if (role.equals("Registered")) {
    		listitem=driver.findElement(Ritem);
    	}
    	else if (role.equals("Guests")) {
    		listitem=driver.findElement(Gitem);
    	}
    	
    	listitem.click();
    }
    public void setmanager(String value) {
    	Select drp=new Select(driver.findElement(vendor));
    	drp.selectByVisibleText(value);
    }
    public void setgender(String gender) {
    	if(gender.equals("Male")) {
    		driver.findElement(mgender).click();
    	}
    	else if (gender.equals("Female")) {
    		driver.findElement(fgender).click();
    	}
    }
    public void setfirstname(String fname) {
    	driver.findElement(firstname).sendKeys(fname);
    }
    public void setlastname(String lname) {
    	driver.findElement(lastname).sendKeys(lname);
    }
    public void setdob(String dob) {
    	driver.findElement(Dob).sendKeys(dob);
    }
    public void setcompanyname(String Cname) {
    	driver.findElement(comapany).sendKeys(Cname);
    }
    public void setcontent(String contentname) {
    	driver.findElement(Admincontent).sendKeys(contentname);
    }
    public void clicksave() {
    	driver.findElement(buttonsave).click();
    }
	public String getpageTitle() {
		return driver.getTitle();
	}
}
