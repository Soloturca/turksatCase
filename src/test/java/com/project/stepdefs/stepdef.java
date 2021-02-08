package com.project.stepdefs;


import java.util.Date;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.project.tests.*;


public class stepdef {
				
				
				@Given("^LoginToMobileApp$")
				public void LoginToTfLApp() throws Throwable {
					LoginToMobileApp obj = new LoginToMobileApp();
					obj.test_LoginToMobileApp();
				}
				
				/*@When("^SwitchUser$")
				public void switchuser() throws Throwable {
				    // Write code here that turns the phrase above into concrete actions
				    SwitchUser obj = new SwitchUser();
				    obj.validation();
				}*/
				
				
				@Then("^PayPCN$")
				public void PayPCN() throws Throwable {
				    // Write code here that turns the phrase above into concrete actions
					testPayPCN obj = new testPayPCN();
				    obj.test_PayPCN();
				}
				
				//@Then("^PayToDrive$")
				@And("^PayToDrive$")
				public void payToDrive() throws Throwable {
					testNewPayToDrive obj = new testNewPayToDrive();
					obj.test_PayToDrive();
				}
				
				@Then("^PayToDriveAsRegisteredUser")
				public void payToDriveAsRegisteredUser() throws Throwable {
					testSignedInUserPayToDrive obj = new testSignedInUserPayToDrive();
					obj.test_SignedInUserPayToDrive();
				}
				
				@And("^LogOut")
				public void logOut() throws Throwable {
					LogOutOfMobileApp obj = new LogOutOfMobileApp();
					obj.test_LogOutOfMobileApp();
				}
				
				/*@Then("^ValidateAccountListView$")
				public void ValidateAccountListView() throws Throwable {
				    // Write code here that turns the phrase above into concrete actions
					ValidateAccountListView obj = new ValidateAccountListView();
				    obj.validation();
				}*/
				
}
