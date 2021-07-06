Feature: Orion Finance Finco Test Scenarios / Credit Usage - KULLANDIRIM

  @Finco
  Scenario: TC001 - GKT MÜŞTERİ - SÖZLEŞME GİRİŞ
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
   #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page

    When I click element: pending jobs button at index 1
   #Kredi başvurusu onaylanmış GKT müşteri için kredi no
    Then I enter "" text to reference number area at index 1
    When I click element: query button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1

    Then I see loan page
    Then I wait customer information tab area element 30 seconds at index 1
    When I click element: customer information tab continue button at index 1
    Then I wait external agency inquiry tab area element 30 seconds at index 1
    When I click element: external agency inquiry tab continue button at index 1


  @Finco
  Scenario: TC002 - GKT MÜŞTERİ - DİJİTAL EVRAK ONAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
   #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
   #dijital evrak onay
    Then I enter "" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

  @Finco
  Scenario: TC003 - GKT MÜŞTERİ - FİZİKSEL EVRAK BEKLİYOR
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
   #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
   #fiziksel evrak onay
    Then I enter "" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

  @Finco
  Scenario: TC004 - GKT MÜŞTERİ - FİZİKSEL EVRAK KONTROL
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
   #Operasyon Uzmanı
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
   #fiziksel evrak konrol
    Then I enter "" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

  @Finco
  Scenario: TC005 - GKT MÜŞTERİ - FİZİKSEL EVRAK KONTROL
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
   #Operasyon yöneticisi
    Then I enter "3007" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
   #fiziksel evrak kontrol
    Then I enter "" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

  @Finco
  Scenario: TC006 - GKT MÜŞTERİ - KREDİ BAŞVURU GÖZLEM VE RAPOR
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait credit button element 30 seconds at index 1
    When I click element: credit button at index 1
    Then I see loan page
    And I wait credit application button element 30 seconds at index 1
    When I click element: credit application button at index 1
    And I wait credit application observation and report button element 30 seconds at index 1
    When I click element: credit application observation and report button at index 1

    And I wait credit application observation and report customer no button element 30 seconds at index 1
    Then I enter "5426" text to credit application observation and report customer no button at index 1
    And I wait credit application observation and report search and list button element 30 seconds at index 1
    When I click element: credit application observation and report search and list button at index 1
    Then I read the information: credit application observation and report transaction reference number text area at index 1


  @Finco
  Scenario: TC007 - GKT MÜŞTERİ - PARA TRANSFER
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC008 - GKT MÜŞTERİ - PARA TRANSFER ONAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC009 - TÜZEL MÜŞTERİ -SÖZLEŞME GİRİŞ
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0010 - TÜZEL MÜŞTERİ -DİJİTAL EVRAK ONAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0011 - TÜZEL MÜŞTERİ -FİZİKSEL EVRAK BEKLİYOR
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0012 - TÜZEL MÜŞTERİ -FİZİKSEL EVRAK KONTROL
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0013 - TÜZEL MÜŞTERİ -FİZİKSEL EVRAK KONTROL
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0014 - TÜZEL MÜŞTERİ  -KREDİ BAŞVURU GÖZLEM VE RAPOR
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait credit button element 30 seconds at index 1
    When I click element: credit button at index 1
    Then I see loan page
    And I wait credit application button element 30 seconds at index 1
    When I click element: credit application button at index 1
    And I wait credit application observation and report button element 30 seconds at index 1
    When I click element: credit application observation and report button at index 1

    And I wait credit application observation and report customer no button element 30 seconds at index 1
    Then I enter "5426" text to credit application observation and report customer no button at index 1
    And I wait credit application observation and report search and list button element 30 seconds at index 1
    When I click element: credit application observation and report search and list button at index 1
    Then I read the information: credit application observation and report transaction reference number text area at index 1



  @Finco
  Scenario: TC0015 - TÜZEL MÜŞTERİ -PARA TRANSFER
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0016 - TÜZEL MÜŞTERİ -PARA TRANSFER ONAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0017 - BİREYSEL MÜŞTERİ  -SÖZLEŞME GİRİŞ
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0018  - BİREYSEL MÜŞTERİ -DİJİTAL EVRAK ONAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0019  - BİREYSEL MÜŞTERİ -FİZİKSEL EVRAK BEKLİYOR
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0020 - BİREYSEL MÜŞTERİ -FİZİKSEL EVRAK KONTROL
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0021  - BİREYSEL MÜŞTERİ -FİZİKSEL EVRAK KONTROL
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0022  - BİREYSEL MÜŞTERİ -KREDİ BAŞVURU GÖZLEM VE RAPOR
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    #Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    And I wait credit button element 30 seconds at index 1
    When I click element: credit button at index 1
    Then I see loan page
    And I wait credit application button element 30 seconds at index 1
    When I click element: credit application button at index 1
    And I wait credit application observation and report button element 30 seconds at index 1
    When I click element: credit application observation and report button at index 1

    And I wait credit application observation and report customer no button element 30 seconds at index 1
    Then I enter "5426" text to credit application observation and report customer no button at index 1
    And I wait credit application observation and report search and list button element 30 seconds at index 1
    When I click element: credit application observation and report search and list button at index 1
    Then I read the information: credit application observation and report transaction reference number text area at index 1

  @Finco
  Scenario: TC0023  - BİREYSEL MÜŞTERİ -PARA TRANSFER
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
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
  Scenario: TC0024  - BİREYSEL MÜŞTERİ -PARA TRANSFER ONAY
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
   #Muhasebe Onaycısı
    Then I enter "3008" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    When I click element: workflow management button at index 1
    Then I see workflowManagement page
