package com.project.stepdefs;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

public class StepDefs extends MyTestNGBaseClass {
    CommonLib commonLib = new CommonLib();
    int timeout = 30;
    public String uuid = UUID.randomUUID().toString();

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

    @When("^(?:I )?click element: (\\w+(?: \\w+)*)")
    public void clickElement(String element) {
        int index = 1;
        WebElement object = commonLib.findElement(element, index);

        try {
            if (object != null) {
                object.click();
                System.out.println("Clicked on object-->" + element);
                reportResult("PASS", "I click " + element + " element.(element found)", false);
            } else {
                System.out.println("Could not click on object-->" + element);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not click " + element + " element.(element not found)", true);
        }
    }

    @Then("^I enter \"([^\"]*)\" text to (.*)$")
    public void enterText(String text, String element) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The text has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }

    @Then("^I enter unique text to (.*)$")
    public void uniqueText(String element) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);
        String text = "automation" + uuid;
        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The text has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }

    @Then("^I clear text to (.*)$")
    public void clearText(String element) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "a");
                object.sendKeys(Keys.DELETE);
                Thread.sleep(1000);
                System.out.println("The text has been deleted.");
                reportResult("PASS", "I deleted the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not deleted the text ", true);
        }

    }

    @And("^I wait (.*) element (\\d+) seconds")
    public void waitElement(String element, int timeout) throws InterruptedException {
        int index = 1;
        commonLib.waitElement(element, timeout, index);
    }

    @When("^(?:I )?select element: (\\w+(?: \\w+)*)")
    public void selectElement(String element) {
        int index = 1;
        WebElement object = commonLib.findElement(element, index);
        try {
            if (object != null) {
                object.click();
                System.out.println("Select the object type-->" + element);
                reportResult("PASS", "I selected " + element + " element.(element selected)", false);
                Select select = new Select(object);
                select.selectByVisibleText("Grup Kaydetme");

            } else {
                System.out.println("Could not select the object type-->" + element);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not select " + element + " element.(element not selected)", true);
        }
    }


    @And("^I need to just wait")
    public void justWait() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Then("^(?:I )?get the information: (\\w+(?: \\w+)*)")
    public void getTheReferenceNumber(String element) {
        int index = 1;
        String object = commonLib.getTheElementInformation(element, index);

    }

    @When("^(?:I )?double click element: (\\w+(?: \\w+)*)")
    public void doubleClickElement(String element) {
        int index = 1;
        WebElement object = commonLib.findElement(element, index);
        commonLib.doubleClickElement(object);
    }


    @Then("^I enter my \"([^\"]*)\" text to (.*)$")
    public void dynamicText(String text, String element) throws InterruptedException {
        text = commonLib.referenceNumber;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The reference number:" + text + " " + "has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }
}