Feature: Orion Finance Finco Test Scenarios / Credit Management - YONETSEL
#  This feature includes these steps:
#1.) E2E Credit Management - TC001
#2.) E2E Credit Management - TC002
# 3.) E2E Credit Management - TC005
# 4.) E2E Credit Management - TC007
# 5.) E2E Credit Management - TC008

  Background: System Login
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3005" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: Yonetsel: TC001 - Financial Item Identification Screen - Save Button Control
    And I wait loan button for 3005 element 30 seconds at index 1
    When I click element: loan button for 3005 at index 1
    Then I see loan page
    And I wait administrative button for 3005 element 30 seconds at index 1
    When I click element: administrative button for 3005 at index 1
    And I wait financial item identification button element 30 seconds at index 1
    When I click element: financial item identification button at index 1
   # Bir alt satırda kullanılan methodu değiştirdim, sistem Türkçe açıldığı zaman çalışıyor. (ex. Ticari İşletme)
    And I wait pen type selection element 30 seconds at index 1
    When I select element: "MİKRO İŞLETME" under pen type selection at index 1
    And I wait window element 30 seconds at index 1
    When I click element: sailors button at index 1
    Then I clear text to item ID text area at index 1
    Then I enter "420X" text to item ID text area at index 1
    Then I clear text to pen name text area at index 1
    Then I enter "7. SATICILAR TEST" text to pen name text area at index 1
    Then I clear text to explanation text area at index 1
    Then I enter "420X-SATICILAR TEST" text to explanation text area at index 1
    And I wait item value selection element 30 seconds at index 1
    When I get the item value: item value selection
    When The item value is changed to "opposite item value" under item value selection
    When I click element: add button at index 1
    When I click element: save button at index 1
    And I wait closed button element 30 seconds at index 1
    When I click element: closed button at index 1

  @Finco
  Scenario: Yonetsel: TC002 - Financial Item Identification Screen - Delete Button Control
    And I wait loan button for 3005 element 30 seconds at index 1
    When I click element: loan button for 3005 at index 1
    Then I see loan page
    And I wait administrative button for 3005 element 30 seconds at index 1
    When I click element: administrative button for 3005 at index 1
    And I wait financial item identification button element 30 seconds at index 1
    When I click element: financial item identification button at index 1
   # Bir alt satırda kullanılan methodu değiştirdim, sistem Türkçe açıldığı zaman çalışıyor. (ex. Ticari İşletme)
    And I wait pen type selection element 30 seconds at index 1
    When I select element: "MİKRO İŞLETME" under pen type selection at index 1
    And I wait window element 30 seconds at index 1
    When I click element: sailors test button at index 1
    And I wait item value selection element 30 seconds at index 1
    When I get the item value: item value selection
    When The item value is changed to "opposite item value" under item value selection
    When I click element: delete button at index 1
    When I click element: save button at index 1

    And I wait closed button element 30 seconds at index 1
    When I click element: closed button at index 1

  @Finco
  Scenario: Yonetsel: TC005 - Rejection identify, update and cancel button - Add
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3009" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait administrative button for 3009 element 30 seconds at index 1
    When I click element: administrative button for 3009 at index 1
    And I wait reasons for rejection identify update and cancel button element 30 seconds at index 1
    When I click element: reasons for rejection identify update and cancel button at index 1
    And I wait reasons for rejection text area element 30 seconds at index 1
    Then I enter "TEST_RET" text to reasons for rejection text area at index 1
    Then I enter "TEST_RET" text to masked cause text area at index 1
    When I click element: rejection add button at index 1
#   Değişken anahtarı bulunamadı gibi bir pop-up çıkıyor?

  @Finco
  Scenario: Yonetsel: TC007 -Administrative Menu - Parameter Management Control 1
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3009" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait administrative button for 3009 element 30 seconds at index 1
    When I click element: administrative button for 3009 at index 1

    And I wait parameter management button element 60 seconds at index 1
    When I click element: parameter management button at index 1
    Then I clear text to kkdf area at index 1
    Then I enter "10" text to kkdf area at index 1
    Then I clear text to bsmv area at index 1
    Then I enter "6" text to bsmv area at index 1
    And I wait save button for parameter management element 30 seconds at index 1
    When I click element: save button for parameter management at index 1
    #Başvuru içerisine güncel oranların yansıdığı görülür kısmı eksik. Önce kredi başvuru oluşturmamız lazım

  @Finco
  Scenario: Yonetsel: TC008 -Administrative Menu - Parameter Management Control 2
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3009" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait administrative button for 3009 element 30 seconds at index 1
    When I click element: administrative button for 3009 at index 1

    And I wait parameter management button element 60 seconds at index 1
    When I click element: parameter management button at index 1
    Then I clear text to invoice validity days area at index 1
    Then I enter "25" text to invoice validity days area at index 1
    Then I clear text to application validity period area at index 1
    Then I enter "20" text to application validity period area at index 1
    Then I clear text to assignment validity period area at index 1
    Then I enter "26" text to assignment validity period area at index 1
    And I wait save button for parameter management element 30 seconds at index 1
    When I click element: save button for parameter management at index 1
    #başvuruların/ yada / iade edilmiş iade tarihinden itibaren başvuruların; bu tarihi aşması durumunda sistem iptali olduğu başvuru gözlem ekranından izlenir

