Feature: To validate the dropdown fuctionality

  Background:
    Given user navigates to spicejet homepage

  @dynamicdropdown
  Scenario: To validate from dropdown functionality in spicejet
    When user selects city in from dropdown
    Then user selects city in to dropdown

  @currencydropdown
  Scenario: To validate the iteration of currency values
    When user clicks on currency dropdown
    And user gets the currency dropdown values

  @passenger
  Scenario:to handle the static dropdown
    When user clicks dropdown beside the passenger
    Then user selects adults,child and infant values in the dropdown respectively

  @calendar
  Scenario: To validate the calendar functionality
    When user clicks on current month date
    Then user clicks on april month date

  @droplist
  Scenario: To validate iteration of dropdown values with help of list
    When iterates dropdown values using list


