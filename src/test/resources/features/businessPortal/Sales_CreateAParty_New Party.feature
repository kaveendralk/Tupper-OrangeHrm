@Tupperware @Regression
Feature: Validate the creation of Party orders

  Background: Validate Party order creation
    Given User is on "Business" Portal
    And User logins to the application with "validLogin" on "Business" Portal
    Then User navigates to "Home" page
    And User clicks on "Hamburger Icon" from side menu
    And User clicks on "Sales" from side menu
    And User clicks on "Create A Party" from side menu

  @CreateParty @NewParty @TC_18 @Smoke @Sanity
    Scenario: Validate that consultant is able to create a new party by adding existing host and is able to save changes
    Then User navigates to "New Party" page
    And User verify "Various Elements" on "New Party" page
    And User clicks on "Select Party Host link" on "New Party" page
    Then "Select Party Host" overlay is opened
    And User choose to search host using "host name"
    Then User verify that suggestion is shown matching to search key
    And User clicks on "First Autosuggestion" on "Select Party Host" overlay
    Then User navigates to "New Party" page
    And User verify that correct host is added in Party

  @CreateParty @NewParty @TC_19 @Smoke @Sanity
  Scenario: Validate that consultant is able to create a new party after creating a new host and is able to save changes
    Then User navigates to "New Party" page
    And User clicks on "Select Party Host link" on "New Party" page
    Then "Select Party Host" overlay is opened
    And User clicks on "Create A new Host" on "Select Party Host" overlay
    Then "Create New Host" overlay is opened
    And User verify "Various Elements" on "Create New Host" overlay
    And User choose to fill all the fields in 'Create New Host' overlay
    And User clicks on "Create New Host button" on "Create New Host" overlay
    And User verify that correct host is added in Party

  @CreateParty @NewParty @TC_20 @Smoke
  Scenario: Validate that consultant is able to change Shipping address as well as Party Address
    Then User navigates to "New Party" page
    And User clicks on "Select Party Host link" on "New Party" page
    Then "Select Party Host" overlay is opened
    And User choose to search host using "host name"
    And User clicks on "First Autosuggestion" on "Select Party Host" overlay
    Then User navigates to "New Party" page
    And User verify that correct host is added in Party
    And User verify various elements on Party Information section
    And User click on "Change Address" against Shipping address on "New Party" page
    Then "Shipping Address" overlay is opened
    And User choose to fill all the fields in 'Shipping Address' overlay
    And User clicks on "Save button" on "Shipping Address" overlay
    Then User navigates to "New Party" page
    And User verify that correct shipping address is displayed
    And User click on "Change Address" against Party address on "New Party" page
    Then "Party Address" overlay is opened
    And User choose to fill all the fields in 'Party Address' overlay
    And User clicks on "Save button" on "Party Address" overlay
    Then User navigates to "New Party" page
    And User verify that correct party address is displayed

  @CreateParty @NewParty @CancelParty @TC_21 @Smoke
  Scenario: Validate that consultant is able to Cancel the party
    Then User navigates to "New Party" page
    And User clicks on "Select Party Host link" on "New Party" page
    Then "Select Party Host" overlay is opened
    And User choose to search host using "host name"
    And User clicks on "First Autosuggestion" on "Select Party Host" overlay
    Then User navigates to "New Party" page
    And User clicks on "Cancel Button" on "New Party" page
    And "Leave Site" alert is shown
    And User clicks on "Leave Button" on "Cancel Party Confirmation" alert
    Then User navigates to "Home" page

  @CreateParty @NewParty @TC_18 @TC_19 @Smoke @Sanity
  Scenario: Validate that consultant enters all the details and able to navigate to 'Manage Invitations' page
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
    And User verify that party information is saved


