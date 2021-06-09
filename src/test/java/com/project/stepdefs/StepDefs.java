package com.project.stepdefs;

import com.project.tests.ClickTitleInTheLeftMenuTest;
import com.project.tests.LoginPageTest;
import com.project.tests.LogoutOfSystemTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.saf.framework.CommonLib;
import com.saf.framework.HashMapNew;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;
import page.OurBasePage;

import java.sql.SQLException;

public class StepDefs {
    CommonLib commonLib;
    WebDriver oDriver;


    @Given("^Open the (.*) URL$")
    public void openUrl(String url) {

        CommonLib.navigateToURL(oDriver, url);
    }

    @When("^I see (.*) page$")
    public void seePage(String page) {
        commonLib.seePage(page);
    }


    @When("^(?:I )?click element: (\\w+(?: \\w+)*) index: (\\d+)$")
    public void clickElement(String element,int index) {
        WebElement object = commonLib.findElement(element,index);

        if (object != null) {
            object.click();
            System.out.println("Clicked on object-->" + element);
        } else {
            System.out.println("Could not click on object-->" + element);
        }
    }
    @When("^I enter \"([^\"]*)\" text to (.*) text area$")
    public void enterText(String text, String element) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.findElement(element,0);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }
}