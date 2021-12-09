@Tupperware @Regression
Feature: Validate that consultant is able to submit orders and order information is shown correctly

@Login @TC_01 @Smoke @Sanity 
  Scenario: Validate that Consultant is able to login in BP portal with valid credentials
  Given User is on "Business" Portal
  And User logins to the application with "validLogin" on "Business" Portal
  And User navigates to "Home" page
 
  @CreateOrder @NonPartyOrder @TC_10 @TC_11  @TC_13 @Sanity @Smoke 
  Scenario: Validate that consultant is able to place non party orders
    And  User clicks on "Place Order CTA" on "Home page" 
    Then "Browse By Category" overlay is opened
    And User verify that correct product is added
   
  @CreateOrder @TC_10 @TC11 @Smoke 
  Scenario: Validate that consultant is able to checkout the product
    And User clicks on Checkout button 
    And User verify that Add Payment button is displayed and Click
    Then verify Payment Options overlay is opened
    
  @CreateOrder @TC_10 @TC11 @Smoke
  Scenario: validate that consultant is able to add payment for selected product
    And User clicks on Add New Card on Payment Options overlay
    And User verify shipping and payment details on Payment Details page
    And User choose to enter Visa card details and press Next
    And User clicks on Submit button on Create Order page
    And User verify that correct order details is coming on Order Information page
    And User clicks on Return to Order List on Order Information page
    
  
    
