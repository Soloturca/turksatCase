Feature: Orion Finance Finco Test Scenarios

  @Payment
Scenario: Login Finco
  Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
  Then I see login page
  And I enter "admin" text to username text area
  Then I enter "" text to password text area
  And I wait login button element 30 seconds at index 1
  When I click element: login button index: 1
