@Tupperware @Regression
Feature: Validate all the business reports including Dashboard Report, Personal report and Custom report

  Background: Validate various business reports
    Given User is on "Business" Portal
    And User login to the application with "CA_User" on "Business" Portal
    And User navigate to "Home" page

  @BusinessDashboardUI @TC_5 @Smoke @Sanity @Demo
  Scenario: Validate the Business Dashboard report and its functionality
    And User click on "Business Dashboard Icon" on "Home" page
    And User navigate to "Business Dashboard" page
    Then User click each report tab and validate reports are loading correctly

  @BusinessDashboard @TC_5 @Smoke
  Scenario: Validate that consultant is able to navigate to Business Dashboard report by clicking on 'Dashboard Report' menu from hamburger icon
    And User click on "Hamburger Icon" from side menu
    And User click on "My Business" from side menu
    And User click on "Dashboard Report" from side menu
    And User navigate to "Business Dashboard" page
    Then User click each report tab and validate reports are loading correctly

  @PersonalReport_PaymentSummary @TC_6 @Smoke @Sanity @Demo
  Scenario:Validate that consultant is able to see Payment Summary under Personal Report and it is working correctly
    And User click on "Hamburger Icon" from side menu
    And User click on "My Business" from side menu
    And User click on "Personal Report" from side menu
    And User click on "Payment Summary" from side menu
    And User navigate to "Personal Report: Payment Summary" page
    And User verify that Payment Summary are loading correctly

  @PersonalReport_PersonalHistory @TC_7 @Smoke @Sanity
  Scenario: Validate that consultant is able to see Personal History under Personal Report and it is working correctly
    And User click on "Hamburger Icon" from side menu
    And User click on "My Business" from side menu
    And User click on "Personal Report" from side menu
    And User click on "Personal History" from side menu
    And User navigate to "Personal Report: Personal History" page
    And User verify that personal history are loading correctly

  @PersonalReport_YearEndReport @TC_8 @Smoke @Sanity
  Scenario: Validate that consultant is able to see Year End Report Summary and it is working correctly
    And User click on "Hamburger Icon" from side menu
    And User click on "My Business" from side menu
    And User click on "Personal Report" from side menu
    And User click on "Year End Report" from side menu
    And User navigate to "Personal Report: Year End Report Summary" page
    And User verify that year end report summary are loading correctly

  @CustomReport @TC_9 @Smoke @Sanity
  Scenario: Validate that consultant is able to see Custom Report and it is working correctly
    And User click on "Hamburger Icon" from side menu
    And User click on "My Business" from side menu
    And User click on "Custom Reports" from side menu
    And User click on "Contact Listing" from side menu
    And User navigate to "Custom Report: Contact Listing" page
    And User click on "Hamburger Icon" from side menu
    And User click on "My Business" from side menu
    And User click on "Custom Reports" from side menu
    And User click on "Weekly Custom Report" from side menu
    And User navigate to "Custom Report: Weekly Custom Report" page

