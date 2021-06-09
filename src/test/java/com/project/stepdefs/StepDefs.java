package com.project.stepdefs;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class StepDefs extends MyTestNGBaseClass {
    CommonLib commonLib = new CommonLib();
    int timeout=30;

    @When("^I initialize ([^\"]*) driver and run test local=([^\"]*)$")
    public  void initializeChromeDriver(String browser,Boolean isLocal) throws MalformedURLException
    {
       // MyTestNGBaseClass.
    }

    @Given("^Open the (.*) URL$")
    public void openUrl(String URL) {

        CommonLib.navigateToURL(oDriver, URL);
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
    @When("^I enter \"([^\"]*)\" text to (.*)$")
    public void enterText(String text, String element) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element,timeout,1);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    @When("^I wait (.*) element (\\d+) seconds at index (\\d+)$")
    public void waitElement(String element, int timeout, int index) throws InterruptedException {
        commonLib.waitElement(element, timeout, index);
    }
}