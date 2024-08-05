Feature: Login
Scenario: Sucessful Login with Valid Credentials
Given user launch chrome browser
When user opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And click on login
Then page title should be "Dashboard / nopCommerce administration"
When user click on log out link
Then page title should be "Your store. Login"
And close browser
