Feature: Orion Finance Finco Test Scenarios / Credit Financing - FIYATLANDIRMA
    #This feature includes these steps:
  #1.) E2E Pricing - TC001
  # 2.) E2E Pricing -TC002
  # 3.) E2E Pricing - TC003

  Background: System Login
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3009" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: Fiyatlandirma: TC001 - E2E Credit Pricing - New pricing control
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait pricing button element 30 seconds at index 1
    When I click element: pricing button at index 1
    And I wait financial identification button element 30 seconds at index 1
    When I click element: financial identification button at index 1
    When I select element: "HAFTADA" under period type selection at index 1
    Then I enter "test" text to pricing name area at index 1
    Then I get the information by copying the value from: start date area at index 1
    Then I copy the information by copying the value to: end date area at index 1
    When I select element: "ESNEK ÖDEME" under payment type selection at index 1
    Then I enter "test" text to explanation area at index 1
    Then I enter "1" text to n period no payment area at index 1
    When I select element: "HAFTA" under n period no payment selection at index 1
    When I select element: "VODAFONE NET SUNU TİPLERİ" under product main group selection at index 1
    When I click element: click somewhere area at index 1
    And I wait product area element 30 seconds at index 1
    When I click element: product area at index 1
    And I wait select all button element 30 seconds at index 1
    When I click element: select all button at index 1
    And I wait sales channel area element 30 seconds at index 1
    When I click element: sales channel area at index 1
    And I wait select all button element 30 seconds at index 1
    When I click element: select all button at index 1
    And I wait customer type area element 30 seconds at index 1
    When I click element: customer type area at index 1
    And I wait select all button element 30 seconds at index 1
    When I click element: select all button at index 1
    And I wait application type area element 30 seconds at index 1
    When I click element: application type area at index 1
    And I wait select all button element 30 seconds at index 1
    When I click element: select all button at index 1
    And I wait kkdf exemption area element 30 seconds at index 1
    When I click element: kkdf exemption area at index 1
    And I wait select all button element 30 seconds at index 1
    When I click element: select all button at index 1
    Then I enter "5" text to maturity range first area at index 1
    Then I enter "6" text to maturity range second area at index 1
    Then I enter "5" text to amount range first area at index 1
    Then I enter "6" text to amount range second area at index 1
    Then I enter "5" text to contract margin area at index 1
    And I wait add price terms button element 30 seconds at index 1
    When I click element: add price terms button at index 1
    And I wait pricing save button element 30 seconds at index 1
    When I click element: pricing save button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait reference number text area element 30 seconds at index 1
    Then I get the information: reference number text area at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    Then I see home page

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "3005" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page


    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1

    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1

    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
#burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    Then I get pricing information of: pricing no area at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

  @Finco
  Scenario: Fiyatlandirma: TC002 - E2E Credit Pricing - Current Pricing check

    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait pricing button element 30 seconds at index 1
    When I click element: pricing button at index 1
    And I wait financial identification button element 30 seconds at index 1
    When I click element: financial identification button at index 1
    And I wait existing pricing button element 30 seconds at index 1
    When I click element: existing pricing button at index 1
    And I wait magnifying glass button element 30 seconds at index 1
    When I click element: magnifying glass button at index 1

    And I wait pricing code area element 30 seconds at index 2
    Then I enter my pricing no: "pricing code" text to pricing code area at index 2

    And I wait inquire button for financial observation element 30 seconds at index 1
    When I click element: inquire button for financial observation at index 1
    And I need to just wait
    When I click element: row button at index 2
    And I wait maturity range first area element 30 seconds at index 1
    Then I clear text to maturity range first area at index 1
    Then I enter "5" text to maturity range first area at index 1
    Then I clear text to maturity range second area at index 1
    Then I enter "6" text to maturity range second area at index 1
    Then I clear text to amount range first area at index 1
    Then I enter "5" text to amount range first area at index 1
    Then I clear text to amount range second area at index 1
    Then I enter "6" text to amount range second area at index 1
    Then I clear text to contract margin area at index 1
    Then I enter "5" text to contract margin area at index 1
    And I wait update button element 30 seconds at index 1
    When I click element: update button at index 1

    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait reference number text area element 30 seconds at index 1
    Then I get the information: reference number text area at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    Then I see home page

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "3005" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page


    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1

    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
 # burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait

  #And I wait pricing number area element 30 seconds
  #Then I get the information: pricing number area

    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1


  @Finco
  Scenario: Fiyatlandirma: TC003 - E2E Credit Pricing - pricing monitoring control

    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait pricing button element 30 seconds at index 1
    When I click element: pricing button at index 1
    And I wait financial observation button element 30 seconds at index 1
    When I click element: financial observation button at index 1
    And I wait pricing code area element 30 seconds at index 1
    Then I enter my pricing no: "pricing code" text to pricing code area at index 1
    And I wait search and list pricings button element 30 seconds at index 1
    When I click element: search and list pricings button at index 1
    When I click element: row button at index 1
