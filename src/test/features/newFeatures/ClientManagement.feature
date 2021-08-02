Feature: Orion Finance Finco Test Scenarios / Client Management
#  This feature includes these steps:
#1.) E2E Client Management - TC258
#1.) E2E Client Management - TC260

  Background: System Login
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: TC258 - E2E - Customer Management - Merchant Customer Update and Registration
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
    #5430
    Then I get the data from Excel file to element: customer code text area at index 1
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1
    Then I need to Title verify for name title text area match from Excel file at index 1
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    When I get the information: city value text area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait new button element 30 seconds at index 1
    When I click element: new button at index 1
    Then I enter "5555555555" text to telephone number text area at index 1
    When I click element: add button at index 1





