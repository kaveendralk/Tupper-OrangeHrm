@Tupperware @Regression
Feature: Validate that View Orders page

  Background: Validate non party order creation
    Given User is on "Business" Portal
    And User login to the application with "US_User" on "Business" Portal
    And User navigate to "Home" page 
    And User click on "Hamburger Icon" from side menu
    And User click on "Sales" from side menu
    And User click on "View Orders" from side menu

  @ViewOrders @TC_14 @Smoke @Sanity 
    Scenario: Validate that consultant is able to navigate to View Order pages
    Then User navigate to "View Orders" page
    And User verify results count and pagination for total orders
    And User click on "Create Order button" on "View Orders" page
    Then User navigate to "Create Order" page
    
@ViewOrders @ViewOrders_Search @TC_15 @Smoke 
  Scenario: Validate that consultant is able search Orders by product name as well as Order number
    Then User navigate to "View Orders" page
    And User choose to search orders using Order Number
    And User verify that only relevant orders matching to order number search displayed
    And User choose to search orders using Product ID
    And User verify that only relevant orders matching to product ID search  displayed
   

  @ViewOrders @ViewOrders_Delete @TC_16 @Smoke 
  Scenario: Validate that Consultant is able to delete Pending Orders by clicking on icons against the Orders
    Then User navigate to "View Orders" page
    And  User choose to search orders using pending status
    And User verify that delete icon is coming against the order having status as Pending
    And User click on "Delete Icon" on "View Orders" page
    Then Order Deletion Confirmation overlay is opened
  	Then User verify that an alert for deletion is displayed
  	And User click on "Ok Button" on "View Orders" page
   
    
  @ViewOrders @ViewOrders_Delete @TC_16 @Smoke 
  Scenario: Validate that Consultant is able to view Order information Page
    Then User navigate to "View Orders" page
    And User choose to search orders using Order Number
     And User verify that only relevant orders matching to order number search displayed
     And User click on "View Info Icon" on "View Orders" page
    Then User navigate to "Order Information" page
    And User click on "Return to Order" on "Order Information" page
    Then User navigate to "View Orders" page

  @ViewOrders @ViewOrders_FilterByCount @TC_17 @Smoke
  Scenario: Validate that Consultant is able to view orders based on the count
    Then User navigate to "View Orders" page
    And User verify results count and pagination for total orders
    And User choose value as "10" from View Filter
    Then User verify that only selected count of orders is displayed
    Then User verify the pagination in the bottom
    And User choose value as "30" from View Filter
    Then User verify that only selected count of orders is displayed
    Then User verify the pagination in the bottom