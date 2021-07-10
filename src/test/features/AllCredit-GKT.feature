Feature: Orion Finance Finco Test Scenarios / All Credit Test Cases for GKT Müşteri

  #This feature includes these steps:
  #1.) Kredi Basvuru - TC002
  #2.) Basvuru Degerlendirme - TC002
  #3.) Kullandırım - TC001
  #4.) Kullandırım - TC002
  #5.) Kullandırım - TC003
  # 6.) Kullandırım - TC004
  # 7.) Kullandırım - TC005
  # 8.) Kullandırım - TC006
  # 9.) Kullandırım - TC007
  # 10.) Kullandırım - TC008

  #Bir senaryoyu bir akış gibi düşünün. İçerisinde birden fazla test case'i handle ediyor. Bu iş akış sürecini, case'leri ancak böyle handle edebiliriz.
  @Finco:
  Scenario: Creation - Evaluation - Approve - Cancellation of a New E2E Credit Application for Tuzel Customer - Under 450.000 TL
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
    Then I have to create a credit by credit amount:"5000" for customer:"5430"

    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:""
    Then I have to evaluate for the credit

    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:""
    Then I have to approve for the credit of under 450.000TL

#Bu adımdan sonra GKT müşteri için Kullandırım modülündeki GKT müşterileri için olan testler gelecek.
     #tc001:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:""
    Then I have to do usage control for the credit
      #tc002:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:""
    Then I have to do usage control for the document
    #tc003:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
    Then I have to do usage control for the document
    #tc004:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:""
    Then I have to do usage control for the document
    #tc005:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:""
    Then I have to do usage control for the document
     #tc006:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
    Then I have to do usage control and observation for the document
    #tc007:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3001" and this password:""
    Then I have to do usage control money transfer
    #tc008:
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3008" and this password:""
    Then I have to do usage control money transfer approve