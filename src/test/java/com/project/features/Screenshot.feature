Feature: Screenshot

  @Test
  Scenario Outline: Open URL Test
    Given Open the http://10.144.15.143:7782/frameset/login.action URL
    When I see loginPage page
    Then I enter "vfpcteam" text to username text area at index 1
    And I enter "Offer123456**" text to password text area at index 1

    When I click "loginButton" image element
    Then I click "moreInformation" image element
    And I click "goToWebPage" image element
    
    When I need to just wait
    Then I click "individualButton" image element
    And I need to just wait

    When I enter "5490011839" text to subscriber number at index 1
    Then I click "individualMenuSubmitButton" image element
    And I need to just wait

    #When I click element: login button at index 1
    #Then I click element: security step see all at index 1
    #And I click element: security step override at index 1

    #When I switch to window
    #Then I see icbsHome page
    #And I click element: individual menu at index 1

    #When I switch to frame:tabPageIfra1 frame type:name
    #Then I switch to frame:<path> frame type:xpath
    #And I enter "5490011839" text to subscriber number at index 1

    #When I click element: submit button at index 1

    Examples:
    | path |
    | //div[@class='panel current']//iframe[1] |