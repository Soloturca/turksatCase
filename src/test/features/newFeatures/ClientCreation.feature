Feature: Orion Finance Finco Test Scenarios / Client Creation
#  This feature includes these steps:
#1.) E2E Client Management - TC256 - E2E -  Müşteri Yönetimi -  Gerçek Yeni müşteri oluşturma
#2.) E2E Client Management - TC257  - E2E -  Müşteri Yönetimi -  Tacir Yeni Müşteri Oluşturma
#3.) E2E Client Management - TC259 - E2E -  Müşteri Yönetimi -  Tüzel  Müşteri Oluşturma

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
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
