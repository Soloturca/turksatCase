Feature: Orion Finance Finco Test Scenarios / Credit Application Evaluation - BAŞVURU DEĞERLENDİRME

  #Bu feature'a artık gerek kalmadı. Bkz: AllCredit- Kurumsal

  @Finco
  Scenario: TC001 - E2E - Credit Application Evaluation - Corporate Customer Application Evaluation Process - KURUMSAL MÜŞTERİ

    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:""

    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    #Değerlendirme onayına gönderilen Kredi Başvuru işleminin referans numarasıdır
    Then I enter "20210706-00001" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    Then I see loan page
    Then I wait customer information tab area element 30 seconds at index 1
    When I click element: customer information tab continue button at index 1
    Then I wait external agency inquiry tab area element 30 seconds at index 1
    When I click element: external agency inquiry tab continue button at index 1
    Then I wait FINCO observation tab area element 30 seconds at index 1
    When I click element: FINCO observation tab continue button at index 1
    Then I wait financial information tab area element 30 seconds at index 1

    When I click element: calculate button for financial info at index 1
    And I wait close button for financial info element 30 seconds at index 1
    When I click element: close button for financial info at index 1

    Then I wait save button for financial info element 30 seconds at index 1
    When I click element: save button for financial info at index 1
    And I wait close button for financial info element 30 seconds at index 1
    When I click element: close button for financial info at index 1

#  Then I wait calculate button for consolidated element 30 seconds at index 1
#  When I click element: calculate button for consolidated at index 1
#  And I wait close button for financial info element 30 seconds at index 1
#  When I click element: close button for financial info at index 1
#
#  Then I wait save button for consolidated element 30 seconds at index 1
#  When I click element: save button for consolidated at index 1
#  Then I wait close button for financial info element 30 seconds at index 1
#  When I click element: close button for financial info at index 1

    When I select element: "YMM" under signature area 1 at index 1
    When I select element: "YMM" under signature area 2 at index 1
    When I select element: "YMM" under signature area 3 at index 1
    When I select element: "YMM" under signature area 4 at index 1

    When I click element: calculate button for financial info at index 1
    And I wait close button for financial info element 30 seconds at index 1
    Then I wait save button for financial info element 30 seconds at index 1
    When I click element: close button for financial info at index 1

    Then I wait financial information tab continue button element 30 seconds at index 1
    When I click element: financial information tab continue button at index 1
    Then I wait evaluation tab area element 30 seconds at index 1
    When I click element: evaluation tab continue button at index 1

    Then I wait documents tab area element 30 seconds at index 1
    When I click element: documents tab continue button at index 1
    Then I wait opinion and decision tab area element 30 seconds at index 1
    Then I clear text to approved due date text area at index 1
    Then I enter "1" text to approved due date text area at index 1
    Then I clear text to approved amount text area at index 1
    Then I enter "1" text to approved amount text area at index 1

    And I wait create payment plan button element 30 seconds at index 1
    When I click element: create payment plan button at index 1

    And I wait create payment plan section button element 30 seconds at index 1
    When I click element: create payment plan section button at index 1
    And I wait create payment plan button element 30 seconds at index 1
    When I click element: create payment plan button at index 1

    And I wait save button for payment plan element 30 seconds at index 1
    When I click element: save button for payment plan at index 1

    And I wait save button for financial info element 30 seconds at index 1
    When I click element: save button for financial info at index 1
    And I wait close button for financial info element 30 seconds at index 1
    When I click element: close button for financial info at index 1

    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
