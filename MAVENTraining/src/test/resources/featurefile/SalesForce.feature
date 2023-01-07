Feature: To validate the functionality of salesforce login page

  Background:
    Given User navigates to the login page

  @smoketest
  Scenario: To validate the login functionality with valid username and password
    When User enter the username "Arun" and password "0323"
    And User clicks the login button
    Then User should navigate to the homepage

    @regressiontest
  Scenario: To validate the login functionality with invalid username and password
    When User enter the username "hbjhj" and password "65787"
    And User clicks the login button
    Then User should validate the error message

  @performancetest @regressiontest
  Scenario Outline: To validate the login functionality with multiple username and password
    When User enter the username "<username>" and password "<password>"
    And User clicks the login button
    Then User should navigate to the homepage
    Examples:
      | username | password |
      | karthi   | 2303     |
      | karun    | 9195     |
      | amuthan  | 1068     |


  @constructorinsalesforce
  Scenario: To validate login functionality in salesforce using constructor
    When user enter username and password
    And clicks on login
    Then validates error


