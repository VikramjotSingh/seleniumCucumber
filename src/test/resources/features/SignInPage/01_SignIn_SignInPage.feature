Feature: Order T-shirt

 @signinpage
  Background: Login into application
    Given I am on Website
    When I enter username and password
    Then I am successfully logged in
    
  @signinpage
  Scenario: Verify Order History
    Given I am logged in to application
    When I select the T-shirt
    And I order the T-shirt
    Then I can see ordered T-shirt in Order History
   