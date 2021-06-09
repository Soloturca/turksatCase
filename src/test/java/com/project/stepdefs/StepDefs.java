package com.project.stepdefs;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class StepDefs extends MyTestNGBaseClass {
    CommonLib commonLib;
    //public static WebDriver oDriver;

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