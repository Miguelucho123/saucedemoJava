#Author: Miguel Ángel Gutiérrez Echeverri
# language: en
  Feature: Tests for each functionality of login for the page sauce

    @LoginSuccess
    Scenario: As standard user I want to login successfully
      Given I enter to sauce page
      When I enter as "standard_user" with the password "secret_sauce"
      Then I should see into URL the "inventory"

    @LoginWrong
    Scenario: As standard user I enter to platform with wrong credentials
      Given I enter to sauce page
      When I enter as "standard_user" with the password "arroz123"
      Then I should see the error message "Epic sadface: Username and password do not match any user in this service"

    @LoginWithBlockedUser
    Scenario: As blocked user I enter to platform with my credentials
      Given I enter to sauce page
      When I enter as "locked_out_user" with the password "secret_sauce"
      Then I should see the error message "Epic sadface: Sorry, this user has been locked out."