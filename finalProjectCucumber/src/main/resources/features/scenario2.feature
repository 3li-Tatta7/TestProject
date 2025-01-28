Feature: End To End Scenario
  @End-To-End
  Scenario: User logs in, adds products to cart, and completes purchase
    Given User opens homepage and logs in with "alifathi" and "123456789" User sees their username on the homepage
    And User is on the homepage
    And User clicks on Laptops category
    And User selects Sony Vaio i5
    And User adds the product to the cart
    And User sees a confirmation message
    And User clicks on Home button
    And User clicks on Laptops category
    And User selects Sony Vaio i7
    And User adds the product to the cart
    And User sees a confirmation message
    When User clicks on Cart button
    And User checks that the products are in the cart
    And User checks the price of each product and the total price
    And User places an order
    And User fills in the order details with "Ali", "egy", "shar", "12", "12", "2022"
    And User clicks on Purchase button
    Then User should see a thank you message
    And User verifies the order is completed successfully
