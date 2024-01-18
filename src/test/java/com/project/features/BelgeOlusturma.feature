Feature: Belge Olusturma


  Scenario: Tek imzacili resmi yazi olusturulmasi

    Given Open the https://www.belgenet.com.tr/ URL
    And I wait for 3 seconds
    Then I see loginPage page
    And I wait demoButton element 5 seconds at index 1
    Then I click element: demoButton at index 1
    And I wait for 3 seconds
    Then I enter "botcu" text to usernameTextBox at index 1
    And I wait for 3 seconds
    Then I enter "spider" text to passwordTextBox at index 1
    And I wait for 3 seconds
    Then I click element: girisYapButton at index 1
    And I wait for 10 seconds
    Then I see evrakOlusturPage page
    And I wait evrakIslemleriButton element 5 seconds at index 1
    Then I click element: evrakIslemleriButton at index 1
    And I wait evrakOlusturButton element 5 seconds at index 1
    Then I click element: evrakOlusturButton at index 1
    And I wait for 15 seconds
    And I wait kaldirilacakKlasorler element 5 seconds at index 1
    Then I click element: kaldirilacakKlasorler at index 1
    And I wait treeKlasorButton element 5 seconds at index 1
    Then I click element: treeKlasorButton at index 1
    And I wait turksatText element 5 seconds at index 1
    Then I click element: turksatText at index 1
    And I wait for 5 seconds
    And I wait bilgiTreeIcon element 5 seconds at index 1
    Then I click element: bilgiTreeIcon at index 1
    And I wait for 10 seconds
    And I wait birimMenuButton element 5 seconds at index 1
    Then I click element: birimMenuButton at index 1
    And I wait for 10 seconds
    And I wait altTestBirimiButton element 5 seconds at index 1
    Then I click element: altTestBirimiButton at index 1
    And I wait for 10 seconds
    And I wait geregiButton element 5 seconds at index 1
    Then I click element: geregiButton at index 1
    And I wait kullanıcıButton element 5 seconds at index 1
    Then I click element: kullaniciButton at index 1
    And I wait bilgiTreeIconGeregi element 5 seconds at index 1
    Then I click element: bilgiTreeIconGeregi at index 1
    And I wait birimMenuButtonGeregi element 5 seconds at index 1
    Then I click element: birimMenuButtonGeregi at index 1
    And I wait altTestBirimiButtonGeregi element 5 seconds at index 1
    Then I click element: altTestBirimiButtonGeregi at index 1
    And I wait ekleButton element 5 seconds at index 1
    Then I click element: ekleButton at index 1
    And I wait paraflamaButton element 5 seconds at index 1
    Then I click element: paraflamaButton at index 1
    And I wait imzalamaButton element 5 seconds at index 1
    Then I click element: imzalamaButton at index 1
    And I wait otomatikOnayAkisiButton element 5 seconds at index 1
    Then I click element: otomatikOnayAkisiButton at index 1
    And I wait personelCheckBox element 5 seconds at index 1
    Then I click element: personelCheckBox at index 1
    And I wait kullanButton element 5 seconds at index 1
    Then I click element: kullanButton at index 1
    And I wait editorButton element 5 seconds at index 1
    Then I click element: editorButton at index 1
    And I wait bodyTextBox element 5 seconds at index 1
    Then I click element: bodyTextBox at index 1
    Then I enter "test" text to bodyTextBox at index 1
    And I wait imzalaButton element 5 seconds at index 1
    Then I click element: imzalaButton at index 1
    And I wait sImzaButton element 5 seconds at index 1
    Then I click element: sImzaButton at index 1
    And I wait lastImzalaButton element 5 seconds at index 1
    Then I click element: lastImzalaButton at index 1
    And I wait evetButton element 5 seconds at index 1
    Then I click element: evetButton at index 1
    And I wait islemYaptiklarim element 5 seconds at index 1
    Then I click element: islemYaptiklarim at index 1
    And I wait imzaladiklarimButton element 5 seconds at index 1
    Then I click element: imzaladiklarimButton at index 1
    And I wait belgeGormeButton element 5 seconds at index 1
    Then I click element: belgeGormeButton at index 1
    And I wait for 10 seconds
    And I wait birimEvraklariButton element 5 seconds at index 1
    Then I click element: birimEvraklariButton at index 1
    And I wait teslimAlinmayiBekleyenlerButton element 5 seconds at index 1
    Then I click element: teslimAlinmayiBekleyenlerButton at index 1
    And I wait for 10 seconds





