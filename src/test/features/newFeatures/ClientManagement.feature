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

    And I wait address new button element 30 seconds at index 1
    When I click element: address new button at index 1

    And I wait address type selection element 30 seconds at index 1
    When I select element: "İŞ" under address type selection at index 1
    When I select element: "TÜRKİYE" under country selection at index 1
    When I select element: "İSTANBUL" under city selection at index 1
    When I select element: "SANCAKTEPE" under town selection at index 1
    When I select element: "OSMANGAZİ MAHALLESİ" under district selection at index 1
    When I select element: "PARLAK (SOKAK)" under CSBM selection at index 1
    When I select element: "20 - Mesken - Bina Ana Giriş" under building selection at index 1
    When I select element: "İç Kapı No : 1 - Kullanım Amacı : Mesken - Tip : Özel - Durum : Bilinmeyen" under department selection at index 1

    And I wait priority address button element 30 seconds at index 1
    When I click element: priority address button at index 2
    And I wait warning yes button element 30 seconds at index 1
    When I click element: warning yes button at index 1

    And I wait address add button element 30 seconds at index 1
    When I click element: address add button at index 1
    Then I need to checkbox verify for priority address checkbox at index 4


    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter "1211111111" text to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    When I select element: "MÜŞTERİNİN CEP TELEFONU YANINDA VEYA AÇIK DEĞİL" under reason for not verification selection at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    Then I need to checkbox verify for priority telephone checkbox at index 5

    And I wait email information area element 30 seconds at index 1
    When I click element: email information area at index 1
    And I wait email new button element 30 seconds at index 1
    When I click element: email new button at index 1
    Then I enter "exxample@example.com" text to email text area at index 1
    When I click element: priority email button at index 1
    When I click element: email add button at index 1
    Then I need to checkbox verify for priority email checkbox at index 7
    And I wait email verification close button element 30 seconds at index 1
    When I click element: email verification close button at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait permission marketing area element 30 seconds at index 1
    When I click element: permission marketing area at index 1
    And I wait permission marketing no permission button element 30 seconds at index 3
    When I click element: permission marketing no permission button at index 3

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to number of employees text area at index 1
    Then I enter "20" text to number of employees text area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "100000" text to declaration endorsement text area at index 1

    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

