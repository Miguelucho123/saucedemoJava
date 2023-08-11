#Author: Miguel Ángel Gutiérrez Echeverri
# language: en
Feature: Testing Cart Scenarios
    @AddOneProduct
    Scenario: As standard user I want to add one product to the cart successfully
      Given I enter to sauce page as "standard user"
      When I select the product called "Sauce Labs Backpack"
      Then The counter should contain the number "1"

    @Add2Product
    Scenario: As standard user I enter multiple products to the cart
      Given I enter to sauce page as "standard user"
      When I select the product called "Sauce Labs Backpack,Sauce Labs Onesie"
      Then The counter should contain the number "2"

    @AddProductFromDetail
    Scenario: As standard user I add product to cart from the detail
      Given I enter to sauce page as "standard user"
      When I select the product called "Sauce Labs Backpack" from the detail
      Then The counter should contain the number "1"

    @DeleteProductFromInventory
    Scenario: As standard user I delete product from inventory page
      Given I enter to sauce page as "standard user"
      When I select the product called "Sauce Labs Backpack,Sauce Labs Onesie"
      And Remove the product called "Sauce Labs Backpack"
      Then The counter should contain the number "1"

    @DeleteProductFromCart
    Scenario: As standard user I delete product previous selected from the cart
      Given I enter to sauce page as "standard user"
      When I select the product called "Sauce Labs Backpack"
      And Remove the product called "Sauce Labs Backpack" from the cart
      Then The counter should not appear
