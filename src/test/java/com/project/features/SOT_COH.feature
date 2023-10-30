Feature: SOT-COH

  @handsUpSquad
  Scenario: SOT-COH
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I maximize the window
    Given I do TCKN api call
    When I see tariffPage page
    And I wait for 3 seconds
    Then I click element: move your number button at index 1
    And I wait for 5 seconds
    And I scroll down by 500 unit

    And I wait for 3 seconds
    And I see element: paket sec button at index 1
    Then I click element: paket sec button at index 1
    #And I see tarife karti element: paket sec button at index 1
    #And I click tarife karti element: paket sec button at index 1

    When I enter "5559981217" text to phone number input area at index 1
    Then I click element: Onayla button at index 1

    When I enter "1111" text to OTP code input area at index 1
    Then I click element: Onayla button at index 1

    And I see element: name input area at index 1
    When I enter "OFFER" text to name input area at index 1
    Then I enter "UI" text to surname input area at index 1
    And I enter tckn to "tckn input area"
    When I enter "OFFERUI" text to father name input area at index 1
    Then I enter "12121999" text to date of birth input area at index 1
    And I click element: submit button at index 1

    And I wait for 5 seconds
    Then I click element: deliver to shop selection at index 1
    And I wait for 5 seconds
    And I scroll down by 500 unit
    And I wait for 3 seconds
    Then I click element: city selection at index 1
    And I wait for 5 seconds
    Then I click element: city selection Ankara button at index 1
    And I wait for 5 seconds
    Then I click element: district selection at index 1
    And I wait for 5 seconds
    Then I click element: district selection Akyurt button at index 1
    And I wait for 5 seconds
    Then I click element: neighbourhood selection at index 1
    And I wait for 5 seconds
    Then I click element: neighbourhood selection Ataturk button at index 1
    And I wait for 5 seconds
    Then I click element: street selection at index 1
    And I wait for 5 seconds
    Then I click element: street selection babacan button at index 1
    And I wait for 5 seconds
    Then I click element: bina selection at index 1
    And I wait for 5 seconds
    Then I click element: bina selection 1 button at index 1
    And I wait for 5 seconds
    Then I enter "merkez" text to address input box at index 1
    And I wait for 5 seconds
    And I enter "abc@gmail.com" text to email input box at index 1


    When I see element: continue button at index 1
    Then I click element: continue button at index 1
    And I wait for 5 seconds


    Then I execute update sql

    #DPC
    Given Open the http://sot-ui-hf.apps.mbt.vodafone.local/login URL

    When I see login page
    Then I enter "VF_GENERIC9" text to username text area at index 1
    And I enter "Voda12345678" text to password text area at index 1

    When I click element: login button at index 1
    Then I enter "222222" text to OTP text area at index 1
    And I click element: OTP submit button at index 1

    When I see musteriPortali page
    Then I click element: hamburger menu at index 1
    And I wait for 3 seconds
    And I click element: activation menu button at index 1
    And I wait for 3 seconds
    When I click element: tam senlik menu button at index 1
    And I wait for 3 seconds
    Then I enter tckn to "tam senlik tckn input area"
    When I click element: sorgula button at index 1
    And I wait for 20 seconds
