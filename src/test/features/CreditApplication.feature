Feature: Orion Finance Finco Test Scenarios / Credit Application - BAŞVURU

  Background: System Login
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "1001" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
