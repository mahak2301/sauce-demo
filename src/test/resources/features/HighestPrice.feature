Feature: Add highest priced item to the cart using SauceDemo website

  Background: User is on SauceDemo website
    Given User is on the SauceDemo website "https://www.saucedemo.com/"

  @regression
  Scenario: Add highest priced item to the cart without sorting
    When  User enters username "standard_user" and password "secret_sauce"
    And   User clicks on login button
    Then  User navigates to "https://www.saucedemo.com/inventory.html"
    Then  User selects the highest priced item and adds to cart


