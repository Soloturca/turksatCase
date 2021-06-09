package com.project.tests;

import com.saf.framework.MyTestNGBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginPageTest extends MyTestNGBaseClass {
    @Test(description = "It tests whether the user is properly logged into the system.")
    public void test_LoginToSystem(String username, String password, String url) {
        LoginPage loginPage = new LoginPage(oDriver, oExtentReport, oExtentTest, dataMap);
        //Validate login page
        startTest();
        //It checks that the user is correctly logged into the system.
        Assert.assertTrue(loginPage.loginToSystem(username, password, url));
    }
}
