package com.project.tests;

import com.saf.framework.MyTestNGBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasePage;


public class ClickTitleInTheLeftMenuTest extends MyTestNGBaseClass {
    @Test(description = "This test controls the navigation for desired menu")
    public void test_clickInTheLeftMenu (String textTitle){
        BasePage basePage=new BasePage(oDriver, oExtentReport, oExtentTest,dataMap);
        //The test starts.
        startTest();
        //It is checked whether the Dealer Search page has been accessed.
        Assert.assertTrue(basePage.gotoTheDesiredPageInTheLeftMenu(oDriver,textTitle));

    }
}
