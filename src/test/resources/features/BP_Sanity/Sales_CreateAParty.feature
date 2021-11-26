@Tupperware @Regression
Feature: Validate the creation of party orders

  Background: Validate party order creation
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    Then User navigates to "Home" page
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "Sales" from side menu
    And User clicks on "View Orders" from side menu

  @ViewOrders @TC_18 @Smoke @Sanity
    Scenario: Validate that consultant is able to create a new party by adding existing host and is able to save changes
