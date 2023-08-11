#Author: Miguel Ángel Gutiérrez Echeverri
# language: en
Feature: Checkout flow for sauce page

  @E2E
  Scenario: As standard user I want to buy any product
    Given I enter to sauce page as "standard user"
    When I select the product called "Sauce Labs Backpack"
    And Complete the checkout process with the data
    |firstName|lastName|zipCode|
    |Automation|MGTest |900001 |
    Then Should appear the message "Thank you for your order!"