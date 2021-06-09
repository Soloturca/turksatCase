package com.project.tests;

import page.LoginPage;
import com.saf.framework.MyTestNGBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutOfSystemTest extends MyTestNGBaseClass {
    @Test(description = "It is tested whether the user has successfully logout.")
    public void test_LogoutOfSystem() {
        LoginPage loginPage = new LoginPage(oDriver, oExtentReport, oExtentTest, dataMap);
        //Test is start here.
        startTest();
        //It is checked whether the user has successfully logout.
        Assert.assertTrue(loginPage.logoutOfSystem());
    }
}
