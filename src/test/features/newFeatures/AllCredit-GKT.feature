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

 #  @Finco
#  Scenario: Creation a Credit for GKT Müşteri - Under 450.000 TL - TC002
#   #Kredi Basvuru - TC002
#   Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
#   Then I have to create a credit by credit amount:"5000" for customer:"5430"

  @Finco
  Scenario: Evaluation a Credit for GKT Müşteri - Under 450.000 TL - TC002
    #Basvuru Degerlendirme - TC002
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:""
    Then I have to evaluate for the credit for GKT

#  @Finco
#  Scenario: Approve a Credit for GKT Müşteri - Under 450.000 TL - TC003
#  #Basvuru Degerlendirme - TC003
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:""
#    Then I have to approve for the credit of under 450.000TL
#
#
##Bu adımdan sonra GKT müşteri için Kullandırım modülündeki GKT müşterileri için olan testler gelecek.
#
#  @Finco
#  Scenario: Usage Control for Credit - TC001
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:""
#    Then I have to do usage control for the credit
#
#  @Finco
#  Scenario: Usage Control for Credit - TC002
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:""
#    Then I have to do usage control for the document
#
#  @Finco
#  Scenario: Usage Control for Credit - TC003
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
#    Then I have to do usage control for the document
#
#  @Finco
#  Scenario: Usage Control for Credit - TC004
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:""
#    Then I have to do usage control for the document
#
#  @Finco
#  Scenario: Usage Control for Credit - TC005
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:""
#    Then I have to do usage control for the document
#
#  @Finco
#  Scenario: Usage Control for Credit - TC006
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
#    Then I have to do usage control and observation for the document
#
#  @Finco
#  Scenario: Usage Control for Credit - TC007
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3001" and this password:""
#    Then I have to do usage control money transfer
#
#  @Finco
#  Scenario: Usage Control for Credit - TC008
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3008" and this password:""
#    Then I have to do usage control money transfer approve