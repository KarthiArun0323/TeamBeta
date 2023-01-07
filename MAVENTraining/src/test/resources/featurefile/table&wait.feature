Feature: To validate the functionality of tables and wait functionality in various scenarios

  @cricbuzz
  Scenario: To validate the table functionality in crickbuzz homepage
    Given user navigates to cricbuzz scorecard homepage
    Then user iterates the values
    And user validates the totals are equal

  @wikipedia
   Scenario: To validate the table functionality in wikipedia
     Given user navigates to wikipedia page
     Then user validates the table

  @waittoolsqa
  Scenario:To validate the explicit wait functionality in toolsqa
    Given user navigates to the demoqa homepage
    Then user validates the button should load only after 5sec
