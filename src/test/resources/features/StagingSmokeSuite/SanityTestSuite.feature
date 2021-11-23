@tag
Feature: Tupperwarae Sanity Test Suite

  @SANITYTESTSUIT
  Scenario Outline: Verify dashboard reports
    Given Consultant login to the application with valid <userName> and <password>
    And I navigate to Business dashboard page
    Then I click each report tab and validate reports are loading correctly
    Then I navigate to each personal report and verify pages are loading correctly

    Examples: 
      | userName          | password          |
      |consultant-userName|consultant-password|
     #| PATTYK            | test              |
      
  @SANITYTESTSUIT
  Scenario Outline: Verify create personal order
    Then I navigate to Create personal order page
    Then I create personal order <itemCode>, <fName>, <sName>, <address1>, <city>, <postalCode>, <cardNo>, <cvn>, <month>, <year>, <state>

    Examples: 
      |itemCode| fName| sName| address1          | city  | postalCode| cardNo         | cvn|month|year|state  |
      |02-3617 |James |Croff |4138 Elphinstone St|Regina |S4S 3L2    |4111111111111111| 222|10   |2029|Alberta|
      
  @SANITYTESTSUIT
  Scenario Outline: Verify party order
    Then I navigate to party order page
    Then I create a party order by adding a host <fName>, <email>, <phone>, <address1>, <city>, <postalCode>, <eventName>, <cardNo>, <cvn>, <month>, <year>, <state>
  	
  	Examples:																						
      | fName| email          |phone     | address1          | city   | postalCode|province|eventName | cardNo         | cvn|month|year|state  |
      |James |james@croff.com |0123456789|4138 Elphinstone St|Toronto |S4S 3L2    |Quebec  |Jazz Night|4111111111111111| 222|10   |2029|Alberta|
      
      