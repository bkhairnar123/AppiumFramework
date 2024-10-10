@test
Feature: Login scenarios



    @bkhairnar
  Scenario: Login with invalid password
    Given I am on Homepage of application
    When I enter username and password from excel
    And I click on login button
    Then login should fail with an error

   @bkhairnar
  Scenario: Login with valid user name and password
    Given I am on Homepage of application
    When I enter correct username and password
    And I click on login button
    Then I should see Products page with title
