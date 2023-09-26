Feature: Search and place the order for products

  Scenario: Search experience for product search in home and offers page
    Given User is on greenCart Landing Page
    When user search shortname "Tom" and extracted actual name of product
    Then User searched for "Tom" shortname in offers page
    And validate product name in offers page matches with Landing page
