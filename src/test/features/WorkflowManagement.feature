Feature: Orion Finance Finco Test Scenarios
#  Background:
#    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
#    Then I see login page
#    And I enter "admin" text to username text area
#    Then I enter "" text to password text area
#    And I wait login button element 30 seconds at index 1
#    When I click element: login button index: 1
#    Then I see home page

  @Payment
  Scenario: Creating a job for getting a reference number
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    And I enter "admin" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds at index 1
    When I click element: login button index: 1
    Then I see home page
    And I wait customer transactions button element 30 seconds at index 1
    When I click element: customer transactions button index: 1
    And I wait customer group management button element 30 seconds at index 1
    Then I see customerTransactions page
    When I click element: customer group management button index: 1
    And I wait add new main group button element 30 seconds at index 1
    When I click element: add new main group button index: 1
    And I enter "test_data" text to main group name text area
    And I enter "test_data" text to subgroup name text area
    When I click element: save button index: 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button index: 1
    Then I get the information: reference number area index: 1
    When I click element: close button index: 1
    Then I see home page
    #Burdan devam edildi.
    When I click element: workflow management index: 1    
    And I wait jobs I started element 30 seconds at index 1
    # Bu aşamada object değişken, nasıl göndereceğiz?  Step Def'e git.
    And I enter "object" text to 1

    
    
    

