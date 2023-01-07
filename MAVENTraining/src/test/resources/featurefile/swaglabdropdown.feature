Feature: To validate the iteration of dropdown values

  Background:
    Given User navigates to the swaglab login page
    
@swaglab
  Scenario: To validate the iteration of swaglab dropdown values
    When User enter the swag username and password
    And User clicks on the login button
    Then User should navigate to the swaglab homepage
    And User gets the values from the dropdown
