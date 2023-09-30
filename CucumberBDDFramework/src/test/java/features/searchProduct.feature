Feature: Search and place the order for products

  Scenario Outline: Search experience for product search in home and offers page
    Given User is on greenCart Landing Page
    When user search shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And validate product name in offers page matches with Landing page
    
    Examples:
    |Name |
    |Tom |
    |Tom |
    
