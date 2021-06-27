Feature: Orion Finance Finco Test Scenarios / Credit Financing

  #SORUNLAR
  #1.) date'teki getText sorunu. Tarihin dinamik olması gerekli
  #2.) Test 2 deki iframe'e geçilmesi gerekli. Çünkü locator'lar aynı çakışıyorlar.

  
  Background: System Login
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "1001" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

  @Finco
  Scenario: TC001 - E2E Credit Pricing - New Pricing control
    And I wait loan button element 30 seconds
    When I click element: loan button
    Then I see loan page
    And I wait pricing button element 30 seconds
    When I click element: pricing button
    And I wait financial identification button element 30 seconds
    When I click element: financial identification button
    When I select element: "HAFTADA" under period type selection
    Then I enter "test" text to pricing name area
    Then I get the information date from: start date area
    Then I enter date my "date" text to end date area
    #Then I enter "25/06/2021" text to end date area
    When I select element: "ESNEK ÖDEME" under payment type selection
    Then I enter "test" text to explanation area
    Then I enter "1" text to n period no payment area
    When I select element: "HAFTA" under n period no payment selection
    When I select element: "VODAFONE NET SUNU TİPLERİ" under product main group selection
    When I click element: click somewhere area
    And I wait product area element 30 seconds
    When I click element: product area
    And I wait select all button element 30 seconds
    When I click element: select all button
    And I wait sales channel area element 30 seconds
    When I click element: sales channel area
    And I wait select all button element 30 seconds
    When I click element: select all button
    And I wait customer type area element 30 seconds
    When I click element: customer type area
    And I wait select all button element 30 seconds
    When I click element: select all button
    And I wait application type area element 30 seconds
    When I click element: application type area
    And I wait select all button element 30 seconds
    When I click element: select all button
    And I wait kkdf exemption area element 30 seconds
    When I click element: kkdf exemption area
    And I wait select all button element 30 seconds
    When I click element: select all button
    Then I enter "5" text to maturity range first area
    Then I enter "6" text to maturity range second area
    Then I enter "5" text to amount range first area
    Then I enter "6" text to amount range second area
    Then I enter "5" text to contract margin area
    And I wait add price terms button element 30 seconds
    When I click element: add price terms button
    And I wait pricing save button element 30 seconds
    When I click element: pricing save button
    And I wait warning popup element 30 seconds
    When I click element: yes button
    And I wait reference number area element 30 seconds
    Then I get the information: reference number area
    And I wait close button element 30 seconds
    When I click element: close button
    Then I see home page

    And I wait close system button element 30 seconds
    When I click element: close system button
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page

    Then I enter "3005" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page


    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button

    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button
    And I wait approve button element 30 seconds
    When I click element: approve button
    And I wait yes button element 30 seconds
    When I click element: yes button
#burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait

  #And I wait pricing number area element 30 seconds
  #Then I get the information: pricing number area

    And I wait close button element 30 seconds
    When I click element: close button

# @Finco
# Scenario: TC002 - E2E Credit Pricing - Current Pricing check
#
#   And I wait loan button element 30 seconds
#   When I click element: loan button
#   Then I see loan page
#   And I wait pricing button element 30 seconds
#   When I click element: pricing button
#   And I wait financial identification button element 30 seconds
#   When I click element: financial identification button
#   And I wait existing pricing button element 30 seconds
#   When I click element: existing pricing button
#   And I wait magnifying glass button element 30 seconds
#   When I click element: magnifying glass button
#  #pricing number'ın dinamik olması gerekli, referens no gibi.
#   #burada açılan popup ile arkada kalan kısımların elementleri aynı olduğundan sistemin kafası karışmakta.
#   And I need to switch the frame
#   And I wait pricing code area element 30 seconds
#   Then I enter "137" text to pricing code area
#   And I wait inquire button for financial observation element 30 seconds
#   When I click element: inquire button for financial observation
#   And I need to just wait
#   When I click element: row button
#   And I wait maturity range first area element 30 seconds
#   Then I clear text to maturity range first area
#   Then I enter "5" text to maturity range first area
#   Then I clear text to maturity range second area
#   Then I enter "6" text to maturity range second area
#   Then I clear text to amount range first area
#   Then I enter "5" text to amount range first area
#   Then I clear text to amount range second area
#   Then I enter "6" text to amount range second area
#   Then I clear text to contract margin area
#   Then I enter "5" text to contract margin area
#   And I wait update button element 30 seconds
#   When I click element: update button
#
#   And I wait warning popup element 30 seconds
#   When I click element: yes button
#   And I wait reference number area element 30 seconds
#   Then I get the information: reference number area
#   And I wait close button element 30 seconds
#   When I click element: close button
#   Then I see home page
#
#   And I wait close system button element 30 seconds
#   When I click element: close system button
#   Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
#   Then I see login page
#
#   Then I enter "3005" text to username text area
#   Then I enter "" text to password text area
#   And I wait login button element 30 seconds
#   When I click element: login button
#   Then I see home page
#
#And I wait workflow management button element 30 seconds
#   When I click element: workflow management button
#   Then I see workflowManagement page
#
#
#   And I wait jobs pending on my list button element 30 seconds
#   When I click element: jobs pending on my list button
#   Then I enter my "reference number" text to reference number area
#   And I wait inquire button element 30 seconds
#   When I click element: inquire button
#
#   When I click element: row button
#   And I wait warning popup element 30 seconds
#   When I click element: yes button
#   And I wait approve button element 30 seconds
#   When I click element: approve button
#   And I wait yes button element 30 seconds
#   When I click element: yes button
#burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
#   And I need to just wait
#
#  #And I wait pricing number area element 30 seconds
#  #Then I get the information: pricing number area
#
#   And I wait close button element 30 seconds
#   When I click element: close button


# @Finco
# Scenario: TC003 - E2E Credit Pricing - pricing monitoring control
#
#   And I wait loan button element 30 seconds
#   When I click element: loan button
#   Then I see loan page
#   And I wait pricing button element 30 seconds
#   When I click element: pricing button
#   And I wait financial observation button element 30 seconds
#   When I click element: financial observation button
#     #pricing number'ın dinamik olması gerekli, referens no gibi.
#   Then I enter "137" text to pricing code area
#   And I wait search and list pricings button element 30 seconds
#   When I click element: search and list pricings button
#   When I click element: row button
#   And I wait pricing details accordion area element 30 seconds