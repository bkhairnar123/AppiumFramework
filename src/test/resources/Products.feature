
Feature: Product scenarios

  Scenario Outline: Validate product info on Products page
    Given I'm logged in
    Then the product is listed with title "<title>" and price "<price>"
    Examples:
      | title                   | price |
      | Sauce Labs Bolt T-Shirt | $15.99 |


