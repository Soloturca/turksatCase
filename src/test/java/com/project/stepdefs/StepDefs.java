package com.project.stepdefs;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StepDefs extends MyTestNGBaseClass {
    CommonLib commonLib = new CommonLib();
    int timeout = 30;

    @Before
    public void setReportName(Scenario scenario) {
        commonLib.startTest(scenario.getName());
    }

    @Given("^Open the (.*) URL$")
    public void openUrl(String URL) {
        CommonLib.navigateToURL(oDriver, URL);
    }

    @Then("^I see (.*) page$")
    public void seePage(String page) {
        commonLib.seePage(page);
    }

    @When("^(?:I )?click element: (\\w+(?: \\w+)*) index: (\\d+)$")
    public void clickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);

        if (object != null) {
            object.click();
            System.out.println("Clicked on object-->" + element);
        } else {
            System.out.println("Could not click on object-->" + element);
        }
    }

    @When("^(?:I )?select element: (\\w+(?: \\w+)*) index: (\\d+)$")
    public void selectElement(String element, int index) {

        WebElement object = commonLib.findElement(element, index);

        if (object != null) {
            object.click();
            System.out.println("Select the object type-->" + element);

            Select select = new Select(object);
            select.selectByVisibleText("Grup Kaydetme");

        } else {
            System.out.println("Could not select the object type-->" + element);
        }
    }

    @Then("^I enter \"([^\"]*)\" text to (.*)$")
    public void enterText(String text, String element) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    @And("^I wait (.*) element (\\d+) seconds at index (\\d+)$")
    public void waitElement(String element, int timeout, int index) throws InterruptedException {
        commonLib.waitElement(element, timeout, index);
    }

    @Then("^(?:I )?get the information: (\\w+(?: \\w+)*) index: (\\d+)$")
    public void getTheReferenceNumber(String element, int index) {
        String object = commonLib.getTheElementInformation(element, index);
    }

    @When("^(?:I )?double click element: (\\w+(?: \\w+)*) index: (\\d+)$")
    public void doubleClickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        commonLib.doubleClickElement(object);
    }


    @Then("^I enter my \"([^\"]*)\" text to (.*)$")
    public void dynamicText(String text, String element) throws InterruptedException {
        text = commonLib.referenceNumber;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The reference number:" + text + "has been entered.");
        }
    }
}