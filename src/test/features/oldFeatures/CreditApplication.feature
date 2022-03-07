Feature: Credit Application
  
  @Test
  Scenario: Open URL Test
    Given Open the http://10.144.15.143:7782/frameset/login.action URL
    When I see loginPage page
    Then I enter "vfpcteam" text to username text area at index 1
    And I enter "Offer123456*" text to password text area at index 1

    When I click element: login button at index 1
    Then I click element: security step see all at index 1
    And I click element: security step override at index 1

    When I switch to child window
    Then I see icbsHome page
    And I click element: product menu at index 1