@Tupperware @Regression @Sanity @Smoke
Feature: Validate the home page of business portal

  @NoPartyOrder @TC_8 @TestRestructuring
  Scenario: Validate that consultant is able to place non party orders
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    And User navigates to "Home" page
    And User clicks on "Place Order CTA" on "Home page"

  
  