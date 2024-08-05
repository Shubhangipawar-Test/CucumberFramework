package StepDefination;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import Pageobjects.Addcustomerpage;
import Pageobjects.LoginPage;
import Pageobjects.SearchByEmail;
import io.cucumber.java.en.*;

public class Steps extends BaseClass{
	

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		driver=new EdgeDriver();
		lp=new LoginPage(driver);
	   
	}

	@When("user opens URL {string}")
	public void user_opens_url(String URL) throws InterruptedException {

		driver.get(URL);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
	   
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {

		lp.setuserName(email);
		lp.setpassword(password);
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		lp.clicklogin();
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {

		if(driver.getPageSource().contains("Login was unsucessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
		
	    
	}

	@When("user click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clicklogout();
		Thread.sleep(3000);
	    
	}

	

	@Then("close browser")
	public void close_browser() {
		driver.close();
	    
	}

//Customer feature Stepdefination
	

@Then("User can view Dashbord")
public void user_can_view_dashbord() {
	addcust=new Addcustomerpage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getpageTitle());
	
    
}

@When("user click on customer menu")
public void user_click_on_customer_menu() throws InterruptedException {
	Thread.sleep(5000);
	addcust.clickonCustomerMenu();
	
    
}

@When("Click on customer menu item")
public void click_on_customer_menu_item() throws InterruptedException {
	Thread.sleep(5000);
	addcust.clickoncustomerbutton();
   
}

@When("click on Add new customer button")
public void click_on_add_new_customer_button() throws InterruptedException {
	Thread.sleep(5000);
	addcust.clickonaddcustomer();
   
}

@Then("User can view Add new customer Page")
public void user_can_view_add_new_customer_page() {
    Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getpageTitle());
}

@When("User enter customer info")
public void user_enter_customer_info() throws InterruptedException {
	String email=randomestring()+"@gmail.com";
	addcust.setEmail(email);
	addcust.setPassword("test123");
	addcust.setfirstname("shubhangi");
	addcust.setlastname("pawar");
	addcust.setgender("Female");
	addcust.setdob("05/05/1999");
	addcust.setcompanyname("tcs");
	addcust.scrolldown();
    //addcust.setcustomerroles("Guest");
	//addcust.setmanager("vendor 2");
    addcust.setcontent("this is me");
    addcust.scrollup();
    
    


    
}

@When("click on save")
public void click_on_save() throws InterruptedException {
	addcust.clicksave();
	Thread.sleep(2000);
   
}

@Then("user can view confirmation message {string}")
public void user_can_view_confirmation_message(String string) {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    
}
@Then("User Enter email id")
public void user_enter_email_id() {
	Search =new SearchByEmail(driver);
	Search.setEmail("kiyjcycyhjc676008@gmail.com");
	Search.scrollDown();
    
}

@Then("click on Search button")
public void click_on_search_button() {
	Search.clickSearchButton();
    
}

@Then("user should found Email in search table")
public void user_should_found_email_in_search_table() {
	boolean status=Search.searchByCustomerEmail("kiyjcycyhjc676008@gmail.com");
    Assert.assertEquals(true,status);
}






}
