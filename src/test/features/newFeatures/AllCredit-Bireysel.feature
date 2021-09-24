Feature: Orion Finance Finco Test Scenarios / All Credit Test Cases for Bireysel Müşteri

  #This feature includes these steps:
  #1.) Kredi Basvuru - TC003 - Bireysel Müşterinin E2E Yeni Bir Kredi Başvuru Oluşturamaması

  @Finco
  Scenario: Kredi Basvuru: Retail Customer's Failure to Create a New E2E Loan Application - TC003
   #Kredi Basvuru - TC003
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
    And I wait loan button for 4000 element 30 seconds at index 1
    When I click element: loan button for 4000 at index 1
    Then I see loan page
    And I wait application button element 30 seconds at index 1
    When I click element: application button at index 1
    And I wait credit application introduction button element 30 seconds at index 1
    When I click element: credit application introduction button at index 1
    Then I enter "5429" text to customer no-new application text area at index 1
    And I wait closeview element 30 seconds at index 1
    When I click element: closeview at index 1
    And I wait row button element 30 seconds at index 27
    When I click element: row button at index 27
    And I wait continue to Reference Information button element 30 seconds at index 1
    When I click element: continue to Reference Information button at index 1
    And I wait customer no-new application text area element 30 seconds at index 1

