Feature: Orion Finance Finco Test Scenarios / All Credit Test Cases

  @Finco:

  Scenario: Basvuru - TC001- Creation of a New E2E Credit Application for Tuzel Customer - Under 450.000 TL
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
    Then I have to create a credit by credit amount:"5000"


  Scenario: Basvuru Degerlendirme - TC001- Creation of a E2E Credit Application for Tuzel (Kurumsal) Customer - Under 450.000 TL


  Scenario: Basvuru Degerlendirme - TC003- Approve of a E2E Credit Application for  Tuzel (Kurumsal) Customer - Under 450.000 TL


  Scenario: Kullandırım - TC009 - E2E Usage control for Tuzel (Kurumsal) Customer - Under 450.000 TL


  Scenario: Basvuru - TC008 - E2E Credit Application Cancellation
    Given I go to "https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/" with this username: "4000" and this password:""
    Then I have to cancel the credit
