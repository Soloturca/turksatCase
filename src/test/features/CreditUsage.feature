Feature: Orion Finance Finco Test Scenarios / Credit Usage - KULLANDIRIM

  @Finco
  Scenario: TC001
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC002
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC003
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC004
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC005
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon yöneticisi
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC006
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC007
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Hazine İşlemcisi --> Hazine Uzmanı
    Then I enter "3001" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC008
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Muhasebe Onaycısı --> Muhasebe Yöneticisi
    Then I enter "3008" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC009
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

  @Finco
  Scenario: TC0010
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0011
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0012
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0013
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Yöneticisi
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0014
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0015
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Hazine İşlemcisi
    Then I enter "3001" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0016
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Muhasebe Onaycısı
    Then I enter "3008" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0017
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0018
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0019
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0020
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0021
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Operasyon Yöneticisi
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0022
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0023
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Hazine İşlemci
    Then I enter "3001" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page


  @Finco
  Scenario: TC0024
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    #Muhasebe Onaycısı
    Then I enter "3008" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page
