Feature: Orion Finance Finco Test Scenarios

  #Scenario Outline: Login to Orion Finance
   # Given Login to Orion Finance with "<username>" and "<password>" and "<url>"
  #Then Click "<menuTitle>" in the left menu.

  #Examples:
  #| username| password | url |     | menuTitle|
  #| admin |    | http://orion-finance-finco-adtest.apps.mbt.vodafone.local/| | Müşteri İşlemleri |

Scenario: Login Finco
  Given Open the http://orion-finance-finco-adtest.apps.mbt.vodafone.local/ URL
  Then I see login page
  And I enter "admin" text to username text area
  Then I enter "" text to password text area
  When I click element: login button index: 1
