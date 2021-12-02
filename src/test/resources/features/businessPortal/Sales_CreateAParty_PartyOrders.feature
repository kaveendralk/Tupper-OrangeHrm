@Tupperware @Regression
Feature: Validate that products can be added in Party Orders

  Background: Validate Party Orders while creating Party
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    Then User navigates to "Home" page
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "Sales" from side menu
    And User clicks on "Create A Party" from side menu
    Then User navigates to "New Party" page
    And User clicks on "Select Party Host link" on "New Party" page
    Then "Select Party Host" overlay is opened
    And User choose to search host using "host name"
    And User clicks on "First Autosuggestion" on "Select Party Host" overlay
    Then User navigates to "New Party" page
    And User select Date and timezone for party
    And User choose to enter "Party name" in "New Party" page
    And User clicks on "Save Icon" on "New Party" page
    And User navigates to "Party Details" page
    And User clicks on "Manage Invitations" on "Party Details" page
    Then User navigates to "Manage Invitations" page
    And User clicks on "Add Guest button" on "Manage Invitations" page
    Then "Add Guest" overlay is opened
    And User clicks on "Create New Guest" on "Add Guest" overlay
    Then "Create New Guest" overlay is opened
    And User choose to fill all the fields in 'Create New Guest' overlay
    And User clicks on "Create New Guest button" on "Create New Guest" overlay
    And User verify that correct guest is added in Party
    And User clicks on "Party Orders" on "Manage Invitations" page

  @CreateParty @PartyOrder @PartyOrders @TC_23 @Smoke @Sanity
  Scenario: Validate that consultant is able to place party orders as Consultant
    Then User navigates to "Party Orders" page



