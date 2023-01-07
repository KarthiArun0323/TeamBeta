Feature: To validate the alert functionality in various scenarios

  Background:
    Given navigate to alert url

  @alertgettext
  Scenario: To validate getting text
    When clicks on button
    Then iterates the text value

  @alertafter5sec
  Scenario: To validate alert after 5sec
    When clicks on alert after 5sec button
    Then clicks on ok button

  @confirmalert
  Scenario: To validate confirm alert
    When validates confirm alert
    Then validates confirm result

  @promptbox
  Scenario: To validate prompt box
    When validates prompt box
    Then validate prompt result

