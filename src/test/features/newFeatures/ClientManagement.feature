Feature: Orion Finance Finco Test Scenarios / Client Management
#  This feature includes these steps:
#1.) E2E Client Management - TC258
#2.) E2E Client Management - TC260
#3.) E2E Client Management - TC097
#4.) E2E Client Management - TC116
# 5.) E2E Client Management - TC119
#6) E2E Client Management - TC121
#7.) E2E Client Management - TC156
#8.) E2E Client Management - TC157
#9.) E2E Client Management - TC158
#10.) E2E Client Management - TC168
#11.) E2E Client Management - TC182
#12.) E2E Client Management - TC183
#13.) E2E Client Management - TC184
#14.) E2E Client Management - TC185
#15.) E2E Client Management - TC159

  Background: System Login
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: TC258 - E2E - Customer Management - Merchant Customer Update and Registration
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
    #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait general information section area element 30 seconds at index 1

    Then I get the text area information: created user area at index 1
    Then I get the text area information: created date area at index 1
    Then I get the text area information: tax id no area at index 1
    Then I get the text area information: tax department code area at index 1
    Then I get the text area information: tax department name area at index 1
    Then I get the text area information: title area at index 1
    Then I get the text area information: GIB start date area at index 1
    Then I get the text area information: GIB finish date area at index 1
    Then I get the text area information: company type area at index 1
    Then I get the text area information: active abandoned status area at index 1
    Then I get the text area information: potential information area at index 1
    Then I get the text area information: sector information area at index 1
    Then I get the text area information: activity name area at index 1

    Then I verify the area company type area by read only at index 1
    Then I verify the area active abandoned status area by read only at index 1
    Then I verify the area potential information area by read only at index 1
    Then I verify the area sector information area by read only at index 1
    Then I verify the area activity name area by read only at index 1

    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    Then I get the information: city value text area at index 1

    And I wait address new button element 30 seconds at index 1
    When I click element: address new button at index 1

    And I wait address type selection element 30 seconds at index 1
    When I select element: "İŞ" under address type selection at index 1
    When I select element: "TÜRKİYE" under country selection at index 1
    When I select element: "İSTANBUL" under city selection at index 1
    When I select element: "PENDİK" under town selection at index 1
    When I select element: "VELİBABA MAHALLESİ" under district selection at index 1
    When I select element: "BEYLERBEYİ (SOKAK)" under CSBM selection at index 1
    When I select element: "4 - Mesken - Bina Ana Giriş" under building selection at index 1
    When I select element: "İç Kapı No : 1 - Kullanım Amacı : Mesken - Tip : Özel - Durum : Bilinmeyen" under department selection at index 1

    And I wait priority address button element 30 seconds at index 1
    When I click element: priority address button at index 2
    And I wait warning yes button element 30 seconds at index 1
    When I click element: warning yes button at index 1

    And I wait address add button element 30 seconds at index 1
    When I click element: address add button at index 1
    Then I need to checkbox verify for priority address checkbox at index 4


    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter a telephone number to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    Then I need to just wait
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    When I select element: "MÜŞTERİNİN CEP TELEFONU YANINDA VEYA AÇIK DEĞİL" under reason for not verification selection at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    Then I need to checkbox verify for priority telephone checkbox at index 5

    And I wait email information area element 30 seconds at index 1
    When I click element: email information area at index 1
    And I wait email new button element 30 seconds at index 1
    When I click element: email new button at index 1
    Then I enter a email to email text area at index 1
    When I click element: priority email button at index 1
    When I click element: email add button at index 1
    Then I need to checkbox verify for priority email checkbox at index 7
    And I wait email verification close button element 30 seconds at index 1
    When I click element: email verification close button at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait permission marketing area element 30 seconds at index 1
    When I click element: permission marketing area at index 1
    And I wait permission marketing no permission button element 30 seconds at index 3
    When I click element: permission marketing no permission button at index 3

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to number of employees text area at index 1
    Then I enter a random number of employees to number of employees text area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter a random declaration endorsement to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

    And I wait documents section area element 30 seconds at index 1
    When I click element: documents section area at index 1

    #Then I have to check is there any document is uploaded on the address area at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1

  #verify adımları gelecek:
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    Then I verify the telephone number to telephone verify area

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1

    Then I verify the number of employees number to number of employees text area at index 1
    Then I verify the declaration endorsement to declaration endorsement text area at index 1


  @Finco
  Scenario: TC260 - E2E - Client Management - Legal Client Creation
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
 #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1

    And I wait general information section area element 30 seconds at index 1

    Then I get the text area information: created user area at index 1
    Then I get the text area information: created date area at index 1
    Then I get the text area information: tax id no area at index 1
    Then I get the text area information: tax department code area at index 1
    Then I get the text area information: tax department name area at index 1
    Then I get the text area information: title area at index 1
    Then I get the text area information: GIB start date area at index 1
    Then I get the text area information: GIB finish date area at index 1

    Then I get the text area information: company type area at index 1
    Then I get the text area information: active abandoned status area at index 1
    Then I get the text area information: potential information area at index 1
    Then I get the text area information: sector information area at index 1
    Then I get the text area information: activity name area at index 1

    Then I verify the area company type area by read only at index 1
    Then I verify the area active abandoned status area by read only at index 1
    Then I verify the area potential information area by read only at index 1
    Then I verify the area sector information area by read only at index 1
    Then I verify the area activity name area by read only at index 1

    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1

    And I wait address new button element 30 seconds at index 1
    When I click element: address new button at index 1

    And I wait address type selection element 30 seconds at index 1
    When I select element: "EV" under address type selection at index 1
    When I select element: "TÜRKİYE" under country selection at index 1
    When I select element: "İSTANBUL" under city selection at index 1
    When I select element: "PENDİK" under town selection at index 1
    When I select element: "VELİBABA MAHALLESİ" under district selection at index 1
    When I select element: "BEYLERBEYİ (SOKAK)" under CSBM selection at index 1
    When I select element: "4 - Mesken - Bina Ana Giriş" under building selection at index 1
    When I select element: "İç Kapı No : 1 - Kullanım Amacı : Mesken - Tip : Özel - Durum : Bilinmeyen" under department selection at index 1

    And I wait priority address button element 30 seconds at index 1
    When I click element: priority address button at index 2
    And I wait warning yes button element 30 seconds at index 1
    When I click element: warning yes button at index 1

    And I wait address add button element 30 seconds at index 1
    When I click element: address add button at index 1
    Then I need to checkbox verify for priority address checkbox at index 4

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to number of employees text area at index 1
    Then I enter a random number of employees to number of employees text area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter a random declaration endorsement to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

    And I wait documents section area element 30 seconds at index 1
    When I click element: documents section area at index 1

    #Then I have to check is there any document is uploaded on the address area at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1

  #verify adımları gelecek:
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    Then I verify the telephone number to telephone verify area

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1

    Then I verify the number of employees number to number of employees text area at index 1
    Then I verify the declaration endorsement to declaration endorsement text area at index 1

  @Finco