#************
#20210706-00001 >> Tahsis Müdürü onayına gönderildi. 026 - KREDİ TAHSİS MÜDÜRÜ profili iş listesinde. >>> TEST003
#************
# @Finco
# Scenario: TC002 - E2E - Credit Application Evaluation - E2E Loan Application Evaluation of Real Person Merchant Customer - GERÇEK KİŞİ
#   Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
#   Then I see login page
#   #kredi tahsis uzmanı kullanıcısı
#   Then I enter "3003" text to username text area at index 1
#   Then I enter "" text to password text area at index 1
#   And I wait login button element 30 seconds at index 1
#   When I click element: login button at index 1
#   Then I see home page
#   When I click element: workflow management button at index 1
#   Then I see workflowManagement page
#   And I wait jobs pending on my list button element 30 seconds at index 1
#   When I click element: jobs pending on my list button at index 1
#   #Değerlendirme onayına gönderilen Kredi Başvuru işleminin referans numarasıdır
#   Then I enter "20210706-00001" text to reference number area at index 1
#   And I wait inquire button element 30 seconds at index 1
#   When I click element: inquire button at index 1
#   When I click element: row button at index 1
#   And I wait warning popup element 30 seconds at index 1
#   When I click element: yes button at index 1
#   Then I see loan page
#   Then I wait customer information tab area element 30 seconds at index 1
#   When I click element: customer information tab continue button at index 1
#   Then I wait external agency inquiry tab area element 30 seconds at index 1
#   When I click element: external agency inquiry tab continue button at index 1
#   Then I wait FINCO observation tab area element 30 seconds at index 1
#   When I click element: FINCO observation tab continue button at index 1
#   Then I wait financial information tab area element 30 seconds at index 1
#
#   When I click element: calculate button for financial info at index 1
#   And I wait close button for financial info element 30 seconds at index 1
#   When I click element: close button for financial info at index 1
#
#   Then I wait save button for financial info element 30 seconds at index 1
#   When I click element: save button for financial info at index 1
#   And I wait close button for financial info element 30 seconds at index 1
#   When I click element: close button for financial info at index 1
#
#  Then I wait calculate button for consolidated element 30 seconds at index 1
#  When I click element: calculate button for consolidated at index 1
#  And I wait close button for financial info element 30 seconds at index 1
#  When I click element: close button for financial info at index 1
#
#  Then I wait save button for consolidated element 30 seconds at index 1
#  When I click element: save button for consolidated at index 1
#  Then I wait close button for financial info element 30 seconds at index 1
#  When I click element: close button for financial info at index 1
#
#   When I select element: "YMM" under signature area 1 at index 1
#   When I select element: "YMM" under signature area 2 at index 1
#   When I select element: "YMM" under signature area 3 at index 1
#   When I select element: "YMM" under signature area 4 at index 1
#
#   When I click element: calculate button for financial info at index 1
#   And I wait close button for financial info element 30 seconds at index 1
#   Then I wait save button for financial info element 30 seconds at index 1
#   When I click element: close button for financial info at index 1
#
#   Then I wait financial information tab continue button element 30 seconds at index 1
#   When I click element: financial information tab continue button at index 1
#   Then I wait evaluation tab area element 30 seconds at index 1
#   When I click element: evaluation tab continue button at index 1
#
#   Then I wait documents tab area element 30 seconds at index 1
#   When I click element: documents tab continue button at index 1
#   Then I wait opinion and decision tab area element 30 seconds at index 1
#   Then I clear text to approved due date text area at index 1
#   Then I enter "1" text to approved due date text area at index 1
#   Then I clear text to approved amount text area at index 1
#   Then I enter "1" text to approved amount text area at index 1
#
#   And I wait create payment plan button element 30 seconds at index 1
#   When I click element: create payment plan button at index 1
#
#   And I wait create payment plan section button element 30 seconds at index 1
#   When I click element: create payment plan section button at index 1
#   And I wait create payment plan button element 30 seconds at index 1
#   When I click element: create payment plan button at index 1
#
#   And I wait save button for payment plan element 30 seconds at index 1
#   When I click element: save button for payment plan at index 1
#
#   And I wait save button for financial info element 30 seconds at index 1
#   When I click element: save button for financial info at index 1
#   And I wait close button for financial info element 30 seconds at index 1
#   When I click element: close button for financial info at index 1
#
#   And I wait approve button element 30 seconds at index 1
#   When I click element: approve button at index 1
#   Then I enter "TEST" text to transaction confirmation note text area at index 1
#   And I wait send approve button element 30 seconds at index 1
#   When I click element: send approve button at index 1
#   And I wait close button element 30 seconds at index 1
#   When I click element: close button at index 1
#
#

  @Finco
  Scenario: TC003 - E2E - Credit Application Evaluation - Application Evaluation Approval Flow Process of Loan amounting to TL 450,000 and below E2E
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
#Tahsis Müdürü Kullanıcısı
    Then I enter "3003" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
#Değerlendirme onayına gönderilen Kredi Başvuru işleminin referans numarasıdır : 450.000 TL ve altındaki tutarlı Kredinin Başvuru
    Then I enter my reference: "20210706-00001" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1

    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    Then I enter "TEST" text to transaction description text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1


    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #kredi komitesi
    Then I enter "3005" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
#And I wait workflow management button element 30 seconds
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #Yönetim Kurulu
    Then I enter "3005" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1


  @Finco
  Scenario: TC004 - E2E - Credit Application Evaluation - Application Evaluation Approval Flow Process of 450,000 TL - 1,000,000 TL and below loan E2E
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
#Tahsis Müdürü Kullanıcısı
    Then I enter "3003" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
#Değerlendirme onayına gönderilen Kredi Başvuru işleminin referans numarasıdır : 450.000 TL - 1.000.000 TL arasındaki Kredinin Başvuru
    Then I enter my reference: "20210706-00001" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1

    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1


    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #kredi komitesi
    Then I enter "3005" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
#And I wait workflow management button element 30 seconds
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1



    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #Yönetim Kurulu
    Then I enter "3005" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

  @Finco
  Scenario: TC005 - E2E - Credit Application Evaluation - Application Evaluation Approval flow process of the loan amounting over TL 1,000,000 E2E
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
#Tahsis Müdürü Kullanıcısı
    Then I enter "3003" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
#Değerlendirme onayına gönderilen Kredi Başvuru işleminin referans numarasıdır : 1.000.000 TL üstündeki Kredinin Başvuru
    Then I enter my reference: "20210706-00001" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1

    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1


    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #kredi komitesi
    Then I enter "3005" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
#And I wait workflow management button element 30 seconds
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1



    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #Yönetim Kurulu
    Then I enter "3005" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    Then I enter "TEST" text to transaction confirmation note text area at index 1
    And I wait send approve button element 30 seconds at index 1
    When I click element: send approve button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1