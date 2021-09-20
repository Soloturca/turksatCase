Feature: Orion Finance Finco Test Scenarios / All Credit Test Cases for Tüzel (Kurumsal) Müşteri

  #This feature includes these steps:
  #1.) Kredi Basvuru - TC001
  # 2.) Basvuru Degerlendirme - TC001
  # 3.) Basvuru Degerlendirme - TC003
  # 4.) Basvuru Degerlendirme - TC004
  # 5.) Basvuru Degerlendirme - TC005
  # 6.) Kullandırım - TC009
  # 7.) Kullandırım - TC010
  # 8) Kullandırım - TC011
  # 9.) Kullandırım - TC012
  #10.) Kullandırım - TC013
  #11.) Kullandırım - TC014
  #12.) Kullandırım - TC015
  #13.) Kullandırım - TC016
  #14) Kredi Basvuru - TC008

    #Bir senaryoyu bir akış gibi düşünün. İçerisinde birden fazla test case'i handle ediyor. Bu iş akış sürecini, case'leri ancak böyle handle edebiliriz.

  #************************************* basvuru degerlendirme under 450.000tl cases ***********************
  @Finco
  Scenario: Creation a Credit for Kurumsal Müşteri - Under 450.000 TL - TC001

    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
    Then I have to create a credit by credit amount:"5000" for customer:"5427"

#  @Finco
#  Scenario: Evaluation a Credit for Kurumsal Müşteri - Under 450.000 TL - TC001
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:"1"
#    Then I have to evaluate for the credit for kurumsal
#
#  @Finco
#  Scenario: Approve a Credit for Kurumsal Müşteri - Under 450.000 TL - TC003
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:"1"
#    Then I have to approve for the credit of under 450.000TL
#
#  @Finco
#  Scenario: Usage a Credit for Kurumsal Müşteri - Under 450.000 TL - TC009
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:"1"
#    Then I have to do usage control for the credit
#
#  @Finco
#  Scenario: Cancel a Credit for Kurumsal Müşteri - Under 450.000 TL - TC008
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to cancel the credit
#
#      #************************************* basvuru degerlendirme 4500.000 - 1.000.000 tl cases****************************
#
#  @Finco
#  Scenario: Creation a Credit for Kurumsal Müşteri - Between 450.000 TL - 1.000.000 TL - TC001
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to create a credit by credit amount:"470000" for customer:"5427"
#
#  @Finco
#  Scenario: Evaluate a Credit for Kurumsal Müşteri - Between 450.000 TL - 1.000.000 TL - TC001
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:"1"
#    Then I have to evaluate for the credit for kurumsal
#
#  @Finco
#  Scenario: Approve a Credit for Kurumsal Müşteri - Between 450.000 TL - 1.000.000 TL - TC004
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:"1"
#    Then I have to approve for the credit of between 450.000 - 1.000.000 TL
#
#  @Finco
#  Scenario: Usage a Credit for Kurumsal Müşteri - Between 450.000 TL - 1.000.000 TL - TC009
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to do usage control for the credit
#
#  @Finco
#  Scenario: Cancel a Credit for Kurumsal Müşteri - Between 450.000 TL - 1.000.000 TL - TC008
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to cancel the credit
#
#
#     #************************************* basvuru degerlendirme above 1.000.000 tl cases****************************
#
#  @Finco
#  Scenario: Creation a Credit for Kurumsal Müşteri -Above 1.000.000 TL - TC001
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to create a credit by credit amount:"2000000" for customer:"5427"
#
#  @Finco
#  Scenario: Evaluate a Credit for Kurumsal Müşteri -Above 1.000.000 TL - TC001
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:"1"
#    Then I have to evaluate for the credit for kurumsal
#
#  @Finco
#  Scenario: Approve a Credit for Kurumsal Müşteri -Above 1.000.000 TL - TC005
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:"1"
#    Then I have to approve for the credit of above 1.000.000 TL
#
#  @Finco
#  Scenario: Usage a Credit for Kurumsal Müşteri -Above 1.000.000 TL - TC009
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:"1"
#    Then I have to do usage control for the credit
#
#  @Finco
#  Scenario: Cancel a Credit for Kurumsal Müşteri -Above 1.000.000 TL - TC008
#
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to cancel the credit
#
#         #************************************* Kullandırım Cases****************************
#  @Finco
#  Scenario: Usage cases of a New E2E Credit Application for Tuzel Customer
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to create a credit by credit amount:"5000" for customer:"5427"
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3003" and this password:"1"
#    Then I have to evaluate for the credit for kurumsal
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:"1"
#    Then I have to approve for the credit of under 450.000TL
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3005" and this password:"1"
#    Then I have to do usage control for the credit
#      #tc010:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:"1"
#    Then I have to do usage control for the document
#    #tc011:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to do usage control for the document
#    #tc012:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:"1"
#    Then I have to do usage control for the document
#    #tc013:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3007" and this password:"1"
#    Then I have to do usage control for the document
#     #tc014:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:"1"
#    Then I have to do usage control and observation for the document
#    #tc015:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3001" and this password:"1"
#    Then I have to do usage control money transfer
#    #tc016:
#    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "3008" and this password:"1"
#    Then I have to do usage control money transfer approve


