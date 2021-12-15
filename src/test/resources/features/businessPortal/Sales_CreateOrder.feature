@Tupperware @Regression
Feature: Validate that user is able to create Non party orders

  Background: Validate non party order creation
    Given User is on "Business" Portal
    And User login to the application with "US_User" on "Business" Portal
    Then User navigate to "Home" page
    And User click on "Hamburger Icon" from side menu
    And User click on "Sales" on "Sales- Create Non Party Order" page

  @CreateOrder @NonPartyOrder @NonPartyOrder_AddProduct @TC_10 @Smoke @Demo
    Scenario: Validate that consultant is able to navigate to Create Orders page and able to search product by ID or name
    Then User navigate to "Create Order" page
    And User adds product by searching product by Product_ID
    Then User adds product by searching product by Product_Name
    And User adds multiple product of different product category to the cart
    And User verify the added product of multiple category 
    And User verify that correct Order Total is displayed on Create Orders page
    
        
  @CreateOrder @NonPartyOrder @NonPartyOrder_DeleteProduct @DeleteProduct @TC_10 @Smoke
  Scenario: Validate that consultant is able to delete products and Order total is updated accordingly
    Then User navigate to "Create Order" page
    And  User adds product by searching product by Product_ID
    Then User adds product by searching product by Product_Name
    And User adds multiple product of different product category to the cart
    And User verify the added product of multiple category 
    And User verify that correct Order Total is displayed on Create Orders page
    And User verify that delete icon is coming against products
    And User clicks on "Delete Icon" on "Sales- Create Non Party Order" page
    Then "Product Deletion Confirmation" overlay is opened
    And User verify "Various elements" on "Product Deletion Confirmation" overlay
    And User clicks on "No" on "Product Deletion Confirmation" overlay
    And User verify that product is not deleted
    And User clicks on "Delete Icon" on "Create Order" page
    Then "Product Deletion Confirmation" overlay is opened
    And User clicks on "Yes" on "Product Deletion Confirmation" overlay
    And User verify that product is deleted
    And User verify that "Checkout button" is not displayed on "Create Order" page

  @CreateOrder @NonPartyOrder @NonPartyOrder_AddPayment @TC_11 @Smoke
  Scenario: Validate that consultant is able to add payment for non party orders
    Then User navigates to "Create Order" page
    Then User adds product by searching product by "Product_Name"
    And User verify that correct product is added
    And User clicks on "Checkout button" on "Home" page
    And User verify that "Add Payment button" is displayed on "Create Order" page
    Then "Payment Options" overlay is opened
    And User verify "Various elements" on "Payment Options" overlay
    And User clicks on "Add New Card" on "Payment Options" overlay
    Then User navigates to "Payment Details" page
    And User verify "Various Elements" on "Payment Details" page
    And User choose to enter "Visa" card details and press Next
    And User verify that correct payment information is added

  @CreateOrder @NonPartyOrder @NonPartyOrder_AddPayment @TC_12 @Smoke
  Scenario: Validate that consultant is able to submit orders and order information is shown correctly
    Then User navigates to "Create Order" page
    Then User adds product by searching product by "Product_Name"
    And User verify that correct product is added
    And User clicks on "Checkout button" on "Home" page
    And User verify that "Add Payment button" is displayed on "Create Order" page
    Then "Payment Options" overlay is opened
    And User clicks on "Add New Card" on "Payment Options" overlay
    Then User navigates to "Payment Details" page
    And User choose to enter "Visa" card details and press Next
    And User verify that correct payment information is added
    And User clicks on "Submit button" on "Create Order" page
    Then User navigates to "Order Information" page
    And User verify that correct order details is coming on Order Information page
    And User clicks on "Return to Order List" on "Order Information" page
    Then User navigates to "View Orders" page


  @CreateOrder @NonPartyOrder @TC_13 @Sanity
  Scenario: Validate that consultant is able to place non party orders
    Then User navigates to "Create Order" page
    And User verify "Profile Information elements" on "Create Order" page
    Then User adds product by searching product by "Product_ID"
    And User verify that correct product is added
    Then User adds product by searching product by "Product_Name"
    And User verify that correct product is added
    And User clicks on "Browse Products" on "Home" page
    Then "Browse By Category" overlay is opened
    And User adds first product to the cart
    And User verify that correct product is added
    And User verify that correct Order Total is displayed on Create Orders page
    And User clicks on "Checkout button" on "Home" page
    And User verify that "Add Payment button" is displayed on "Create Order" page
    Then "Payment Options" overlay is opened
    And User clicks on "Add New Card" on "Payment Options" overlay
    Then User navigates to "Payment Details" page
    And User verify "Various Elements" on "Payment Details" page
    And User choose to enter "Visa" card details and press Next
    And User verify that correct payment information is added
    And User clicks on "Submit button" on "Create Order" page
    Then User navigates to "Order Information" page
    And User verify that correct order details is coming on Order Information page
    And User clicks on "Return to Order List" on "Order Information" page
    Then User navigates to "View Orders" page


