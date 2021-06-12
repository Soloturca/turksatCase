Feature: Orion Finance Finco Test Scenarios
  Background:
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    And I enter "admin" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds at index 1
    When I click element: login button index: 1
    Then I see home page

  @Payment
  Scenario: PRECONDITION - Creating a job for getting a reference number
    And I wait customer transactions button element 30 seconds at index 1
    When I click element: customer transactions button index: 1
    Then I see customerTransactions page
    And I wait customer group management button element 30 seconds at index 1
    When I click element: customer group management button index: 1
    And I wait add new main group button element 30 seconds at index 1
    When I click element: add new main group button index: 1
    And I enter "test" text to main group name text area
    And I enter "test" text to subgroup name text area
    When I click element: save button index: 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button index: 1
    Then I get the information: reference number area index: 1
    When I click element: close button index: 1

   #Ece, case'lerin benim için precondition durumu taşıdığından, biraz senin case'ine de girmek zorunda kaldım.
  #Case'e göre diğer alanların da dıoldurulması gerekiyor. Ben sadece yarattığımız referans numarası ile işlem yapıyorum.
  #Eksik kalan kısımları (test 3 için) ve diğer case'lere (1 ve 2 ) sen bakabilir misin?

    #Yaratılan işin referans numarasının diğer referans no alanlarına yazılması adımı: Then I enter my reference number text..... adımı. Metoduna oradan gidilebilir.
  @Payment
  Scenario: TC003
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button index: 1
    Then I see workflowManagement page
    When I click element: pending jobs button index: 1
    Then I enter my "reference number" text to reference number area
    When I click element: inquire button index: 1
    When I click element: row button index: 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button index: 1
    When I click element: approve button index: 1
    When I click element: yes button index: 1


  @Payment
  Scenario: TC004 - E2E Approving
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button index: 1
    Then I see workflowManagement page
    When I click element: jobs pending on my list button index: 1
    Then I enter my "reference number" text to reference number area
    When I click element: inquire button index: 1
    When I click element: row button index: 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button index: 1
    When I click element: approve button index: 1
    When I click element: yes button index: 1


  @Payment
  Scenario: TC005 - E2E Assign to Pool
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button index: 1
    Then I see workflowManagement page
    When I click element: jobs pending on my list button index: 1
    Then I enter my "reference number" text to reference number area
    When I click element: inquire button index: 1
    When I click element: row button index: 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button index: 1
    When I click element: assign to pool button index: 1
    When I click element: no button index: 1


  @Payment
  Scenario: TC006 - E2E Cancel
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button index: 1
    Then I see workflowManagement page
    When I click element: jobs pending on my list button index: 1
    Then I enter my "reference number" text to reference number area
    When I click element: inquire button index: 1
    When I click element: row button index: 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button index: 1
    When I click element: cancel button index: 1
    When I click element: no button index: 1
