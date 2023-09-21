Feature: Appication Loging
  I want to use this template for my feature file
@RegressionTest
  Scenario: Admin Page default login
    Given user is on netBanking landing Page
    When user login into application with "admin" and password 123456
    Then Home Page is displayed
    And cards are displayed

  #Reusability
  @SmokeTest
  Scenario: user Page default login
    Given user is on netBanking landing Page
    When user login into application with <username> and password <password>
    Then Home Page is displayed
    And cards are displayed
  Examples: 
  | username | password |
  | shakil   | 12345678 |
  | rahim    | 32165487 |
    
