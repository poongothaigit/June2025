Feature: implementing login functionalities

Scenario: TC01 unsuccessful login
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter username
When i click the login button
Then i should see error message "Error: Please enter your password."

Scenario: TC02 successful login
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When  i enter username
And i enter the password
When i click the login button
When i land in "HomePage"
Then i should be able to see homepage


Scenario: TC03 RememberMe check box
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When  i enter username
And i enter the password
And i click remember me check box
When i click the login button
When i land in "HomePage"
And i click usermenu dropdown
When i click logout
Then i validate username remember validation
