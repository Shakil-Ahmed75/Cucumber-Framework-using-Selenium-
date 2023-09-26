Feature: Search and place the order for products.

  Scenario: Search experience for product search in home and offers page.
    Given User is on greenCart Landing Page.
    When user search short name "Tom" and extracted actual name of product.
    Then User searched for same shorted name in offers page to check if product exist.