Scenario: TC097 -E2E Customer Management - Contact information - Phone Information
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
#5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "TÜRKİYE" under telephone country selection at index 2
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter a telephone number to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    Then I need to just wait
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    When I select element: "MÜŞTERİNİN CEP TELEFONU YANINDA VEYA AÇIK DEĞİL" under reason for not verification selection at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    Then I need to checkbox verify for priority telephone checkbox at index 5

  @Finco
  Scenario: TC116 -E2E Customer Management - Confirmation of failure to continue by entering wrong verification Code
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "TÜRKİYE" under telephone country selection at index 2
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter a telephone number to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    Then I need to just wait
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    Then I enter "5555" text to verification code text area at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    And I wait warning close button element 30 seconds at index 1
    When I click element: warning close button at index 1

  @Finco
  Scenario: TC119 -E2E Customer Management - Unverified phone number after verification
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "TÜRKİYE" under telephone country selection at index 2
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter a telephone number to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    Then I need to just wait
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    When I select element: "MÜŞTERİNİN CEP TELEFONU YANINDA VEYA AÇIK DEĞİL" under reason for not verification selection at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    Then I need to checkbox verify for priority telephone checkbox at index 5

  @Finco
  Scenario: TC121 -E2E Customer Management - Merchant customer contact information with unverified mobile number
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "TÜRKİYE" under telephone country selection at index 2
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter a telephone number to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    Then I need to just wait
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    When I select element: "KREDİ KAYIT BÜROSU (KKB) TARAFINDA DOĞRULANMAMIŞTIR" under reason for not verification selection at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    Then I need to checkbox verify for priority telephone checkbox at index 5

  @Finco
  Scenario: TC156 -E2E Customer Management - Micro Bussiness

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "300000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC157 -E2E : Customer Management - Detailed Information - Legal Customer - Small Bussiness

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "3000000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC158 - TC157 -E2E : Customer Management - Detailed Information - Legal Customer - Commercial Bussiness

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "60000000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC159 -E2E : Customer Management - Detailed Information - Legal Customer - Corparate Company

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "80000000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC168 -E2E Customer Management - Verifying that up-to-date data is displayed

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter a random declaration endorsement to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5430
    Then I get the data from Excel file to element: customer code text area at index 1 for 5430
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to TCKN verify for TCKN text area match from Excel file at index 1 for 5430
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5430
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC182 -E2E : Customer Management - Detailed Information - Merchant Customer - Small Bussiness

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "3000000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC183 -E2E : Customer Management - Detailed Information - Merchant Customer - Micro Bussiness

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "300000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC184 -E2E : Customer Management - Detailed Information - Merchant Customer - Commercial Bussiness

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "60000000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

  @Finco
  Scenario: TC185 -E2E : Customer Management - Detailed Information - Merchant Customer - Corparate Company

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
   #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    When I clear text to declaration endorsement text area at index 1
    Then I enter "80000000" text to declaration endorsement text area at index 1

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
  #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    When I click element: next button at index 1
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait financial information area element 30 seconds at index 1
    When I click element: financial information area at index 1
    Then I verify the area segment area by declaration endorsement text area by segmentation at index 1

