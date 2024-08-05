Feature: Customers
Scenario: Add new customer
Given user launch chrome browser
When user opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And click on login
Then User can view Dashbord 
When user click on customer menu
And Click on customer menu item
And click on Add new customer button
Then User can view Add new customer Page
When User enter customer info
And click on save
Then user can view confirmation message "The new customer has been added sucessfully"
And close browser



Scenario: Search Customer By Email ID
Given user launch chrome browser
When user opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And click on login
Then User can view Dashbord 
When user click on customer menu
And Click on customer menu item
Then User Enter email id 
And click on Search button
Then user should found Email in search table
And close browser
