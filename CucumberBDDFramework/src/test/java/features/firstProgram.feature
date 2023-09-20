

Feature: Appication Loging
  I want to use this template for my feature file

Scenario: Admin Page default login
Given user is on netBanking landing Page 
When user login into application with "admin" and password "123456"
Then Home Page is displayed
And cards are displayed


#Reusability

Scenario: user Page default login
Given user is on netBanking landing Page 
When user login into application with "user" and password "123456"
Then Home Page is displayed
And cards are displayed