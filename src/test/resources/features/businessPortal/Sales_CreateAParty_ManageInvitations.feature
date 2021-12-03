@Tupperware @Regression
Feature: Validate the creation of Party orders

  Background: Validate Party order creation
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

  @CreateParty @PartyOrder @ManageInvitations @TC_22 @Smoke @Sanity
    Scenario: Validate that consultant is Add Guests (existing guest or creating by new guest)
    Then User navigates to "Manage Invitations" page
    And User verify "Various Elements" on "Manage Invitations" page
    And User clicks on "Add Guest button" on "Manage Invitations" page
    Then "Add Guest" overlay is opened
    And User choose to search guest using "guest name"
    Then User verify that suggestion is shown matching to search key
    And User clicks on "First Autosuggestion" on "Add Guest" overlay
    Then User navigates to "Manage Invitations" page
    And User verify that correct guest is added in Party
    And User clicks on "Add Guest button" on "Manage Invitations" page
    Then "Add Guest" overlay is opened
    And User clicks on "Create New Guest" on "Add Guest" overlay
    Then "Create New Guest" overlay is opened
    And User verify "Various Elements" on "Create New Guest" overlay
    And User choose to fill all the fields in 'Create New Guest' overlay
    And User clicks on "Create New Guest button" on "Create New Guest" overlay
    And User verify that correct guest is added in Party


  @CreateParty @PartyOrder @ManageInvitations @TC_22 @Smoke @Sanity
  Scenario: Validate that consultant is able to delete guest, edit guest, send reminders, send invite etc.
    Then User navigates to "Manage Invitations" page
    And User clicks on "Add Guest button" on "Manage Invitations" page
    Then "Add Guest" overlay is opened
    And User clicks on "Create New Guest" on "Add Guest" overlay
    Then "Create New Guest" overlay is opened
    And User choose to fill all the fields in 'Create New Guest' overlay
    And User clicks on "Create New Guest button" on "Create New Guest" overlay
    And User verify that correct guest is added in Party
    And User verify that 'Send All pending invites' is enabled
    And User verify that 'Send All reminders' is enabled
    And User clicks on "Ellipsis" on "Manage Invitations" page
    Then User verify that Send Invite, Edit Details and Remove Guest links are displayed
    And User clicks on "Send Invite Icon" on "Manage Invitations" page
    Then "Send Invite" overlay is opened
    And User verify "Various Elements" on "Send Invite" overlay
    And User clicks on "Theme Image" on "Send Invite" overlay
    And User choose to fill body message on Send Invite overlay
    And User clicks on "Send button" on "Send Invite" overlay
    And User verify that success message is displayed for sending invite
    And User clicks on "Ellipsis" on "Manage Invitations" page
    And User clicks on "Edit Details Icon" on "Manage Invitations" page
    Then "Edit Details" overlay is opened
    And User verify "Various Elements" on "Edit Details" overlay
    And User choose to edit guest details
    And User clicks on "Submit button" on "Edit Details" overlay
    And User verify that success message is displayed for edit details
    And User clicks on "Ellipsis" on "Manage Invitations" page
    And User clicks on "Remove Guest Icon" on "Manage Invitations" page
    Then "Guest Deletion confirmation" alert is displayed
    And User verify "Various Elements" on "Guest Deletion confirmation" alert
    And User clicks on "Remove Guest button" on "Guest Deletion confirmation" overlay
    And User verify that success message is displayed for removal of guest
    And User verify that guest is removed
    And User verify Invitation count after adding Guest and sendig invitation






