Feature: Orion Finance Finco Test Scenarios / Credit Collection Evaluation - TAHSİLAT

  @Finco
  Scenario: TC001 -E2E Collection Transactions controls - PAID ON DATE
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    #banka, kredi no ödeme tipi ve tutar girilir.
    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection at index 1
    Then I enter "" text to credit monitoring credit no text area at index 1
    When I select element: "Taksit Ödemesi" under payment type selection at index 1
    Then I enter "" text to amount text area at index 1

    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection for finalize installment payment section at index 1
    Then I enter "" text to accomplish payment id area at index 1

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
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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

#kredi no girilir.
    Then I enter "" text to installment amount credit no text area at index 1
    And I wait loan installments revolving send button element 30 seconds at index 1
    When I click element: loan installments revolving send button at index 1

    And I wait credit collection test button element 30 seconds at index 1
    When I click element: credit collection test button at index 1
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection at index 1
    Then I enter "" text to credit monitoring credit no text area at index 1
    When I select element: "Erken Taksit Ödemesi" under payment type selection at index 1
    Then I enter "" text to amount text area at index 1
    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection for finalize installment payment section at index 1
    Then I enter "" text to accomplish payment id area at index 1

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
  Scenario: TC003 -E2E Collection Process controls - PARTIAL PAID
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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

#kredi no girilir.
    Then I enter "" text to installment amount credit no text area at index 1
    And I wait loan installments revolving send button element 30 seconds at index 1
    When I click element: loan installments revolving send button at index 1

    And I wait credit collection test button element 30 seconds at index 1
    When I click element: credit collection test button at index 1
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection at index 1
    Then I enter "" text to credit monitoring credit no text area at index 1
    When I select element: "Erken Taksit Ödemesi" under payment type selection at index 1
    Then I enter "" text to amount text area at index 1
    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection for finalize installment payment section at index 1
    Then I enter "" text to accomplish payment id area at index 1

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
  Scenario: TC004 -E2E Collection Process controls - PAID DELAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    #banka, kredi no ödeme tipi ve tutar girilir.
    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection at index 1
    Then I enter "" text to credit monitoring credit no text area at index 1
    When I select element: "Taksit Ödemesi" under payment type selection at index 1
    Then I enter "" text to amount text area at index 1

    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection for finalize installment payment section at index 1
    Then I enter "" text to accomplish payment id area at index 1

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
  Scenario: TC005 -E2E Collection Process controls - IN DELAY

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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

    And I wait credit button element 30 seconds at index 1
    When I click element: credit button at index 1

    And I wait credit usage button element 30 seconds at index 1
    When I click element: credit usage button at index 1
    And I wait loan disbursement monitoring element 30 seconds at index 1
    When I click element: loan disbursement monitoring at index 1
#ilgili kredi no aratılır:
    Then I enter "" text to credit monitoring credit no text area at index 1
    And I wait credit monitoring inquire button element 30 seconds at index 1
    When I click element: credit monitoring inquire button at index 1

  @Finco
  Scenario: TC006 -E2E Collection Transactions controls - DELAYED PARTIAL PAID

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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

#kredi no girilir.
    Then I enter "" text to installment amount credit no text area at index 1
    And I wait loan installments revolving send button element 30 seconds at index 1
    When I click element: loan installments revolving send button at index 1

    And I wait credit collection test button element 30 seconds at index 1
    When I click element: credit collection test button at index 1
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection at index 1
    Then I enter "" text to credit monitoring credit no text area at index 1
    When I select element: "Kısmi Ödemesi" under payment type selection at index 1
    Then I enter "" text to amount text area at index 1
    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection for finalize installment payment section at index 1
    Then I enter "" text to accomplish payment id area at index 1

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
  Scenario: TC007 -E2E Collection Process controls - EARLY CLOSING

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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

#kredi no girilir.
    Then I enter "" text to installment amount credit no text area at index 1
    And I wait loan installments revolving send button element 30 seconds at index 1
    When I click element: loan installments revolving send button at index 1

    And I wait credit collection test button element 30 seconds at index 1
    When I click element: credit collection test button at index 1
    And I wait collection button element 30 seconds at index 1
    When I click element: collection button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection at index 1
    Then I enter "" text to credit monitoring credit no text area at index 1
    When I select element: "Kredi Kapama" under payment type selection at index 1
    Then I enter "" text to amount text area at index 1
    And I wait installment payment verification send button element 30 seconds at index 1
    When I click element: installment payment verification send button at index 1

    When I select element: "T.C MERKEZ BANKASI A.S." under bank code selection for finalize installment payment section at index 1
    Then I enter "" text to accomplish payment id area at index 1

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
  Scenario: TC008 -E2E Collection Process checks - PAYMENT PENDING

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

    Then I enter "admin" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page

    And I wait credit usage button element 30 seconds at index 1
    When I click element: credit usage button at index 1
    And I wait loan disbursement monitoring element 30 seconds at index 1
    When I click element: loan disbursement monitoring at index 1
 #kredi no alanına aktif/kullandırılmış bir kredi no yazılır:
    Then I enter "" text to credit monitoring credit no text area at index 1
    And I wait credit monitoring inquire button element 30 seconds at index 1
    When I click element: credit monitoring inquire button at index 1
    When I click element: row button at index 1

    And I wait credit detail button element 30 seconds at index 1
    When I click element: credit detail button at index 1
    And I wait payment plan button element 30 seconds at index 1
    When I click element: payment plan button at index 1