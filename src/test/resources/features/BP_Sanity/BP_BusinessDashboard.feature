@Tupperware @Regression
Feature: Validate all the business reports including Dashboard Report, Personal report and Custom report

  Background: Validate business reports
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    And User navigates to "Home" page

  @BusinessDashboardUI @TC_5 @Smoke @Sanity
  Scenario: Validate the Business Dashboard report and its functionality
    And User clicks on "Business Dashboard Icon" on "Home" page
    And User navigates to "Business Dashboard" page
    And User verify "Various Elements" on "Business Dashboard" page
    And User verify "Various Elements" in Team tile
    And User verify "Various Elements" in Potential Earnings tile
    And User verify the toggling between This Month and What's Your Drive is working correctly

  @BusinessDashboard @TC_5 @Smoke
  Scenario: Validate that consultant is able to navigate to Business Dashboard report by clicking on 'Dashboard Report' menu from hamburger icon
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "My Business" from side menu
    And User clicks on "Dashboard Report" from side menu
    And User navigates to "Business Dashboard" page

  @PersonalReport_PaymentSummary @TC_6 @Smoke @Sanity
  Scenario:Validate that consultant is able to see Payment Summary under Personal Report and it is working correctly
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "My Business" from side menu
    And User clicks on "Personal Report" from side menu
    And User clicks on "Payment Summary" from side menu
    And User navigates to "Personal Report: Payment Summary" page
    And User verify "Various Elements" on "Personal Report: Payment Summary" page

  @PersonalReport_PersonalHistory @TC_7 @Smoke @Sanity
  Scenario: Validate that consultant is able to see Personal History under Personal Report and it is working correctly
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "My Business" from side menu
    And User clicks on "Personal Report" from side menu
    And User clicks on "Personal History" from side menu
    And User navigates to "Personal Report: Personal History" page
    And User verify "Various Elements" on "Personal Report: Payment Summary" page

  @PersonalReport_YearEndReport @TC_8 @Smoke @Sanity
  Scenario: Validate that consultant is able to see Year End Report Summary and it is working correctly
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "My Business" from side menu
    And User clicks on "Personal Report" from side menu
    And User clicks on "Year End Report" from side menu
    And User navigates to "Personal Report: Year End Report" page
    And User verify "Various Elements" on "Personal Report: Year End Report" page

  @CustomReport @TC_9 @Smoke @Sanity
  Scenario: Validate that consultant is able to see Custom Report and it is working correctly
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "My Business" from side menu
    And User clicks on "Custom Report" from side menu
    And User clicks on "Contact List" from side menu
    And User navigates to "Custom Report: Contact List" page
    And User verify "Various Elements" on "Custom Report: Contact List" page
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "My Business" from side menu
    And User clicks on "Custom Report" from side menu
    And User clicks on "Weekly Custom Report" from side menu
    And User navigates to "Custom Report: Weekly Custom Report" page
    And User verify "Various Elements" on "Custom Report: Weekly Custom Report" page

