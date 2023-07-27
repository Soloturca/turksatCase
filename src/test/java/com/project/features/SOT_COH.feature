Feature: SOT-COH

  @handsUpSquad
  Scenario: SOT-COH
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Given I do TCKN api call

    When I see tariffPage page
    Then I click element: move your number button at index 1
    And I scroll down by 500 unit

    When I click element: swipe right button 1 at index 1
    Then I see element: COH kirmizi firsat paketi at index 1
    And I click element: COH kirmizi firsat paketi select tariff button at index 1

    When I enter "5559992324" text to phone number input area at index 1
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

    When I click element: "deliver to shop selection" if it exists at index 1
    Then I click element: city selection at index 1
    Then I click element: city selection Ankara button at index 1
    Then I click element: district selection at index 1
    Then I click element: district selection Akyurt button at index 1

    Then I click element: neighbourhood selection at index 1
    Then I click element: neighbourhood selection Ataturk button at index 1
    Then I enter "merkez" text to address input box at index 1
    And I enter "abc@gmail.com" text to email input box at index 1

    When I see element: continue button at index 1
    Then I click element: continue button at index 1
    And I wait for 60 seconds

    #Given I execute update sql

  Scenario: SOT-DPC
    Given Open the http://sot-ui-hf.apps.mbt.vodafone.local/login URL

    When I see login page
    Then I enter "VF_GENERIC9" text to username text area at index 1
    And I enter "Voda12345678" text to password text area at index 1

    When I click element: login button at index 1
    Then I enter "222222" text to OTP text area at index 1
    And I click element: OTP submit button at index 1

    When I see musteriPortali page
    Then I click element: hamburger menu at index 1
    And I click element: activation menu button at index 1

    When I click element: tam senlik menu button at index 1
    Then I enter tckn to "tam senlik tckn input area"
    
    And I wait for 20 seconds