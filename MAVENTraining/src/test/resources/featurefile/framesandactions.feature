Feature: To validate the functionality of frames and action class in various scenarios

  @globalsqa
  Scenario: To validate the frame handling
    Given user navigates to globalsqa homepage
    And user extracts the mailid from homepage

  @yourstore
  Scenario: To validate the mouse handling
    Given user navigates to yourstore homepage
    When user clicks on monitor after selecting components
    And user navigates to monitor page
    Then user extacts value and add it to 60


