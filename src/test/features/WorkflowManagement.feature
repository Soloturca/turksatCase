Feature: Orion Finance Finco Test Scenarios

  Background: System Login & Creating Job for unique reference number
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    And I enter "admin" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page
    And I wait customer transactions button element 30 seconds
    When I click element: customer transactions button
    Then I see customerTransactions page
    And I wait customer group management button element 30 seconds
    When I click element: customer group management button
    And I wait add new main group button element 30 seconds
    When I click element: add new main group button
    And I enter "test" text to main group name text area
    And I enter "test" text to subgroup name text area
    And I wait save button element 30 seconds
    When I click element: save button
    And I wait warning popup element 30 seconds
    When I click element: yes button
    And I wait reference number area element 30 seconds
    Then I get the information: reference number area
    And I wait close button element 30 seconds
    When I click element: close button
    Then I see home page


  @Payment
  Scenario: TC003 - Pending Jobs - [PRECONDITION FOR TC0004 - TC0005 - TC0006]
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    And I wait pending jobs button element 30 seconds
    When I click element: pending jobs button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait row button element 30 seconds
    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

  @Payment
  Scenario: TC004 - Jobs Pending on My List - E2E Approving
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    And I wait pending jobs button element 30 seconds
    When I click element: pending jobs button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait row button element 30 seconds
    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

    #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait  row button for jobs pending on my list element 30 seconds
    When I click element: row button for jobs pending on my list
    And I wait warning popup element 30 seconds
    When I click element: yes button

    And I wait approve button element 30 seconds
    When I click element: approve button
    And I wait yes button element 30 seconds
    When I click element: yes button


  @Payment
  Scenario: TC005 - E2E Assign to Pool
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    And I wait pending jobs button element 30 seconds
    When I click element: pending jobs button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait row button element 30 seconds
    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

    #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait  row button for jobs pending on my list element 30 seconds
    When I click element: row button for jobs pending on my list
    And I wait warning popup element 30 seconds
    When I click element: yes button

    And I wait assign to pool button element 30 seconds
    When I click element: assign to pool button
    And I wait yes button element 30 seconds
    When I click element: yes button



  @Payment
  Scenario: TC006 - E2E Cancel
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    And I wait pending jobs button element 30 seconds
    When I click element: pending jobs button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait row button element 30 seconds
    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

    #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    And I wait  row button for jobs pending on my list element 30 seconds
    When I click element: row button for jobs pending on my list
    And I wait warning popup element 30 seconds
    When I click element: yes button

    And I wait cancel button element 30 seconds
    When I click element: cancel button
    And I wait yes button element 30 seconds
    When I click element: yes button

