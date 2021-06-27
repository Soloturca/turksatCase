Feature: Orion Finance Finco Test Scenarios / Credit Management

  Background: System Login
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "1001" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

#  @Finco
# Scenario: TC001 - Financial Item Identification Screen - Save Button Control
#   And I wait loan button element 30 seconds
#   When I click element: loan button
#   Then I see loan page
#   And I wait administrative button element 30 seconds
#   When I click element: administrative button
#   And I wait financial item identification button element 30 seconds
#   When I click element: financial item identification button
#   And I wait pen type selection element 30 seconds
#   # Bir alt satırda kullanılan methodu değiştirdim, sistem Türkçe açıldığı zaman çalışıyor. (ex. Mikro İşletme)
#   When I select element: "MİKRO İŞLETME" under pen type selection
#   And I wait window element 30 seconds
#   When I click element: financial liabilities button
#   And I wait item value selection element 30 seconds
#   Then I get the Item Value: item value selection
#   Then I changed the "item value" selection under item value selection


  @Finco
  Scenario: TC007 -Administrative Menu - Parameter Management Control 1
    And I wait loan button element 30 seconds
    When I click element: loan button
    Then I see loan page
    And I wait administrative button element 30 seconds
    When I click element: administrative button

    And I wait parameter management button element 30 seconds
    When I click element: parameter management button
    Then I clear text to kkdf area
    Then I enter "10" text to kkdf area
    Then I clear text to bsmv area
    Then I enter "6" text to bsmv area
    And I wait save button element 30 seconds
    When I click element: save button
    #Başvuru içerisine güncel oranların yansıdığı görülür kısmı eksik. Önce kredi başvuru oluşturmamız lazım

  @Finco
  Scenario: TC008 -Administrative Menu - Parameter Management Control 2
    And I wait loan button element 30 seconds
    When I click element: loan button
    Then I see loan page
    And I wait administrative button element 30 seconds
    When I click element: administrative button

    And I wait parameter management button element 30 seconds
    When I click element: parameter management button
    Then I clear text to invoice validity days area
    Then I enter "25" text to invoice validity days area
    Then I clear text to application validity period area
    Then I enter "20" text to application validity period area
    Then I clear text to assignment validity period area
    Then I enter "26" text to assignment validity period area
    And I wait save button element 30 seconds
    When I click element: save button
    #başvuruların/ yada / iade edilmiş iade tarihinden itibaren başvuruların; bu tarihi aşması durumunda sistem iptali olduğu başvuru gözlem ekranından izlenir

