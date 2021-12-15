@Tupperware @Regression
Feature: Validate the Login page and home page of business portal

  @Login @TC_01 @Smoke @Demo
  Scenario Outline: Validate that Consultant is able to login in BP portal with valid credentials for CA user
    Given User is on "Business" Portal
    And User login to the application with "<County_User>" on "Business" Portal
    And User navigate to "Home" page

    Examples:
      | County_User |
      | CA_User     |
      | US_User     |

  @ForgotPassword @TC_2 @Smoke
    Scenario: Validate that Consultant is able to reset password using Forgot Password link
    Given User is on "Business" Portal
    And User click on "Forgot Password" on "Home" page
    Then User navigate to "Forgot Password" page
    And User choose to enter "userName" in "User Name" field on "Forgot Password" page
    And User click on "Email Link" on "Login" page

  @HomePageUI @TC_3 @Smoke @Sanity @Demo
  Scenario: Validate that consultant is able to see the correct UI on home page
    Given User is on "Business" Portal
    And User login to the application with "CA_User" on "Business" Portal
    And User navigate to "Home" page
    And User verify that home page is appearing correctly
    And User verify What's new tiles
    And User verify Knowledge Center tiles

  @HomePageUI @TC_4 @Smoke @Demo
  Scenario: Validate that all the links are coming in main menu under Hamburger icon
    Given User is on "Business" Portal
    And User login to the application with "CA_User" on "Business" Portal
    And User navigate to "Home" page
    And User click on "Hamburger Icon" from side menu
    And User verify that all the menu links are coming correctly

