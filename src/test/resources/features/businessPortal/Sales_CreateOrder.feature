@Tupperware @Regression
Feature: Validate that user is able to create Non party orders

  Background: Validate non party order creation
    Given User is on "Business" Portal
    And User login to the application with "US_User" on "Business" Portal
    Then User navigate to "Home" page
    And User click on "Hamburger Icon" from side menu
    And User click on "Sales" on "Sales- Create Non Party Order" page

  @CreateOrder @NonPartyOrder @NonPartyOrder_AddProduct @TC_10 @Smoke
    Scenario: Validate that consultant is able to navigate to Create Orders page and able to search product by ID or name
    Then User navigate to "Create Order" page
    And User adds product by searching product by Product_ID
    Then User adds product by searching product by Product_Name
    And User adds multiple product of different product category to the cart
    And User verify the added product of multiple category 
    And User verify that correct Order Total is displayed on Create Orders page
    
        
  @CreateOrder @NonPartyOrder @NonPartyOrder_DeleteProduct @DeleteProduct @TC_10 @Smoke @Demo
  Scenario: Validate that consultant is able to delete products and Order total is updated accordingly
    Then User navigate to "Create Order" page
    And  User adds product by searching product by Product_ID
    Then User adds product by searching product by Product_Name
    And User adds multiple product of different product category to the cart
    And User verify the added product of multiple category 
    And User verify that correct Order Total is displayed on Create Orders page
    Then User verify that delete icon is coming against products
    And User click on "Delete Icon" on "Sales- Create Non Party Order" page
    And User click on "No" on "Sales- Create Non Party Order" page
    And User verify that product is not deleted
    Then User click on "Delete Icon" on "Sales- Create Non Party Order" page
    And User click on "Yes" on "Sales- Create Non Party Order" page
    And User verify that product is deleted
    And User verify that correct Order Total is displayed on Create Orders page


  @CreateOrder @NonPartyOrder @NonPartyOrder_AddPayment @TC_11 @TC_12 @TC_13 @Smoke
  Scenario: Validate that consultant is able to add payment for non party orders
    Then User navigate to "Create Order" page
    And  User adds product by searching product by Product_ID
    Then User adds product by searching product by Product_Name
     And User verify that correct Order Total is displayed on Create Orders page
     And User click on Checkout button
     And User verify that Add Payment button is displayed
    Then User click on Add Payment button
    And User navigate to "Payment Options" page
    Then User click on existing payment card option
    And User click on "Select this card" on "Sales- Create Non Party Order" page


  @CreateOrder @NonPartyOrder @NonPartyOrder_AddPayment @TC_12 @Smoke
  Scenario: Validate that consultant is able to submit orders and order information is shown correctly
    Then User navigate to "Create Order" page
    And  User adds product by searching product by Product_ID
    Then User adds product by searching product by Product_Name
     And User verify that correct Order Total is displayed on Create Orders page
     And User click on Checkout button
     And User verify that Add Payment button is displayed
    Then User click on Add Payment button
    And User navigate to "Payment Options" page
    Then User click on existing payment card option
    And User click on "Select this card" on "Sales- Create Non Party Order" page
    And User click on Submit button on Create Order page
    And User verify that correct order details is coming on Order Information page
    And User click on Return to Order List on Order Information page