#TC212 'den alınması gereken diğer testlerde düzeltilmesi gereken kısımlar var. #   Then I have to check is there any document is uploaded on the address area at index 1 for telephone
  #check button at index 3 değil de 1

  @Finco
  Scenario: TC212 -E2E - Customer Management - Detailed Information - Merchant Customer
    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
 #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426
    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait permission marketing area element 30 seconds at index 1
    When I click element: permission marketing area at index 1
    And I wait permission marketing no permission button element 30 seconds at index 1
    When I click element: permission marketing no permission button at index 1
    And I wait documents section area element 30 seconds at index 1
    When I click element: documents section area at index 1
    Then I have to check is there any document is uploaded on the address area at index 1 for telephone
    And I wait save section area element 30 seconds at index 1
    When I click element: save section area at index 1
    And I wait save button for customer information element 30 seconds at index 1
    When I click element: save button for customer information at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "40000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions for 40000 element 30 seconds at index 1
    When I click element: customer transactions for 40000 at index 1
    Then I see customerTransactions page
    And I wait customer management button element 30 seconds at index 1
    When I click element: customer management button at index 1
 #5426
    Then I get the data from Excel file to element: customer code text area at index 1 for 5426
    When I click element: search button at index 1
    Then I need to just wait
    Then I need to Title verify for name title text area match from Excel file at index 1 for 5426

    And I wait contact information section area element 30 seconds at index 1
    When I click element: contact information section area at index 1
    And I wait telephone information area element 30 seconds at index 1
    When I click element: telephone information area at index 1
    And I wait telephone new button element 30 seconds at index 1
    When I click element: telephone new button at index 1
    When I select element: "TÜRKİYE" under telephone country selection at index 2
    When I select element: "CEP TELEFONU" under telephone type selection at index 2
    Then I enter a telephone number to telephone number text area at index 1
    When I click element: priority telephone button at index 1
    When I click element: telephone add button at index 1
    Then I need to just wait
    And I wait telephone warning close button element 30 seconds at index 1
    When I click element: telephone warning close button at index 1
    When I select element: "KREDİ KAYIT BÜROSU (KKB) TARAFINDA DOĞRULANMAMIŞTIR" under reason for not verification selection at index 1
    And I wait reason add button element 30 seconds at index 1
    When I click element: reason add button at index 1
    Then I need to checkbox verify for priority telephone checkbox at index 5

    And I wait detail information section area element 30 seconds at index 1
    When I click element: detail information section area at index 1

    And I wait permission marketing area element 30 seconds at index 1
    When I click element: permission marketing area at index 1
    And I wait permission marketing button element 30 seconds at index 1
    Then I need to checkbox verify for permission marketing yes button at index 1
