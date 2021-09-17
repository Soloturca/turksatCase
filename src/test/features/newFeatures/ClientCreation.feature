Feature: Orion Finance Finco Test Scenarios / Client Creation
#  This feature includes these steps:
#1.) E2E Client Management - TC256 - E2E -  Müşteri Yönetimi -  Gerçek Yeni müşteri oluşturma
#2.) E2E Client Management - TC257  - E2E -  Müşteri Yönetimi -  Tacir Yeni Müşteri Oluşturma
#3.) E2E Client Management - TC259 - E2E -  Müşteri Yönetimi -  Tüzel (Kurumsal) Müşteri Oluşturma
# 4.) E2E Client Management - TC - E2E -  Müşteri Yönetimi -  Empty Buttons Test Case

  Background: System Login

    Given Open the https://www.simlict.com/ URL
    Then I see simlict page
    And I wait generate tckn button element 30 seconds at index 1
    When I click element: generate tckn button at index 1
    Then I get the information: generated tckn area at index 1
    And I wait go to tax no button element 30 seconds at index 2
    When I click element: go to tax no button at index 2
    And I wait generate tax no button element 30 seconds at index 1
    When I click element: generate tax no button at index 1
    Then I get the information: generated tax area at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "30060" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

#  @Finco
#  Scenario: TC256 - E2E - Customer Management - Real New customer creation - Gercek Musteri
#    And I wait gateway button element 30 seconds at index 1
#    When I click element: gateway button at index 1
#    Then I see gateway page
#    And I wait test data actions element 30 seconds at index 1
#    When I click element: test data actions at index 1
#    And I wait test data insert element 30 seconds at index 1
#    When I click element: test data insert at index 1
#
#    And I wait test data template name element 30 seconds at index 1
#    #***************************KPS**********************************
#    Then I select element: "KPS" under test data template name at index 1
#    And I wait test data version name element 30 seconds at index 1
#    Then I select element: "1.0.0" under test data version name at index 1
#    And I wait load template button element 30 seconds at index 1
#    When I click element: load template button at index 1
##TCKN
#    And I wait tckn template area element 30 seconds at index 1
#    When I click element: tckn template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I enter my tckn text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#
#    #Name&Surname - KPS
#    And I wait name template area element 30 seconds at index 1
#    When I click element: name template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I enter "AutomationTest" text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#
##Burada top page yapmamız lazım yoksa test patlıyor.
#    Then I go to top of the site
#    And I wait save data button element 30 seconds at index 1
#    When I click element: save data button at index 1
#
#    And I wait warning popup for template element 30 seconds at index 1
#    And I wait yes button element 30 seconds at index 1
#    When I click element: yes button at index 1
#    And I wait close button for template popup element 30 seconds at index 1
#    When I click element: close button for template popup at index 1
#    And I wait clear data button element 30 seconds at index 1
#    When I click element: clear data button at index 1
#
#    And I wait test data template name element 30 seconds at index 1
#      #***************************GIB**********************************
#    Then I select element: "GIB" under test data template name at index 1
#    And I wait test data version name element 30 seconds at index 1
#    Then I select element: "1.0.0" under test data version name at index 1
#    And I wait load template button element 30 seconds at index 1
#    When I click element: load template button at index 1
#
#    #TCKN
#    And I wait tckn template area element 30 seconds at index 1
#    When I click element: tckn template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I enter my tckn text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#
#    #Vergi No
#    And I wait tax no template area element 30 seconds at index 1
#    When I click element: tax no template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I enter my tax text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#
#    #Unvan
#    And I wait title template area element 30 seconds at index 1
#    When I click element: title template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I enter "Gercek Kisi" text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#
#     #Sirket Turu
#    And I wait company type template area element 30 seconds at index 1
#    When I click element: company type template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I clear text to general area at index 1
#    Then I enter "01" text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#
#    #Faaliyet Kodu
#    And I wait action code template area element 30 seconds at index 1
#    When I click element: action code template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I clear text to general area at index 1
#    Then I enter "009000" text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
##Burada top page yapmamız lazım yoksa test patlıyor.
#    Then I go to top of the site
#    And I wait save data button element 30 seconds at index 1
#    When I click element: save data button at index 1
#
#    And I wait warning popup for template element 30 seconds at index 1
#    And I wait yes button element 30 seconds at index 1
#    When I click element: yes button at index 1
#    And I wait close button for template popup element 30 seconds at index 1
#    When I click element: close button for template popup at index 1
#
#    And I wait clear data button element 30 seconds at index 1
#    When I click element: clear data button at index 1
#
#    And I wait test data template name element 30 seconds at index 1
#      #***************************APS**********************************
#    Then I select element: "APS" under test data template name at index 1
#    And I wait test data version name element 30 seconds at index 1
#    Then I select element: "1.0.0" under test data version name at index 1
#    And I wait load template button element 30 seconds at index 1
#    When I click element: load template button at index 1
#    #TCKN
#    And I wait tckn template area element 30 seconds at index 1
#    When I click element: tckn template area at index 1
#    And I wait general area element 30 seconds at index 1
#    Then I enter my tckn text to general area at index 1
#    And I wait save button for test data input element 30 seconds at index 1
#    When I click element: save button for test data input at index 1
#    #Burada top page yapmamız lazım yoksa test patlıyor.
#    Then I go to top of the site
#    And I wait save data button element 30 seconds at index 1
#    When I click element: save data button at index 1
#
#    And I wait warning popup for template element 30 seconds at index 1
#    And I wait yes button element 30 seconds at index 1
#    When I click element: yes button at index 1
#    And I wait close button for template popup element 30 seconds at index 1
#    When I click element: close button for template popup at index 1
#
#    And I wait customer transactions for 30060 element 30 seconds at index 1
#    When I click element: customer transactions for 30060 at index 1
#    Then I see customerTransactions page
#    And I wait customer management button element 30 seconds at index 1
#    When I click element: customer management button at index 1
#    Then I enter my tckn text to TCKN text area at index 1
#    When I click element: search button at index 1
#    Then I need to just wait
#    Then I need to new client title verify by name title text area at index 1



  @Finco
  Scenario: E2E Client Management - TC259- Customer Management - Community customer creation  -Tüzel (Kurumsal)
    And I wait gateway button element 30 seconds at index 1
    When I click element: gateway button at index 1
    Then I see gateway page
    And I wait test data actions element 30 seconds at index 1
    When I click element: test data actions at index 1
    And I wait test data insert element 30 seconds at index 1
    When I click element: test data insert at index 1

    And I wait test data template name element 30 seconds at index 1
      #***************************GIB**********************************
    Then I select element: "GIB" under test data template name at index 1
    And I wait test data version name element 30 seconds at index 1
    Then I select element: "1.0.0" under test data version name at index 1
    And I wait load template button element 30 seconds at index 1
    When I click element: load template button at index 1

    #TCKN
    And I wait tckn template area element 30 seconds at index 1
    When I click element: tckn template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter my tckn text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1

    #Vergi No
    And I wait tax no template area element 30 seconds at index 1
    When I click element: tax no template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I enter my tax text to general area at index 1
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
    Then I clear text to general area at index 1
    Then I enter "01" text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1

    #Faaliyet Kodu
    And I wait action code template area element 30 seconds at index 1
    When I click element: action code template area at index 1
    And I wait general area element 30 seconds at index 1
    Then I clear text to general area at index 1
    Then I enter "009000" text to general area at index 1
    And I wait save button for test data input element 30 seconds at index 1
    When I click element: save button for test data input at index 1
#Burada top page yapmamız lazım yoksa test patlıyor.
    Then I go to top of the site
    And I wait save data button element 30 seconds at index 1
    When I click element: save data button at index 1
    And I wait warning popup for template element 30 seconds at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait close button for template popup element 30 seconds at index 1
    When I click element: close button for template popup at index 1

    And I wait mersis data creation element 30 seconds at index 2
    When I click element: mersis data creation at index 2
    Then I enter my tckn text to mersis tckn area at index 1
    And I wait mersis data add button element 30 seconds at index 1
    When I click element: mersis data add button at index 1



