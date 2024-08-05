package Pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SearchByEmail {

    WebDriver driver;

    public SearchByEmail(WebDriver driver) {
        this.driver = driver;
    }

    By txtEmail = By.id("SearchEmail");
    By searchButton = By.id("search-customers");
    By firstName = By.id("SearchFirstName");
    By lastName = By.id("SearchLastName");
    By table = By.xpath("//table[@id='customers-grid']");
    By tableRow = By.xpath("//table[@id='customers-grid']//tbody/tr");
    By tableColumn = By.xpath("//table[@id='customers-grid']//tbody/tr/td");

    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void setFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
    }

    public int getNoOfRows() {
        return driver.findElements(tableRow).size();
    }

    public int getNoOfColumns() {
        return driver.findElements(tableColumn).size();
    }

    public boolean searchByCustomerEmail(String email) {
        boolean flag = false;
        int rowCount = getNoOfRows();

        for (int i = 1; i <= rowCount; i++) {
            String emailId = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(emailId);
            if (emailId.equals(email)) { // Compare with the provided email
                flag = true;
                break;
            }
        }
        return flag;
    }
}