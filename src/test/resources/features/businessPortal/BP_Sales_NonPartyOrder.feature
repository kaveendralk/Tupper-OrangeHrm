@Tupperware @Regression
Feature: Validate that consultant is able to submit orders and order information is shown correctly

Background: Validate creation of non party orders
  Given User is on "Business" Portal
  And User login to the application with "US_User" on "Business" Portal
  And User navigate to "Home" page
 
  @CreateOrder @NonPartyOrder @TC_10 @TC_11  @TC_13 @Sanity @Smoke
  Scenario: Validate that consultant is able to place non party orders
    And User click on "Hamburger Icon" from side menu
    And User click on "Sales- Create Non Party Order" from side menu
    And User select type of order and navigate to Create Order page
    And User add product from "Browse By Category" overlay
    And User verify that correct product is added
   
  @CreateOrder @TC_10 @TC11 @Smoke
  Scenario: Validate that consultant is able to checkout the product
    And User click on "Hamburger Icon" from side menu
    And User click on "Sales- Create Non Party Order" from side menu
    And User select type of order and navigate to Create Order page
    And User add product from "Browse By Category" overlay
    And User verify that correct product is added
    And User clicks on Checkout button 
    And User verify that Add Payment button is displayed and Click
    Then verify Payment Options overlay is opened
    
  @CreateOrder @TC_10 @TC_12 @Smoke @Demo @CreateNonPartyOrder_Demo
  Scenario: Validate that consultant is able to submit orders and order information is shown correctly
    And User click on "Hamburger Icon" from side menu
    And User click on "Sales- Create Non Party Order" from side menu
    And User select type of order and navigate to Create Order page
    And User add product from "Browse By Category" overlay
    And User verify that correct product is added
    And User clicks on Checkout button
    And User verify that Add Payment button is displayed and Click
    Then verify Payment Options overlay is opened
    And User clicks on Add New Card on Payment Options overlay
    And User verify shipping and payment details on Payment Details page
    And User choose to enter Visa card details and press Next
    And User clicks on Submit button on Create Order page
    And User verify that correct order details is coming on Order Information page
    And User clicks on Return to Order List on Order Information page
    
  
    
