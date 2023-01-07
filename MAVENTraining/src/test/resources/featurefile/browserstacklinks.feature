Feature: To validate the hyperlink functionality in various scenarios

  Background:
    Given user navigates to browserstack homepage

  @browserstack
  Scenario: To validate hyperlink in browserstack footer
    Then user validates the hyperlinks in the footer

  @linkset
  Scenario: To validate number of links with help of set
    When count links using set



