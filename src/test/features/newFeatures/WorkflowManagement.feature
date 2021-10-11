Feature: Orion Finance Finco Test Scenarios - İŞ AKIŞ

    #This feature includes these steps:
  #1.) E2E Work Flow - TC001
  # 2.) E2E Work Flow - TC002
  # 3.) E2E Work Flow - TC003
  # 4.) E2E Work Flow - TC004
  # 5.) E2E Work Flow - TC005
  # 6.) E2E Work Flow - TC006

  Background: System Login & Creating Job for unique reference number
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3003" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait customer transactions button element 30 seconds at index 1
    When I click element: customer transactions button at index 1
    Then I see customerTransactions page
    And I wait customer group management button element 30 seconds at index 1
    When I click element: customer group management button at index 1
    And I wait add new main group button element 30 seconds at index 1
    When I click element: add new main group button at index 1
    Then I enter unique text to main group name text area at index 1


    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1
    And I wait warning popup element 30 seconds at index 1
    Then I clear text to warning popup text area at index 1
    Then I enter "AUTOMATION" text to warning popup text area at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait reference number text area element 30 seconds at index 1
    Then I get the information: reference number text area at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    Then I see home page

  @Finco
  Scenario: Is Akis: TC001 - User Resumes Work that Started - Unit Officer
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    When I click element: jobs I started button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    When I select element: "Grup Kaydetme" under operation type selection at index 1

 #Then I enter "Note is entered!" text to transaction note text area
 # Selection Method sadece 'Grup Kaydetme' için çalışıyor.
    When I click element: query button at index 1
    And I wait return to inquiry button element 30 seconds at index 1
    When I click element: return to inquiry button at index 1

  @Finco
  Scenario: Is Akis: TC002 - Taking Over Pending Processes in the User's List - Unit Officer
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    When I click element: pending jobs button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    When I select element: "Grup Kaydetme" under operation type selection at index 1
   # Then I enter "Note is entered!" text to transaction note text area
# Selection Method sadece 'Grup Kaydetme' için çalışıyor.
    When I click element: query button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1

 #Unit Manager account should be login after this step:


    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    When I select element: "Grup Kaydetme" under operation type selection at index 1
 #  Then I enter my "Note is entered!" text to transaction note text area
 # Selection Method sadece 'Grup Kaydetme' için çalışıyor.
    When I click element: query button at index 1
    And I wait return to inquiry button element 30 seconds at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1


  @Finco
  Scenario: Is Akis: TC003 - Pending Jobs - [PRECONDITION FOR TC0004 - TC0005 - TC0006] - Unit Officer
    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait pending jobs button element 30 seconds at index 1
    When I click element: pending jobs button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
 #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait

 #And I wait row button element 30 seconds
 #When I click element: row button
 #And I wait warning popup element 30 seconds
 #When I click element: yes button

  @Finco
  Scenario: Is Akis: TC004 - Jobs Pending on My List - E2E Approving - Unit Manager
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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

    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
      #Assertion method
    Then I have to verify the text for: approve popup at index 1
    #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1


  @Finco
  Scenario: Is Akis: TC005 - E2E Assign to Pool - Unit Manager
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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
    And I wait assign to pool button element 30 seconds at index 1
    When I click element: assign to pool button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
       #Assertion method
    Then I have to verify the text for: assign to pool popup at index 1
   #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1


  @Finco
  Scenario: Is Akis: TC006 - E2E Cancel - Unit Manager
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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
    And I wait cancel button element 30 seconds at index 1
    When I click element: cancel button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
  #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1

  @Finco
  Scenario: Is Akis: TC007 - E2E Edit - Unit Manager
    And I wait close system button element 30 seconds at index 1
    When I click element: close system button at index 1

    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area at index 1
    Then I enter "1" text to password text area at index 1
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
    And I wait cancel button element 30 seconds at index 1
    When I click element: cancel button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
   #burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1