Feature: Orion Finance Finco Test Scenarios / Credit Appeal

  Background: System Login
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "1001" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: TC007 -Administrative Menu - Parameter Management Control 1
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait administrative button element 30 seconds at index 1
    When I click element: administrative button at index 1

    And I wait parameter management button element 30 seconds at index 1
    When I click element: parameter management button at index 1
    Then I clear text to kkdf area at index 1
    Then I enter "10" text to kkdf area at index 1
    Then I clear text to bsmv area at index 1
    Then I enter "6" text to bsmv area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    #Başvuru içerisine güncel oranların yansıdığı görülür kısmı eksik. Önce kredi başvuru oluşturmamız lazım

