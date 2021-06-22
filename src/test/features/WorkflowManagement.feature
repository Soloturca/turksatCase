Feature: Orion Finance Finco Test Scenarios
  # 20210618-00020
  # Banu Altun (3003) - Unit Officer
  # Burak Sarıaslan (3004) - Unit Manager

  # iş oluşturulduktan hemen sonra unit manager'ın listesine düşüyor. Eğer ki officer bekleyen işlerde o işi üzerine alırsa manager o işi göremiyor.
  # bekleyen işler kısmı unit officer'ın, listemde bekleyen işler ise unit manager'ın.

  Background: System Login & Creating Job for unique reference number
    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "3003" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

    And I wait customer transactions button element 30 seconds
    When I click element: customer transactions button
    Then I see customerTransactions page
    And I wait customer group management button element 30 seconds
    When I click element: customer group management button
    And I wait add new main group button element 30 seconds
    When I click element: add new main group button
    Then I enter unique text to main group name text area


    And I wait save button element 30 seconds
    When I click element: save button
    And I wait warning popup element 30 seconds
    #Then I clear text to warning popup text area
    #Then I enter "AUTOMATION" text to warning popup text area
    When I click element: yes button
    And I wait reference number area element 30 seconds
    Then I get the information: reference number area
    And I wait close button element 30 seconds
    When I click element: close button
    Then I see home page

  @Finco
  Scenario: TC001 - User Resumes Work that Started - Unit Officer
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    When I click element: jobs I started button
    Then I enter my "reference number" text to reference number area
    When I select element: "Grup Kaydetme" under operation type selection
    #Then I enter "Note is entered!" text to transaction note text area
    #Selection Method sadece 'Grup Kaydetme' için çalışıyor.
    When I click element: query button
    And I wait return to inquiry button element 30 seconds
    When I click element: return to inquiry button

  @Finco
  Scenario: TC002 - Taking Over Pending Processes in the User's List - Unit Officer
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    When I click element: pending jobs button
    Then I enter my "reference number" text to reference number area
    When I select element: "Grup Kaydetme" under operation type selection
    #Then I enter "Note is entered!" text to transaction note text area
    #Selection Method sadece 'Grup Kaydetme' için çalışıyor.
    When I click element: query button
    When I click element: row button
    And I wait warning popup element 30 seconds
    #Then I clear text to warning popup text area
    #Then I enter "AUTOMATION" text to warning popup text area
    When I click element: yes button
    And I wait approve button element 30 seconds

    #Unit Manager account should be login after this step:


    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    When I select element: "Grup Kaydetme" under operation type selection
    # Then I enter my "Note is entered!" text to transaction note text area
    # Selection Method sadece 'Grup Kaydetme' için çalışıyor.
    When I click element: query button
    And I wait return to inquiry button element 30 seconds
    When I click element: row button
    And I wait warning popup element 30 seconds


  @Finco
  Scenario: TC003 - Pending Jobs - [PRECONDITION FOR TC0004 - TC0005 - TC0006] - Unit Officer
    And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page
    And I wait pending jobs button element 30 seconds
    When I click element: pending jobs button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button
    #Burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait

    #And I wait row button element 30 seconds
    #When I click element: row button
    #And I wait warning popup element 30 seconds
    #When I click element: yes button

  @Finco
  Scenario: TC004 - Jobs Pending on My List - E2E Approving - Unit Manager
    And I wait close system button element 30 seconds
    When I click element: close system button

    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

    #And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page


    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button

    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

    And I wait approve button element 30 seconds
    When I click element: approve button
    #Then I clear text to warning popup text area
    #Then I enter "AUTOMATION" text to warning popup text area
    And I wait yes button element 30 seconds
    When I click element: yes button
    #Burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds
    When I click element: close button


  @Finco
  Scenario: TC005 - E2E Assign to Pool - Unit Manager
    And I wait close system button element 30 seconds
    When I click element: close system button

    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

    #And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page


    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button

    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

    And I wait assign to pool button element 30 seconds
    When I click element: approve button
    #Then I clear text to warning popup text area
    #Then I enter "AUTOMATION" text to warning popup text area
    And I wait yes button element 30 seconds
    When I click element: yes button
    #Burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds
    When I click element: close button


  @Finco
  Scenario: TC006 - E2E Cancel - Unit Manager
    And I wait close system button element 30 seconds
    When I click element: close system button

    Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
    Then I see login page
    Then I enter "3004" text to username text area
    Then I enter "" text to password text area
    And I wait login button element 30 seconds
    When I click element: login button
    Then I see home page

    #And I wait workflow management button element 30 seconds
    When I click element: workflow management button
    Then I see workflowManagement page


    And I wait jobs pending on my list button element 30 seconds
    When I click element: jobs pending on my list button
    Then I enter my "reference number" text to reference number area
    And I wait inquire button element 30 seconds
    When I click element: inquire button

    When I click element: row button
    And I wait warning popup element 30 seconds
    When I click element: yes button

    And I wait cancel button element 30 seconds
    When I click element: cancel button
    #Then I clear text to warning popup text area
    #Then I enter "AUTOMATION" text to warning popup text area
    And I wait yes button element 30 seconds
    When I click element: yes button
    #Burada thread (hard) sleep kullanmazsak sistem patlıyor hata veriyor hızdan ötürü. Elementi beklemesine rağmen.
    And I need to just wait
    And I wait close button element 30 seconds
    When I click element: close button