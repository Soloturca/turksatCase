#Author: Sachin Kelkar
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@Payment
Feature: Pay PCN and Pay to Drive in London
    
 #Background: Login to Mobile App successfully
 #		Given LoginToMobileApp
 #Scenario: Pay Penalty
 #		 Then PayPCN
 #Scenario: Pay to Drive in London
 #		 Then PayToDrive
 
Scenario: Pay to Drive in London and Pay Penalty for an existing PCN
   Given LoginToMobileApp
   Then PayPCN
   And PayToDrive
 
Scenario: Pay to Drive in London
	Given LoginToMobileApp
	Then PayToDrive
 		
Scenario: Pay PCN
		Given LoginToMobileApp
		Then PayPCN

Scenario: Pay to Drive in London As Registered User
 		Given LoginToMobileApp
 		Then PayToDriveAsRegisteredUser
 		Then LogOut
 		
 
 		
 
 
 
 		
    
