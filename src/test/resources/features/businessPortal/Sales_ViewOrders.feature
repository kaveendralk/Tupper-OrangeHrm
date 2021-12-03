@Tupperware @Regression
Feature: Validate that View Orders page

  Background: Validate non party order creation
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    Then User navigates to "Home" page
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "Sales" from side menu
    And User clicks on "View Orders" from side menu

  @ViewOrders @TC_14 @Smoke @Sanity
    Scenario: Validate that consultant is able to navigate to View Order pages
    Then User navigates to "View Orders" page
    And User verify "Various Elements" on "View Orders" page
    And User verify results count and pagination for total orders
    And User clicks on "Create Order button" on "View Orders" page
    Then User navigates to "Create Order" page


  @ViewOrders @ViewOrders_Search @TC_15 @Smoke
  Scenario: Validate that consultant is able search Orders by product name as well as Order number
    Then User navigates to "View Orders" page
    And User choose to search orders using "Order Number"
    And User verify that only relevant orders matching to search is shown
    And User choose to search orders using "Product Name"
    And User verify that only relevant orders matching to search is shown
    And User verify results count and pagination for total orders

  @ViewOrders @ViewOrders_Delete @TC_16 @Smoke
  Scenario: Validate that Consultant is able to view Order information as well able to delete Pending Orders by clicking on icons against the Orders
    Then User navigates to "View Orders" page
    And User verify that delete icon is coming against the order having status as 'Pending'
    And User clicks on "View Info Icon" on "View Orders" page
    Then User navigates to "Order Information" page
    And User clicks on "Browser Back Icon" on "Order Information" page
    Then User navigates to "View Orders" page
    And User clicks on "Delete Icon" on "View Orders" page
    Then "Order Deletion Confirmation" overlay is opened
    And User verify "Various elements" on "Order Deletion Confirmation" overlay
    And User clicks on "Ok Button" "Order Deletion Confirmation" overlay
    Then User verify that an alert for deletion is displayed
    Then User verify that order has been deleted

  @ViewOrders @ViewOrders_FilterByCount @TC_17 @Smoke
  Scenario: Validate that Consultant is able to view orders based on the count
    Then User navigates to "View Orders" page
    And User verify results count and pagination for total orders
    And User choose value as "10" from View Filter
    Then User verify that only selected count of orders is displayed
    Then User verify the pagination in the bottom
    And User choose value as "30" from View Filter
    Then User verify that only selected count of orders is displayed
    Then User verify the pagination in the bottom