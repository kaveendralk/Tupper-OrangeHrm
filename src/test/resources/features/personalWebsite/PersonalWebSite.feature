@tag
Feature: Personal web site

  @PERSONALWEBSITE
  Scenario Outline: Verify dashboard reports
    Given Consultant login to the application with valid <userName> and <password>
    And I navigate to Personal web site page
    Then I click each report tab and validate reports are loading correctly
    Then I navigate to each personal report and verify pages are loading correctly

    Examples: 
      | userName    | password|
      | PATTYK      | test    |