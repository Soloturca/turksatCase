Feature: Orion Finance Finco Test Scenarios / Client Creation
#  This feature includes these steps:
#1.) E2E Client Management - TC256 - E2E -  Müşteri Yönetimi -  Gerçek Yeni müşteri oluşturma
#2.) E2E Client Management - TC257  - E2E -  Müşteri Yönetimi -  Tacir Yeni Müşteri Oluşturma
#3.) E2E Client Management - TC259 - E2E -  Müşteri Yönetimi -  Tüzel  Müşteri Oluşturma

  Background: System Login
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "30060" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: TC256 - E2E - Customer Management - Real New customer creation - Gercek Musteri
    And I wait gateway button element 30 seconds at index 1
    When I click element: gateway button at index 1
    Then I see gateway page
    And I wait test data actions element 30 seconds at index 1
    When I click element: test data actions at index 1
    And I wait test data insert element 30 seconds at index 1
    When I click element: test data insert at index 1
    And I wait test data template name element 30 seconds at index 1
    Then I select element: "GIB" under test data template name at index 1
    And I wait test data version name element 30 seconds at index 1
    Then I select element: "1.0.0" under test data version name at index 1
    And I wait load template button element 30 seconds at index 1
    When I click element: load template button at index 1

    #TCKN
    And I wait tckn template area element 30 seconds at index 1
    When I click element: tckn template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter random but valid tckn to general area element at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1


    #Vergi No
    And I wait tax no template area element 30 seconds at index 1
    When I click element: tax no template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter "123" text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1

    #Unvan
    And I wait title template area element 30 seconds at index 1
    When I click element: title template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter "Gercek Kisi" text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1

     #Sirket Turu
    And I wait company type template area element 30 seconds at index 1
    When I click element: company type template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter "01" text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1

    #Faaliyet Kodu
    And I wait action code template area element 30 seconds at index 1
    When I click element: action code template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter "009000" text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1

    And I wait save data button element 30 seconds at index 1
    When I click element: save data button at index 1

    And I wait warning popup element 30 seconds at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
