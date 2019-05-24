Feature: I can fill a shopping cart
  I can add products to it and the total amount is set accordingly.

  Scenario Outline: Adding a product
    Given an empty shopping cart
    And a product which costs <price>
    When I add the product to the shopping cart
    Then the shopping cart contains the product
    And the total number of products is 1
    And the total amount is <price>

    Examples:
      | price |
      | 1.0   |
      | 5.0   |

  Scenario: Adding many products
    Given an empty shopping cart
    And a list of products:
      | name  | lamp | laptop | keyboard |
      | price | 40.0 | 900.0  | 60.0     |
    When I add all the products to the shopping cart
    Then the shopping cart contains all the products
    And the total number of products is 3
    And the total amount is 1000.0