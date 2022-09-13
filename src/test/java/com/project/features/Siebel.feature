Feature: Siebel

  @handsUpSquad
  Scenario: Open URL Test
    Given Open the https://172.31.70.3/callcenter_enu/ URL

    When I see Security page
    Then I click element: security step see all at index 1
    And I click element: security step override at index 1

    When I see siebelLogin page
    Then I enter "VF_OTOAGILE" text to username text area at index 1
    And I enter "VF_OTOAGILE" text to password text area at index 1

    When I click element: login button at index 1
    Then I see siebelHome page
    And I click "siebelOrdersMenu" image element

    And I need to just wait