@Tupperware @Regression
Feature: Validate the Login page and home page of business portal

  @Login @TC_01 @Smoke @TestRestructuring
  Scenario: Validate that Consultant is able to login in BP portal with valid credentials
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    And User navigates to "Home" page

  @ForgotPassword @TC_2 @Smoke
    Scenario: Validate that Consultant is able to reset password using Forgot Password link
    Given User is on "Business" Portal
    And User clicks on "Create A Party"
    Then User navigates to "Forgot Password" page
    And User choose to enter "userName" in "User Name" field on "Forgot Password" page
    And User clicks on "Email Link" on "Login" page

  @HomePageUI @TC_3 @Smoke @Sanity
  Scenario: Validate that consultant is able to see the correct UI on home page
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    And User navigates to "Home" page
    And User verify "Various Elements" on "Home" page
    And User verify What's new tiles
    And User verify Knowledge Center tiles

  @HomePageUI @TC_4 @Smoke
  Scenario: Validate that all the links are coming in main menu under Hamburger icon
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    And User navigates to "Home" page
    And User clicks on "Hamburger Icon" from side menu
    And User verify various links in side menu