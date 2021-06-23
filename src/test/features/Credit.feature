Feature: Orion Finance Finco Test Scenarios / Credit

  Background: System Login
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "1001" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

  @Finco
  Scenario: TC001 - Financial Item Identification Screen - Save Button Control
    And I wait loan button element 30 seconds
    When I click element: loan button
    Then I see loan page
    And I wait administrative button element 30 seconds
    When I click element: administrative button
    And I wait financial item identification button element 30 seconds
    When I click element: financial item identification button
    And I wait pen type selection element 30 seconds
    # Bir alt satırda kullanılan methodu değiştirdim, sistem Türkçe açıldığı zaman çalışıyor. (ex. Mikro İşletme)
    When I select element: "MİKRO İŞLETME" under pen type selection
    And I wait window element 30 seconds
    When I click element: financial liabilities button
    And I wait item value selection element 30 seconds
    Then I get the Item Value: item value selection
    Then I changed the "item value" selection under item value selection









