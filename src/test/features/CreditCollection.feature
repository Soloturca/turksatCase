Feature: Orion Finance Finco Test Scenarios / Credit Collection Evaluation - TAHSİLAT

  @Finco
  Scenario: TC001 -E2E Collection Transactions controls - PAID ON DATE
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait test button element 30 seconds at index 1
    When I click element: test button at index 1
    And I wait credit disbursement button element 30 seconds at index 1
    When I click element: credit disbursement button at index 1

    Then I enter "" text to credit no text area at index 1
    Then I enter "" text to credit start date text area at index 1
    Then I enter "" text to credit end date text area at index 1

    And I wait start test button element 30 seconds at index 1
    When I click element: start test button at index 1

    And I wait credit collection button element 30 seconds at index 1
    When I click element: credit collection button at index 1
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1
    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1
    And I wait finalize installment payment send button element 30 seconds at index 1
    When I click element: finalize installment payment send button at index 1

    And I wait credit usage button element 30 seconds at index 1
    When I click element: credit usage button at index 1
    And I wait loan disbursement monitoring element 30 seconds at index 1
    When I click element: loan disbursement monitoring at index 1
#ilgili kredi no aratılır:
    Then I enter "" text to credit monitoring credit no text area at index 1
    And I wait credit monitoring inquire button element 30 seconds at index 1
    When I click element: credit monitoring inquire button at index 1


  @Finco
  Scenario: TC002 -E2E Collection Transactions controls - PAID ON DATE
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait test button element 30 seconds at index 1
    When I click element: test button at index 1
    And I wait credit disbursement button element 30 seconds at index 1
    When I click element: credit disbursement button at index 1

    Then I enter "" text to credit no text area at index 1
    Then I enter "" text to credit start date text area at index 1
    Then I enter "" text to credit end date text area at index 1

    And I wait start test button element 30 seconds at index 1
    When I click element: start test button at index 1
    And I wait credit collection test button element 30 seconds at index 1
    When I click element: credit collection test button at index 1

    And I wait loan installments revolving send button element 30 seconds at index 1
    When I click element: loan installments revolving send button at index 1

    And I wait credit disbursement button element 30 seconds at index 1
    When I click element: credit disbursement button at index 1
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1
    And I wait finalize installment payment send button element 30 seconds at index 1
    When I click element: finalize installment payment send button at index 1

    And I wait credit usage button element 30 seconds at index 1
    When I click element: credit usage button at index 1
    And I wait loan disbursement monitoring element 30 seconds at index 1
    When I click element: loan disbursement monitoring at index 1
#ilgili kredi no aratılır:
    Then I enter "" text to credit monitoring credit no text area at index 1
    And I wait credit monitoring inquire button element 30 seconds at index 1
    When I click element: credit monitoring inquire button at index 1